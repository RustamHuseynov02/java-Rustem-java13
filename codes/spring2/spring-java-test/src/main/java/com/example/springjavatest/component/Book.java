package com.example.springjavatest.component;

import org.springframework.stereotype.Component;

@Component
public class Book {

	private Integer id;
	private String name;
	private Integer price;
	private Integer pageCount;
	
	public Book() {
		this.id = 22;
		this.name = "Thomas Shelby";
		this.price = 10;
		this.pageCount = 222;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", pageCount=" + pageCount + "]";
	}
	
	
}
