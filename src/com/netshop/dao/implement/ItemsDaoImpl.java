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
 * @Description: ��Ʒģ��־ò�
 * @author  hdm
 * @date ����ʱ�䣺2016��3��31�� ����11:57:43 @version=1.0
 */
public class ItemsDaoImpl implements ItemsDao {
	private QueryRunner qr = new DAO();

	/**
	 * ɾ����Ʒ
	 * @param itemid
	 * @throws SQLException
	 */
	public void delete(int itemid) throws SQLException {
		String sql = "delete from items where item_id=?";
		qr.update(sql, itemid);
	}

	/**
	 * ����Ʒ��ģ����ѯ
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
	 * ����Ʒ���ģ����ѯ
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
	 * ͨ�õĲ�ѯ����
	 * @param exprList
	 * @param pc
	 * @return
	 * @throws SQLException
	 */
	private PageBean<Items> findByCriteria(List<Expression> exprList, int pc) throws SQLException {
		int ps = PageConstants.Item_PAGE_SIZE;// ÿҳ��¼��

		// ͨ��exprList������where�Ӿ�
		StringBuilder whereSql = new StringBuilder(" where 1=1");
		List<Object> params = new ArrayList<Object>();// SQL�����ʺţ����Ƕ�Ӧ�ʺŵ�ֵ
		for (Expression expr : exprList) {
			/*
			 * ���һ�������ϣ� 1) ��and��ͷ 2) ���������� 3) �������������������=��!=��>��< ... is null��is
			 * nullû��ֵ 4) �����������is null����׷���ʺţ�Ȼ������params�����һ���ʺŶ�Ӧ��ֵ
			 */
			whereSql.append(" and ").append(expr.getName()).append(" ").append(expr.getOperator()).append(" ");
			// where 1=1 and bid = ?
			if (!expr.getOperator().equals("is null")) {
				whereSql.append("?");
				params.add(expr.getValue());
			}
		}
		// �ܼ�¼��
		String sql = "select count(*) from items" + whereSql;
		Number number = (Number) qr.query(sql, new ScalarHandler(), params.toArray());
		int tr = number.intValue();// �õ����ܼ�¼��

		// �õ�beanList������ǰҳ��¼
		sql = "select * from items" + whereSql + " order by orderBy limit ?,?";
		params.add((pc - 1) * ps);// ��ǰҳ���м�¼���±�
		params.add(ps);// һ����ѯ���У�����ÿҳ��¼��

		List<Items> beanList = qr.query(sql, new BeanListHandler<Items>(Items.class), params.toArray());

		// ����PageBean�����ò���
		PageBean<Items> pb = new PageBean<Items>();

		// ����PageBeanû��url�����������Servlet���
		pb.setBeanList(beanList);
		pb.setPc(pc);
		pb.setPs(ps);
		pb.setTr(tr);

		return pb;
	}

	/**
	 * �����Ʒ
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
