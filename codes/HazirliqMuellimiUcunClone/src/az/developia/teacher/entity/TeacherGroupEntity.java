package az.developia.teacher.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class TeacherGroupEntity {

	private Integer id;
	private String name;
	private Integer teacherId;
	private LocalDateTime registerDate;
	private Integer paymentDate;
	
	
	public TeacherGroupEntity(Integer id, String name, Integer teacherId, LocalDateTime registerDate,
			Integer paymentDate) {
		super();
		this.id = id;
		this.name = name;
		this.teacherId = teacherId;
		this.registerDate = registerDate;
		this.paymentDate = paymentDate;
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


	public Integer getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}


	public LocalDateTime getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}


	public Integer getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(Integer paymentDate) {
		this.paymentDate = paymentDate;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, name, paymentDate, registerDate, teacherId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeacherGroupEntity other = (TeacherGroupEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(paymentDate, other.paymentDate) && Objects.equals(registerDate, other.registerDate)
				&& Objects.equals(teacherId, other.teacherId);
	}


	@Override
	public String toString() {
		return "TeacherGroupEntity [id=" + id + ", name=" + name + ", teacherId=" + teacherId + ", registerDate="
				+ registerDate + ", paymentDate=" + paymentDate + "]";
	}
	
	
	public TeacherGroupEntity () {
		//default constructor
	}
}
