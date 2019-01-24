package com.example.shopsnearby.service.impl;


import java.util.ArrayList;
import java.util.Date;


import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopsnearby.domains.PreferredShop;
import com.example.shopsnearby.domains.Shop;
import com.example.shopsnearby.domains.User;
import com.example.shopsnearby.repos.ShopRepos;
import com.example.shopsnearby.repos.ShopsLikedRepos;
import com.example.shopsnearby.repos.UserRepos;
import com.example.shopsnearby.service.ShopsNearbyService;

@Service
@Transactional
public class ShopsNearbyServiceImpl implements ShopsNearbyService{
	
	@Autowired
	ShopRepos shopRepos;
	@Autowired
	UserRepos userRepos;
	@Autowired
	ShopsLikedRepos shopslikeRepos;
	
	public void likeShop(Long idUser,Long idShop) {
		User user=userRepos.getOne(idUser);
		Shop shop=shopRepos.getOne(idShop);
		PreferredShop shopLiked = new PreferredShop(user,shop,new Date());
		shopslikeRepos.save(shopLiked);	
	}

	public void dislikeShop(Long idShop,Long idUser) {
		User user=userRepos.getOne(idUser);
		Shop shop=shopRepos.getOne(idShop);
		for(PreferredShop p : user.getShopsliked()) {
			if(p.getShop().equals(shop)) {
				shopslikeRepos.delete(p);
				break;
			}
		}
	}
	
	@Override
	public List<Shop> getAllShops() {
		return shopRepos.getShops();
	}

	@Override
	public List<Shop> getpreferredShop(Long idUser) {
		//List<Shop> shops=userRepos.getPreferreShopbyUser(idUser);
		List<PreferredShop> preferredShops = shopslikeRepos.getShopsLikedByUser(idUser);
		List<Shop> shops= new ArrayList<>();
		for(PreferredShop p : preferredShops) {
			shops.add(p.getShop());
		}
		return shops;
	}

	@Override
	public List<Shop> getAllShops(Long idUser) {
		// TODO Auto-generated method stub
		List<Shop> shops,shopsLiked;
		User user = userRepos.getOne(idUser);
		shops = shopRepos.findAll();
		List<PreferredShop> preferredShops= user.getShopsliked();
		shopsLiked = new ArrayList<Shop>();
		for(PreferredShop p : preferredShops) {
			shopsLiked.add(p.getShop());
		}
		List<Shop> result = new ArrayList<>();
		result.addAll(shops);
		
		for (int i=0;i<shops.size();i++) {
			Shop aide = shops.get(i);
			for(int j=0;j<shopsLiked.size();j++) {
				if(shopsLiked.get(j).equals(aide)) {
					result.remove(aide);
					break;
				}	
			}
		}	
		
		return result;
	}

	@Override
	public boolean removePrefered(Long idUser, Long idShop) {
		// TODO Auto-generated method stub
		PreferredShop p = shopslikeRepos.getPreffredShopByUser(idUser,idShop);
		try{
			shopslikeRepos.delete(p);
		}catch(Exception e) {
			System.out.println("can't remove shop : "+e.getMessage());
			return false;
		}
		return true;
	}



	
}
