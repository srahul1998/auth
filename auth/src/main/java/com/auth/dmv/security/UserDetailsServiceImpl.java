package com.auth.dmv.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth.dmv.entity.UserDetlsEntity;
import com.auth.dmv.repo.UserDetailsRepo;

@Service // It has to be annotated with @Service.
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private UserDetailsRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserDetlsEntity user = userRepo.findByUname(username);

		List<GrantedAuthority> grantedAuthorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getRole_name())).collect(Collectors.toList());
				
		if (user.getUname().equals(username)) {

			
			return new User(user.getUname(), encoder.encode(user.getPassword()), grantedAuthorities);
		}

		// If user not found. Throw this exception.
		throw new UsernameNotFoundException("Username: " + username + " not found");
	}

}