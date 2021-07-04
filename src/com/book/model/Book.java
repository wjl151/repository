package com.book.model;
/**
 * bookʵ��
 * @author �����
 *
 */

import java.sql.Date;


public class Book {
	private int id;     				//id
	private String name ; 				//����
	private double price; 				//�۸�
	private String author ; 			//����
	private Date publishdate ; 			//��������
	private String category ;  			//���
	private String cover;       		//����ͼƬ���·��
	private String IBSN ;     			//IBSN
	private String introductory ;		 //���
	private int number;                	//����
	public Book() {

	}

	public Book(int id) {
		this.id = id;
	}

	public Book(int id, String name, double price, String author, Date publishdate, String category, String cover,
				String iBSN, String introductory, int number) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.author = author;
		this.publishdate = publishdate;
		this.category = category;
		this.cover = cover;
		this.IBSN = iBSN;
		this.introductory = introductory;
		this.number = number;
	}

	public Book(String name, double price, String author, String category, String iBSN, String introductory) {
		this.name = name;
		this.price = price;
		this.author = author;
		this.category = category;
		IBSN = iBSN;
		this.introductory = introductory;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getIBSN() {
		return IBSN;
	}
	public void setIBSN(String iBSN) {
		IBSN = iBSN;
	}
	public String getIntroductory() {
		return introductory;
	}
	public void setIntroductory(String introductory) {
		this.introductory = introductory;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", author=" + author + ", publishdate="
				+ publishdate + ", category=" + category + ", cover=" + cover + ", IBSN=" + IBSN + ", introductory="
				+ introductory + ", number=" + number + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}

		Book book = (Book) obj;
		System.out.println(book.getId());
		System.out.println(this.id);
		if (book.getId() == this.id) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + (String.valueOf(id) == null ? 0 : String.valueOf(id).hashCode());
		return result;
	}
}
