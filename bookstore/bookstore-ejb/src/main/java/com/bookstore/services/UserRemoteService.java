package com.bookstore.services;

import javax.ejb.Remote;

import com.bookstore.domain.User;

@Remote
public interface UserRemoteService extends EntityRemoteService<User> {

	User findUser(String email, String password);
}
