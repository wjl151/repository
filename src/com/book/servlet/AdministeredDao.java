package com.book.servlet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.model.Administered;
import com.book.model.Book;


/**
 * 管理员操作
 * @author 武金龙
 *
 */
public class AdministeredDao {
	/**
	 * 管理员登录
	 * @param con
	 * @param Adm
	 * @return
	 * @throws SQLException
	 */
	public Administered login(Connection con,Administered Adm) throws SQLException {
		Administered nowAdministered = null;
		String sql = "select * from administered where name=? and password=?";
		String name = Adm.getName();
		String password = Adm.getPassword();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, name);
		pst.setString(2, password);
		ResultSet aa = pst.executeQuery();
		if(aa.next()) {
			nowAdministered = new Administered();
			nowAdministered.setId(aa.getInt("id"));
			nowAdministered.setName(aa.getString("name"));
			nowAdministered.setPassword(aa.getString("password"));
		}
		return nowAdministered;
	}
	/**
	 * 添加图书
	 * @param con
	 * @param add
	 * @return 操作数
	 * @throws SQLException
	 */
	public int bookAdd(Connection con , Book add ) throws SQLException {
		
		int cnt = 0;
		String sql = "insert into book (name,price,author,category,IBSN,introductory) values (?,?,?,?,?,?)";
		String name = add.getName();
		double price = add.getPrice();
		String author = add.getAuthor();
		String category =add.getCategory();
		String IBSN = add.getIBSN();
		String introductory =add.getIntroductory();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, name);
		pst.setDouble(2, price);
		pst.setString(3, author);
		pst.setString(4, category);
		pst.setString(5, IBSN);
		pst.setString(6, introductory);
		cnt = pst.executeUpdate();
		return cnt;
	}
	
	/**
	 * 图书信息修改
	 * @param book
	 * @throws SQLException 
	 */
	public void bookUpdate(Connection con,Book book) throws SQLException {
		String sql = "update book set "
				+ "name=?,price=?,author=?,publishdate=?,category=?,IBSN=?,introductory=?,number=?,cover=? "
				+ "where "
				+ "id=?";
		String bookName = book.getName();
		double bookPrice = book.getPrice();
		String bookAuthor = book.getAuthor();
		Date date = book.getPublishdate();
		String bookCategory = book.getCategory();
		String IBSN = book.getIBSN();
		String introductory = book.getIntroductory();
		int bookNumber = book.getNumber();
		int id = book.getId();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, bookName);
		pst.setDouble(2, bookPrice);
		pst.setString(3, bookAuthor);
		pst.setDate(4, date);
		pst.setString(5, bookCategory);
		pst.setString(6,IBSN);
		pst.setString(7, introductory);
		pst.setInt(8,bookNumber);
		pst.setString(9,book.getCover());
		pst.setInt(10, id);
		int cnt =pst.executeUpdate();
		return ;
	}
	/**
	 * 删除图书
	 * @param con
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public int deleteBook(Connection con,int id) throws SQLException {
		String sql ="delete from book where id =?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		int cnt = pst.executeUpdate();
		return cnt;
	}
}
