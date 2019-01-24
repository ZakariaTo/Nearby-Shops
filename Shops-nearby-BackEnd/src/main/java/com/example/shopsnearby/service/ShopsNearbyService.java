package com.example.shopsnearby.service;

import java.util.List;

import com.example.shopsnearby.domains.Shop;

public interface ShopsNearbyService {

	public void likeShop(Long idUser,Long idShop);
	public void dislikeShop(Long idShop,Long idUser);
	public List<Shop> getAllShops();
	public List<Shop> getpreferredShop(Long idUser);
	public List<Shop> getAllShops(Long idUser);
	public boolean removePrefered(Long idUser,Long idShop);
	
}
