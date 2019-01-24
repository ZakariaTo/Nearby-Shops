package com.example.shopsnearby.SecurityConfig.userDetails;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.shopsnearby.domains.User;
import com.example.shopsnearby.repos.UserRepos;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService{
	
	@Autowired
	private UserRepos userRepos;
	@Autowired
	private Converter<User, UserDetails> userDetailsconverter;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepos.findByUserName(username);
		if(user == null)
			throw new UsernameNotFoundException("Entity Not find");
			
		return userDetailsconverter.convert(user);
	}
	@Transactional
	public UserDetails loadUserById(Long id) throws UsernameNotFoundException{
		User user  = userRepos.findById(id).orElseThrow(
				() -> new UsernameNotFoundException("User id :"+ id)
				);
		return userDetailsconverter.convert(user);
	}

}
