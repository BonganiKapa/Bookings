package airline.bookings.bean;

import java.io.Serializable;

public class ClientBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String surname;
	private String idNm;
	private String gender;
	private String address;
	private String cell;
	private String phone;
	private String email;
	private String password;
	private String repasssword;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getIdNm() {
		return idNm;
	}
	public void setIdNm(String idNm) {
		this.idNm = idNm;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCell() {
		return cell;
	}
	public void setCell(String cell) {
		this.cell = cell;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepasssword() {
		return repasssword;
	}
	public void setRepasssword(String repasssword) {
		this.repasssword = repasssword;
	}
	
}