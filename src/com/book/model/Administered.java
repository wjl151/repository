package com.book.model;

/**
 * ����Աʵ��
 * @author �����
 *
 */
public class Administered {
	private int id;                	//id
	private String name;       	 	//�û���
	private String password;      	//����
	
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
