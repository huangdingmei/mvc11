package com.netshop.dao.implement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.netshop.dao.ItemsDao;
import com.netshop.jdbc.DAO;
import com.netshop.model.Items;
import com.netshop.pager.Expression;
import com.netshop.pager.PageBean;
import com.netshop.pager.PageConstants;

/**
 * @ClassName: ItemsDaoImpl
 * @Description: 商品模块持久层
 * @author  hdm
 * @date 创建时间：2016年3月31日 上午11:57:43 @version=1.0
 */
public class ItemsDaoImpl implements ItemsDao {
	private QueryRunner qr = new DAO();

	/**
	 * 删除商品
	 * @param itemid
	 * @throws SQLException
	 */
	public void delete(int itemid) throws SQLException {
		String sql = "delete from items where item_id=?";
		qr.update(sql, itemid);
	}

	/**
	 * 按商品名模糊查询
	 * @param iname
	 * @param pc
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Items> findByItemname(String iname, int pc) throws SQLException {
		List<Expression> exprList = new ArrayList<Expression>();
		exprList.add(new Expression("item_name", "like", "%" + iname + "%"));
		return findByCriteria(exprList, pc);
	}

	/**
	 * 按商品类别模糊查询
	 * @param itype
	 * @param pc
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Items> findByType(String itype, int pc) throws SQLException {
		List<Expression> exprList = new ArrayList<Expression>();
		exprList.add(new Expression("item_type", "like", "%" + itype + "%"));
		return findByCriteria(exprList, pc);
	}

	/**
	 * 通用的查询方法
	 * @param exprList
	 * @param pc
	 * @return
	 * @throws SQLException
	 */
	private PageBean<Items> findByCriteria(List<Expression> exprList, int pc) throws SQLException {
		int ps = PageConstants.Item_PAGE_SIZE;// 每页记录数

		// 通过exprList来生成where子句
		StringBuilder whereSql = new StringBuilder(" where 1=1");
		List<Object> params = new ArrayList<Object>();// SQL中有问号，它是对应问号的值
		for (Expression expr : exprList) {
			/*
			 * 添加一个条件上， 1) 以and开头 2) 条件的名称 3) 条件的运算符，可以是=、!=、>、< ... is null，is
			 * null没有值 4) 如果条件不是is null，再追加问号，然后再向params中添加一与问号对应的值
			 */
			whereSql.append(" and ").append(expr.getName()).append(" ").append(expr.getOperator()).append(" ");
			// where 1=1 and bid = ?
			if (!expr.getOperator().equals("is null")) {
				whereSql.append("?");
				params.add(expr.getValue());
			}
		}
		// 总记录数
		String sql = "select count(*) from items" + whereSql;
		Number number = (Number) qr.query(sql, new ScalarHandler(), params.toArray());
		int tr = number.intValue();// 得到了总记录数

		// 得到beanList，即当前页记录
		sql = "select * from items" + whereSql + " order by orderBy limit ?,?";
		params.add((pc - 1) * ps);// 当前页首行记录的下标
		params.add(ps);// 一共查询几行，就是每页记录数

		List<Items> beanList = qr.query(sql, new BeanListHandler<Items>(Items.class), params.toArray());

		// 创建PageBean，设置参数
		PageBean<Items> pb = new PageBean<Items>();

		// 其中PageBean没有url，这个任务由Servlet完成
		pb.setBeanList(beanList);
		pb.setPc(pc);
		pb.setPs(ps);
		pb.setTr(tr);

		return pb;
	}

	/**
	 * 添加商品
	 * @param item
	 * @throws SQLException
	 */
	public void add(Items item) throws SQLException {
		String sql = "insert into items(item_mid,item_name,item_money,"
				+ "item_gdate,item_caid,item_pic) values(?,?,?,?,?,?)";
		Object[] params = { item.getItem_mid(), item.getItem_name(), item.getItem_price(), item.getItem_gdate(),
				item.getItem_caid(), item.getItem_pic() };
		qr.update(sql, params);
	}
}
