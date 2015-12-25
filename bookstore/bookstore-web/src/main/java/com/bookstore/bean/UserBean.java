package com.bookstore.bean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.bookstore.domain.User;
import com.bookstore.services.UserRemoteService;

@ManagedBean
@SessionScoped
public class UserBean {

	@EJB
	private UserRemoteService userService;
	private User currentUser = new User();
	private String errorMessage;

	public User getCurrentUser() {
		return currentUser;
	}

	public String authenticate() {
		User user = userService.findUser(currentUser.getEmail(), currentUser.getPassword());
		if (user == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Incorrect Email or Passowrd", "Incorrect Email or Passowrd"));
			return "/views/login";
		}
		errorMessage = "";
		currentUser = user;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", currentUser);
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
