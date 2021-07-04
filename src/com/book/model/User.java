package com.book.model;

import java.util.Date;

/**
 * �û�ʵ��
 * @author �����
 *
 */
public class User {
	private int id;                	//id
	private String name;       	 	//�û���
	private String password;      	//����
	private Date birthday;        	//����
	private String phone;        	//�������·��
	private String address;   		//��ס��
	private String topphone;  		//ͷ��·��
	private double mony;			//�˻����
	
	
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
