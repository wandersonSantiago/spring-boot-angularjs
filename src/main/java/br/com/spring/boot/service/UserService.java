package br.com.spring.boot.service;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.spring.boot.security.UserSS;

public class UserService {

	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
