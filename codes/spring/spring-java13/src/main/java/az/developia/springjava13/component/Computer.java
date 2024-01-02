package az.developia.springjava13.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Computer {
      private Integer id;
      private String brand;
      private Integer price;
      private String color;
      @Autowired
      @Qualifier(value = "ram")
      private Ram ram;
      
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

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}
      
	@PostConstruct
	public void init() {
		System.out.println("Computer classi contextde tam hazir olannan sonra ise dusur");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Computer classi bitdikden sonra iwe duwur ");
	}
      
}
