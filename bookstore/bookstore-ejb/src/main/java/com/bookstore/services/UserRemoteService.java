package com.bookstore.services;

import javax.ejb.Remote;

import com.bookstore.domain.Person;

@Remote
public interface UserRemoteService extends EntityRemoteService<Person> {

	Person findUser(String email, String password);
}
