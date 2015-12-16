package com.bookstore.services;

import javax.ejb.Stateless;

import com.bookstore.domain.User;

@Stateless
public class UserRemoteServiceImpl extends GenericRemoteService<User> {

	public UserRemoteServiceImpl(Class<User> clazz) {
		super(clazz);
	}

}
