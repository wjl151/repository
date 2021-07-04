package com.book.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库操作
 * @author 武金龙
 *
 */
public class DataUtil {
	/**
	 * 连接数据库
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnectionLink() throws  Exception {
		Connection con = null;
//		Class.forName("com.mysql.cj.jdbc.Driver");
		String url ="jdbc:mysql://localhost:3306/booksystem"+"?serverTimezone=GMT%2B8"+"&allowPublicKeyRetrieval=true";
		con = DriverManager.getConnection(url, "root", "123q456WEWE");
		return con;
	}

}
