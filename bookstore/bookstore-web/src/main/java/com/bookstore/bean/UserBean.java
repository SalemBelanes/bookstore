package com.bookstore.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.bookstore.domain.User;
import com.bookstore.services.UserRemoteService;

@ManagedBean
@SessionScoped
public class UserBean {

	@EJB
	private UserRemoteService userService;
	private User currentUser = new User();

	public User getCurrentUser() {
		return currentUser;
	}

	public String authenticate() {
		User user = userService.findUser(currentUser.getEmail(), currentUser.getPassword());
		if (user == null) {
			return "/views/login";
		}
		currentUser = user;
		return "/views/displayAllBooks";
	}

}
