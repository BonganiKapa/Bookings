package airline.bookings.bean;

import java.io.Serializable;

public class EditBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String lastName;
	private String phone;
	private String cell;
	private String addres;
	private String email;
	private String password;
	private String repassowrd;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCell() {
		return cell;
	}
	public void setCell(String cell) {
		this.cell = cell;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
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
	public String getRepassowrd() {
		return repassowrd;
	}
	public void setRepassowrd(String repassowrd) {
		this.repassowrd = repassowrd;
	}
	
	
}
