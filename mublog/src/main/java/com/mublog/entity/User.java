package com.mublog.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name="users")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class User implements Serializable {

	/*
	  * private fields
	  * 
	  *
	  */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User()
	{
		
	}

	public User(long id, String firstName,String lastName, String userName, String emailId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.emailId = emailId;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@ManyToOne
	@JoinColumn(name = "RoleId")
	Role role;
	@Column(name = "FirstName")
	String firstName;
	@Column(name = "LastName")
	String lastName;
	@Column(name = "UserName")
	String userName;
	@Column(name = "Password")
	String password;
	@Column(name = "Email")
	String emailId;
	@Column(name = "IsActive")
	boolean isActive;
	@Column(name = "ConfPassword")
	String confPassword;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {				
		this.id = id;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getConfPassword() {
		return confPassword;
	}
	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}
	public Object getUserProfiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", password=" + password + ", emailId=" + emailId + ", isActive=" + isActive + ", confPassword="
				+ confPassword + "]";
	}
	
	
	
	
	
}
