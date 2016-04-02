package com.netshop.text;

import org.junit.Test;
import com.netshop.model.User;
import com.netshop.service.UserService;
import com.netshop.service.implement.UserServiceImpl;

public class UserServiceText {
	UserService  userService=new UserServiceImpl();

	
	@Test
	public void testLogin(){
		User user = new User();
		user.setUname("manager");
		user.setUpassword("123");
		if(null!=userService.login(user))
			System.out.println("------OK!!-----");
		else
			System.out.println("------Sorry!!-----");
	}
//
//	@Test
//	public void testRegister(){
//		User user = new User();
//		user.setUname("mana");
//		user.setUpassword("1111");
//		System.out.print(userService.regist(user));
//	}
	@Test
	public void testUpdate() {
		
	}

}
