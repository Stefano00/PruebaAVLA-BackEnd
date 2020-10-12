package com.avla.pruebatecnica.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
	ADMIN, SUPERVISOR, VISIT;

	@Override
	public String getAuthority() {
		
		return name();  // metodo de GranteAuthority
	}
}
