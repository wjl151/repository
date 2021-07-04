package com.book.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;

/**
 * ��֤�빤��
 * @author �����
 *
 */
public class CodeUtil {

	/**
	 * ���������֤��
	 * @return HashMap<��֤���ַ����>��
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
