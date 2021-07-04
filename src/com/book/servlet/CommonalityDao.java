package com.book.servlet;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import com.book.model.Book;

/**
 * ����������
 * @author �����
 *
 */
public class CommonalityDao {
	/**
	 * ����name��ͼ��
	 * @param con
	 * @param condition
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet bookInquire(Connection con,String condition) throws SQLException {
		ResultSet aa = null;
		String sql = "select * from book where name like '%"+condition+"%'";
		Statement std = con.createStatement();
		aa = std.executeQuery(sql);
		return aa;
	}
	
	/**
	 * ����ID����
	 * @param con
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Book bookInquire(Connection con,int id) throws SQLException {
		Book aa = null;

		String sql = "select * from book where id =?";

		PreparedStatement pst = con.prepareStatement(sql);

		pst.setInt(1, id);

		ResultSet af = pst.executeQuery();
		if(af.next()) {
			aa=new Book(af.getInt("id"), af.getString("name"), af.getDouble("price"),
					af.getString("author"), af.getDate("publishdate"), af.getString("category"), 
					af.getString("cover"),af.getString("IBSN"), af.getString("introductory"), 
					af.getInt("number"));
		}
		return aa;
		
	 }
	
	/**
	 * ��ѯ����������Ϊ0���鼮
	 * @param con
	 * @return HashSet<Book>
	 * @throws SQLException
	 */
	public HashSet<Book> onLibraryBookInquire(Connection con) throws SQLException {
		Book aa = null;
		HashSet<Book> allBook = new HashSet<Book>();
		String sql = "select * from book where number <> 0";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet af = pst.executeQuery();
		while(af.next()) {
			allBook.add(new Book(af.getInt("id"), af.getString("name"), af.getDouble("price"),
					af.getString("author"), af.getDate("publishdate"), af.getString("category"), 
					af.getString("cover"),af.getString("IBSN"), af.getString("introductory"), 
					af.getInt("number")));
		}
		return allBook;	
	 }
	/**
	 * ��ѯ����ͼ��
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public HashSet<Book> onLibraryAllBookInquire(Connection con) throws SQLException {
		Book aa = null;
		HashSet<Book> allBook = new HashSet<Book>();
		String sql = "select * from book";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet af = pst.executeQuery();
		while(af.next()) {
			allBook.add(new Book(af.getInt("id"), af.getString("name"), af.getDouble("price"),
					af.getString("author"), af.getDate("publishdate"), af.getString("category"), 
					af.getString("cover"),af.getString("IBSN"), af.getString("introductory"), 
					af.getInt("number")));
		}
		return allBook;	
	 }

	/**
	 * �����鼮Id��ȡ�鼮��������
	 * @param con
	 * @param bookId
	 * @return
	 * @throws SQLException
	 */
	public int getBookNumber(Connection con, int bookId) throws SQLException {
		String sql = "select " +
				"number " +
				"from " +
				"book " +
				"where " +
				"id=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1,bookId);
		ResultSet af = pst.executeQuery();
		int cnt = 0;
		while(af.next()) {
			cnt = af.getInt("number");
		}
		return cnt;
	}
}
