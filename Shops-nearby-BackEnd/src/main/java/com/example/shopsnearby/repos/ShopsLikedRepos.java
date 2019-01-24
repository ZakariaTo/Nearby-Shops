package com.example.shopsnearby.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.shopsnearby.domains.PreferredShop;

public interface ShopsLikedRepos extends JpaRepository<PreferredShop, Long>{

	@Query("from PreferredShop  where id_user = ?1")
	List<PreferredShop> getShopsLikedByUser(Long idUser);
	@Query("from PreferredShop where id_user = ?1 AND id_shop= ?2")
	PreferredShop getPreffredShopByUser(Long idUser,Long idShop);
}
