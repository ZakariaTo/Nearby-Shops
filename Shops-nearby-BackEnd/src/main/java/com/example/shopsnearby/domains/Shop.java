package com.example.shopsnearby.domains;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Shop {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String picture; 
	@OneToMany(mappedBy = "shop", fetch=FetchType.EAGER)
	private List<PreferredShop> shopliked=new ArrayList<>();
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shop(String name,String picture) {
		this.name=name;	this.picture=picture;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@JsonIgnore
	public List<PreferredShop> getShopliked() {
		return shopliked;
	}
	public void setShopliked(List<PreferredShop> shopliked) {
		this.shopliked = shopliked;
	}
	
	
	
}
