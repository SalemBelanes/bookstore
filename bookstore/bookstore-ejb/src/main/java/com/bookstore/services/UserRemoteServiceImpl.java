package com.bookstore.services;

import javax.ejb.Stateless;

import com.bookstore.domain.User;

@Stateless
public class UserRemoteServiceImpl extends GenericRemoteService<User> {

	public UserRemoteServiceImpl() {
		super(User.class);
	}

}
