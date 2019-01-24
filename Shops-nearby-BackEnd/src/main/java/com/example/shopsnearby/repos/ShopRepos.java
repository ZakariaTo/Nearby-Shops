package com.example.shopsnearby.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.shopsnearby.domains.Shop;

@Repository
public interface ShopRepos extends JpaRepository<Shop, Long>{
	@Query("from Shop s ORDER BY s.name")
	public List<Shop> getShops();
}
