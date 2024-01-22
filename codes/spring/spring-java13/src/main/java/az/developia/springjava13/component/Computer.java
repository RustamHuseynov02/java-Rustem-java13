package az.developia.springjava13.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "computers")
public class Computer {
	
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer id;
      @Size(max = 20, min = 1,message = "komputerin brandini duzgun daxil edin")
      private String brand;
      private Integer price;
      @Size(max = 20, min = 1,message = "komputerin colorunu duzgun daxil edin")
      private String color;

      
      
      public Computer() {
    	  this.id = 2;
    	  this.brand = "Asus";
    	  this.price = 1000;
    	  this.color = "Black";
      }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

      
	@PostConstruct
	public void init() {
		System.out.println("Computer classi contextde tam hazir olannan sonra ise dusur");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Computer classi bitdikden sonra iwe duwur ");
	}

	@Override
	public String toString() {
		return "Computer [id=" + id + ", brand=" + brand + ", price=" + price + ", color=" + color + "]";
	}

	
	
	
      
}
