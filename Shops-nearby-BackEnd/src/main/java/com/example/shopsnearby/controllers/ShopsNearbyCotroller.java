package com.example.shopsnearby.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import com.example.shopsnearby.SecurityConfig.userDetails.CurrentUser;
import com.example.shopsnearby.SecurityConfig.userDetails.UserDetailsImp;
import com.example.shopsnearby.domains.Shop;
import com.example.shopsnearby.service.ShopsNearbyService;

@RestController
@CrossOrigin("*")
public class ShopsNearbyCotroller {
	
	@Autowired
	private ShopsNearbyService shopService;
	
	@RequestMapping(value="/shops", method=RequestMethod.GET)
	public List<Shop> getShops(@CurrentUser UserDetailsImp user){
		return shopService.getAllShops(user.getId());
	}
	@RequestMapping(value="/likeShop/{idShop}", method=RequestMethod.GET)
	public boolean likeShop(@CurrentUser UserDetailsImp user,@PathVariable Long idShop) {
		shopService.likeShop(user.getId(), idShop);
		return true;
	}
	@RequestMapping(value="/removePrefered/{idShop}", method=RequestMethod.DELETE)
	public boolean removePreferred(@CurrentUser UserDetailsImp user,@PathVariable Long idShop) {
		shopService.removePrefered(user.getId(), idShop);
		return true;
	}
	public boolean disLikeShop(Long idShop,Long idUser) {
		shopService.dislikeShop(idShop, idUser);
		return true;
	}
	@RequestMapping(value="/prefshops",method=RequestMethod.GET)
	public List<Shop> getPreferedShops(@CurrentUser UserDetailsImp user) {
		
		return shopService.getpreferredShop(user.getId());
	}
}
