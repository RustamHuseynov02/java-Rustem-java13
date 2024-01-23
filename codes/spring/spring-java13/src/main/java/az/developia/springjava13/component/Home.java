package az.developia.springjava13.component;




import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "home")
public class Home {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Size(max = 20,min = 1,message = "unvani dogru daxil edin")
	private String address;
	@Size(max = 10,min = 1)
	private String color;

	public Home() {
		this.id = 1;
		this.address = "Sumqayit 3 mkr";
		this.color = "black";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@PostConstruct
	public void init() {
		System.out.println("init");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public String toString() {
		return "Home [id=" + id + ", address=" + address + ", color=" + color + "]";
	}
	
	

}
