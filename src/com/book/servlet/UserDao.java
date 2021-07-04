package com.book.servlet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

import com.book.model.Book;
import com.book.model.User;



/**
 * 用户操作
 * @author 武金龙
 *
 */
public class UserDao {
	/**
	 * 用户登录
	 * @param con
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public User login(Connection con,User user) throws SQLException {
		User resultUser=null;
		String sql = "select * from user where name=? and passWord=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1,user.getName());
		pst.setString(2, user.getPassword());
		ResultSet rr = pst.executeQuery();
		if(rr.next()) {
			resultUser = new User();
			resultUser.setId(rr.getInt("id"));
			resultUser.setName(rr.getString("name"));
			resultUser.setPassword(rr.getString("passWord")); 
			resultUser.setBirthday(rr.getDate("birthday"));
			resultUser.setPhone(rr.getString("phone"));
			resultUser.setAddress(rr.getString("address"));
			resultUser.setTopphone(rr.getString("topphone"));
			resultUser.setMony((double)rr.getFloat("mony"));
		}
		return resultUser;
	}

	/**
	 * 根据用户id刷新用户信息
	 * @param con
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public User userLoginId(Connection con, int id) throws SQLException {
		User resultUser=null;
		String sql = "select * from user where id=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1,id);
		ResultSet rr = pst.executeQuery();
		if(rr.next()) {
			resultUser = new User();
			resultUser.setId(rr.getInt("id"));
			resultUser.setName(rr.getString("name"));
			resultUser.setPassword(rr.getString("passWord"));
			resultUser.setBirthday(rr.getDate("birthday"));
			resultUser.setPhone(rr.getString("phone"));
			resultUser.setAddress(rr.getString("address"));
			resultUser.setTopphone(rr.getString("topphone"));
			resultUser.setMony((double)rr.getFloat("mony"));
		}
		return resultUser;
	}
	/**
	 * 用户添加
	 * @param con
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int userAdd(Connection con, User user) throws SQLException {
		String sql = "insert into user (name,passWord) values (?,?)";
		String name = user.getName();
		String password = user.getPassword();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, name);
		pst.setString(2, password);
		int cnt =pst.executeUpdate();
		return cnt;
	}
	
	/**
	 * 根据name查询用户是否存在
	 * @param con
	 * @param name
	 * @return int
	 * @throws SQLException
	 */
	public int userSelect(Connection con, String name) throws SQLException {
		String sql = "select * from user where name =?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, name);
		ResultSet ss = pst.executeQuery();
		int cnt = 0;
		if(ss.next()) {
			cnt=1;
		}
		return cnt;
		
	}
	/**
	 * 插入图书借阅信息,借书
	 * @throws SQLException 
	 * 
	 */
	public  int borrowBook(Connection con, Book book, int userID, double userMony) throws SQLException, InterruptedException {
		synchronized (book) {
			String sql = "insert into borrow (userid,bookid,outtime,endtime) values (?,?,?,?)";

			LocalDate nowTime = LocalDate.now();
			LocalDate endTime = nowTime.plusMonths(1);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, userID);
			pst.setInt(2, book.getId());
			pst.setDate(3, Date.valueOf(nowTime));
			pst.setDate(4, Date.valueOf(endTime));
			int cnt = pst.executeUpdate();
			Thread.sleep(1000*3);
			System.out.println(Thread.currentThread().getName());
			String sql2 = "update book set number =(number-1) where id =?";
			PreparedStatement pst2 = con.prepareStatement(sql2);
			pst2.setInt(1, book.getId());
			int cnt1 = pst2.executeUpdate();
//			Thread.sleep(1000*3);
			String sql3 = "update user set mony =? where id =?";
			PreparedStatement pst3 = con.prepareStatement(sql3);
			pst3.setFloat(1, (float) (userMony - book.getPrice()));
			pst3.setInt(2, userID);
			int cnt3 = pst3.executeUpdate();
			return cnt;
		}
	}
	/**
	 * 根据用户ID查询借阅中图书
	 * @param con
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public ResultSet selectNowBorrowBook(Connection con, int id) throws SQLException {
		String sql = "select "
				+ "a.outtime,a.endtime,b.name "
				+ "from "
				+ "borrow as a inner join book as b "
				+ "on a.bookid = b.id "
				+ "where a.userid =? and a.backtime is null";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet set = pst.executeQuery();
		return set;
	}
	
	/**
	 * 查看用户已归还书籍历史
	 * @param con
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ResultSet backSelectNowBorrowBook(Connection con, int id) throws SQLException {
		String sql = "select "
				+ "a.outtime,a.endtime,a.backtime,b.name "
				+ "from "
				+ "borrow as a inner join book as b "
				+ "on a.bookid = b.id "
				+ "where a.userid =? and a.backtime is not null";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet set = pst.executeQuery();
		return set;
	}
	/**
	 * 用户还书
	 * @param con
	 * @param userid
	 * @param bookName
	 * @param outtime
	 * @return
	 * @throws SQLException 
	 */
	public int returnBook(Connection con, int userid, String bookName, Date outtime) throws SQLException {
		
		String sql="select id from book where name =?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, bookName);
		ResultSet set = pst.executeQuery();
		int bookId = 0;
		 
		if(set.next()) {
			bookId = set.getInt("id");
		}
		
		set.close();
		pst.close();
		LocalDate backTime1 = LocalDate.now();
		Date backTime = Date.valueOf(backTime1);
		
		String sql1 = "update "
				+ "borrow "
				+ "set "
				+ "backtime =? "
				+ "where "
				+ "userid =? and outtime =? and bookid =? and backtime is  null limit 1";
		PreparedStatement pst1 = con.prepareStatement(sql1);
		pst1.setDate(1,backTime);
		pst1.setInt(2, userid);
		pst1.setDate(3, outtime);
		pst1.setInt(4, bookId);
		int cnt = pst1.executeUpdate();
		pst1.close();
		String sql2="update book set number =(number+1) where id =?";
		PreparedStatement pst2 = con.prepareStatement(sql2);
		pst2.setInt(1, bookId);
		int cnt1 = pst2.executeUpdate();
		return cnt;
	}
	/**
	 * 用户信息修改
	 * @param con
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int userMessageAlter(Connection con, User user) throws SQLException {
		String sql = "update user "
				+ "set "
				+ "name =?,password =?,phone =?,address =?,topphone =?"
				+ "where "
				+ "id =?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1,user.getName());
		pst.setString(2, user.getPassword());
		pst.setString(3, user.getPhone());
		pst.setString(4, user.getAddress());
		pst.setString(5,user.getTopphone());
		pst.setInt(6, user.getId());
		int cnt = pst.executeUpdate();
		return cnt;
	}
	/**
	 * 用户充值
	 * @param con
	 * @param Id
	 * @param Mony
	 * @return
	 * @throws SQLException
	 */
	public int userAddMony(Connection con, int Id, int Mony) throws SQLException {
		String sql = "update user "
				+ "set "
				+ "mony =(mony+?)"
				+ "where "
				+ "id =?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1,Mony);
		pst.setInt(2, Id);
		int cnt = pst.executeUpdate();
		return cnt;
	}

	/**
	 * 根据用户Id获取用户余额
	 * @param con
	 * @param Id
	 * @return
	 * @throws SQLException
	 */
	public int getUserNowMony(Connection con, int Id) throws SQLException {
		String sql = "select " +
				"mony " +
				"from " +
				"user " +
				"where " +
				"id=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, Id);
		ResultSet rr = pst.executeQuery();
		int cnt = 0;
		if (rr.next()) {
			cnt = rr.getInt("mony");
		}

		System.out.println(cnt);
		return cnt;

	}
}
