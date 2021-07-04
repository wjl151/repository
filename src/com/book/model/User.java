package com.book.model;

import java.util.Date;

/**
 * 用户实体
 * @author 武金龙
 *
 */
public class User {
	private int id;                	//id
	private String name;       	 	//用户名
	private String password;      	//密码
	private Date birthday;        	//生日
	private String phone;        	//封面相对路径
	private String address;   		//居住地
	private String topphone;  		//头像路径
	private double mony;			//账户余额
	
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
	public User() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date string) {
		this.birthday = string;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTopphone() {
		return topphone;
	}
	public void setTopphone(String topphone) {
		this.topphone = topphone;
	}
	
	public double getMony() {
		return mony;
	}
	public void setMony(double mony) {
		this.mony = mony;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", birthday=" + birthday + ", phone="
				+ phone + ", address=" + address + ", topphone=" + topphone + "]";
	}
	
	
	
	
	
}
