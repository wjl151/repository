package com.book.model;

/**
 * 管理员实体
 * @author 武金龙
 *
 */
public class Administered {
	private int id;                	//id
	private String name;       	 	//用户名
	private String password;      	//密码
	
	public Administered(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public Administered() {
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
	
	
	
	
}
