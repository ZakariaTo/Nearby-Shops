package com.example.shopsnearby.domains;
import java.util.Date;

import javax.persistence.*;
@Entity
public class PreferredShop {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;
	@ManyToOne
	@JoinColumn(name="id_shop")
	private Shop shop;
	private Date likedate;
	public PreferredShop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PreferredShop(User user, Shop shop, Date likedate) {
		super();
		this.user = user;
		this.shop = shop;
		this.likedate = likedate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public Date getLikedate() {
		return likedate;
	}
	public void setLikedate(Date likedate) {
		this.likedate = likedate;
	}
	
}
