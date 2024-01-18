package az.developia.springjava13.component;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(max = 20,min = 1,message = "kitabin adini dogru girin")
    private String name;
    private Double price;
    private Integer pageCount;
    @Size(max = 20,min = 1,message = "yazicin adini dogru girin")
    private String author;
    
	public Book() {
		this.id = 1;
		this.name = "Risale";
		this.price = 17.90;
		this.pageCount = 777;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", pageCount=" + pageCount + ", author="
				+ author + "]";
	}
	
	
	
	
    
    
    
}
