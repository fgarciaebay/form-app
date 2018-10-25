/**
 * 
 */
package com.iic.formapp.model;

/**
 * @author franciscogarcia
 *
 */
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
/*
 * This the Model Class. It maps the data in the table USER
 */

//@Entity is used for a persistent pojo class
@Entity
@Table(name="User")
public class User{
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String birthDate;
	// SimpleDateFormat birthDate = new SimpleDateFormat("dd-MM-yyyy");



	public User() {
		super();
	}
	public User(String firstName,String lastName, String email, String birthDate) {
		super();
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.birthDate=birthDate;
	}	
		

	
	@Column(name="firstName")

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	              
	@Column(name="lastName")
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="email")
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	//We don't use a Java Date type in order to avoid problems with different data formats
	//TODO Make performance test with String and DateFormat types
	
	@Column(name="birthDate")
	
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	@Id
	// @Column is used to map to related column in table
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
