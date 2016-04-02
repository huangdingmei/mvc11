package com.netshop.service.implement;

import java.sql.SQLException;

import com.netshop.dao.UserDao;
import com.netshop.dao.implement.UserDaoImpl;
import com.netshop.model.User;
import com.netshop.service.UserService;

/**
 * @ClassName: UserServiceImpl
 * @Description:用户模块业务层
 * @author  hdm
 * @date 创建时间：2016年3月31日 上午9:28:01 @version=1.0
 */
public class UserServiceImpl implements UserService {
	private UserDao userDAO = new UserDaoImpl();

	/**
	 * 登录功能
	 * @param user
	 * @return
	 */
	public User login(User user) {
		try {
			return userDAO.findByLoginnameAndnpass(user.getUname(), user.getUpassword());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 注册功能
	 * @param user
	 * @return
	 */
	public void regist(User user) {

		try {
			userDAO.add(user);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改用户信息
	 * @param user
	 */
	@Override
	public void update(User user) {
		try {
			userDAO.update(user);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 用户名注册校验
	 * @param uname
	 * @return
	 */
	public boolean ajaxValidateLoginname(String uname) {
		try {
			return userDAO.ajaxValidateLoginname(uname);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
