package com.example.shopsnearby.SecurityConfig.userDetails;

import java.util.ArrayList;

import java.util.Collection;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.shopsnearby.domains.User;

@Component
public class UserToUserDetails implements Converter<User, UserDetails>{

	
	@Override
	public UserDetails convert(User source) {
		// TODO Auto-generated method stub
		UserDetailsImp userDetails = new UserDetailsImp();
		
		if(source !=null) {
			userDetails.setId(source.getId());
			userDetails.setUsername(source.getUserName());
			userDetails.setPassword(source.getPassword());
			 Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
			 authorities.add(new SimpleGrantedAuthority("User"));
			 userDetails.setAuthorities(authorities);
		}
		return userDetails;
		
	}

}
