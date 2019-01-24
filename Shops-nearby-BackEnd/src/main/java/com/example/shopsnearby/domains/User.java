package com.example.shopsnearby.domains;


import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String fullName;
	private String email;
	private String userName;
	private String password;
	@OneToMany(mappedBy="user",fetch=FetchType.EAGER)
	private List<PreferredShop> shopsliked;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String fullName,String username,String email,String password) {
		this.fullName=fullName;
		this.email=email;
		this.userName=username;
		this.password=password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	@JsonIgnore
	public List<PreferredShop> getShopsliked() {
		return shopsliked;
	}
	public void setShopsliked(List<PreferredShop> shopsliked) {
		this.shopsliked = shopsliked;
	}
	
	
}
