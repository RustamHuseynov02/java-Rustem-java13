package com.teacher.program.entity;

import java.util.Objects;

public class TeacherEntity {
	private Integer id;
	private String name;
	private String surName;
	private String phone;
	private String address;
	private String userName;
	private String password;

	public TeacherEntity(Integer id, String name, String surName, String phone, String address, String userName,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.phone = phone;
		this.address = address;
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "TeacherEntity [id=" + id + ", name=" + name + ", surName=" + surName + ", phone=" + phone + ", address="
				+ address + ", userName=" + userName + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, id, name, password, phone, surName, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeacherEntity other = (TeacherEntity) obj;
		return Objects.equals(address, other.address) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(phone, other.phone) && Objects.equals(surName, other.surName)
				&& Objects.equals(userName, other.userName);
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

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TeacherEntity() {
		//default construct
	}
}
