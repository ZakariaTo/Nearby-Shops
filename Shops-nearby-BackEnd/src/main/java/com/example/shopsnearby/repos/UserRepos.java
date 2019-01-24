package com.example.shopsnearby.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shopsnearby.domains.User;

@Repository
public interface UserRepos extends JpaRepository<User, Long>{
	
	User findByUserName(String userName);
	
}
