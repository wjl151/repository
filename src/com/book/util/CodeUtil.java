package com.book.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;

/**
 * 验证码工具
 * @author 武金龙
 *
 */
public class CodeUtil {

	/**
	 * 生成随机验证码
	 * @return HashMap<验证码地址，答案>；
	 * @throws SQLException 
	 */
	public static String[] random(Connection con) throws SQLException {
		Random random = new Random();
		String[] code = new String[2];
		int g = random.nextInt(8)+1;
		String sql ="select ip,pass from code where id=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, g);
		ResultSet tt = pst.executeQuery();
		if(tt.next()) {
			code[0]=tt.getString("ip");
			code[1]=tt.getString("pass");
		}
		return code;
	}
}
