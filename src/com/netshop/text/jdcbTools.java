package com.netshop.text;



import java.sql.Connection;


import org.junit.Test;


import com.netshop.jdbc.JDBCTools;

public class jdcbTools {

	@Test
	public void testGetConnection()  throws Exception{
		Connection conn=JDBCTools.getConnection();
		System.out.println(conn);
	}

}
