package com.example.shopsnearby;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.shopsnearby.domains.Shop;
import com.example.shopsnearby.domains.User;
import com.example.shopsnearby.repos.ShopRepos;
import com.example.shopsnearby.repos.UserRepos;
import com.example.shopsnearby.service.ShopsNearbyService;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner{
	@Autowired
	ShopsNearbyService shopsService;
	@Autowired
	ShopRepos shopRepos;
	@Autowired 
	UserRepos userRepos;
	PasswordEncoder passwordEncoder;
	@Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

	@Override
	public void run(String... args) throws Exception {
		User user=new User();
		Shop shop=new Shop();
		Shop shop2=new Shop("shop2","http://clubteenergy.fr/wp-content/uploads/2018/10/The_Body_Shop_in_the_Prudential_Center2C_Boston_MA.jpg");
		Shop shop3=new Shop("shop3","https://enduranceshop.com/wp-content/uploads/2016/01/ACCUEIL-p1.jpg");
		Shop shop4=new Shop("shop4","http://www.franchise-groupecasino.fr/wp-content/uploads/2018/02/casino_shop_1-680x342.jpg");
		List<Shop> shops=new ArrayList<>();
		user.setEmail("test@gmail.com");
		user.setFullName("Zakaria Tourabi");
		user.setPassword(passwordEncoder.encode("062896"));
		user.setUserName("zakaria");
		System.out.println("Adding User");
		
		userRepos.save(user);
		System.out.println("User added");
		shop.setName("Shop1");
		shop.setPicture("https://www.julianhouse.org.uk/wp-content/uploads/2013/03/1-walcot-st-shopfront.jpg");
		System.out.println("Adding Shops...");
		shopRepos.save(shop);
		shopRepos.save(shop2);
		shopRepos.save(shop3);
		shopRepos.save(shop4);
		System.out.println("Shops added");
		System.out.println("********************************");
		System.out.println("first list Shop");
		shops=shopsService.getAllShops(user.getId());
		for(Shop s : shops) {
			System.out.println(s.getName());
		}
		System.out.println("********************************");
		System.out.println("********************************");
		System.out.println("like shop1");
		shopsService.likeShop(user.getId(), shop.getId());
		System.out.println("shop liked"+shop.getName());
		System.out.println("********************************");
		System.out.println("********************************");
		System.out.println("Second list Shop");
		shops=shopsService.getAllShops(user.getId());
		
		for(Shop s : shops) {
			System.out.println(s.getName());
		}
		System.out.println("********************************");
		System.out.println("********************************");
		System.out.println("like shop2");
		shopsService.likeShop(user.getId(), shop2.getId());
		System.out.println("shop liked"+shop2.getName());
		System.out.println("********************************");
		System.out.println("********************************");
		System.out.println("last list Shop");
		shops=shopsService.getAllShops(user.getId());
		
		for(Shop s : shops) {
			System.out.println(s.getName());
		}
		System.out.println("********************************");
		
			
	}

}
