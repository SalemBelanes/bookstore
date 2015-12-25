package com.bookstore.bean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.bookstore.domain.Admin;
import com.bookstore.domain.Person;
import com.bookstore.domain.User;
import com.bookstore.services.UserRemoteService;

@ManagedBean
@SessionScoped
public class UserBean {

	@EJB
	private UserRemoteService userService;
	private Person currentUser = new Person();
	private String errorMessage;

	public Person getCurrentUser() {
		return currentUser;
	}

	public String authenticate() {
		Person user = userService.findUser(currentUser.getEmail(), currentUser.getPassword());
		if (user == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Incorrect Email or Passowrd", "Incorrect Email or Passowrd"));
			return "/views/login";
		}
		currentUser = user;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", currentUser);
		if (currentUser instanceof Admin) {
			return "/views/manageBooks";
		}
		return "/views/displayAllBooks";
	}

	public String logOut() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		currentUser = new User();
		return "/views/login?faces-redirect=true";
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
