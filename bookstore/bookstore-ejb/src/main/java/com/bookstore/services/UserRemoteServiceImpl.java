package com.bookstore.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import com.bookstore.domain.User;

@Stateless
public class UserRemoteServiceImpl extends GenericRemoteService<User> implements UserRemoteService {

	public UserRemoteServiceImpl() {
		super(User.class);
	}

	@Override
	public User findUser(String email, String password) {
		TypedQuery<User> q = entityManager
				.createQuery("select u from User u where u.email=?0 and u.password=?1", User.class)
				.setParameter(0, email).setParameter(1, password);
		List<User> list = q.getResultList();
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

}
