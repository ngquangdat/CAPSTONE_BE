package com.web_service.security.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {
	UserDetails loadUserByUserName(String username) throws UsernameNotFoundException;
}
