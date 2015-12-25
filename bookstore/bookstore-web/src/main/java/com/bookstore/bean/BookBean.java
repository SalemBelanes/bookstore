package com.bookstore.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.bookstore.domain.Book;
import com.bookstore.services.BookRemoteService;

@ManagedBean
@ViewScoped
public class BookBean {

	@ManagedProperty(value = "#{userBean}")
	private UserBean userBean;
	@EJB
	private BookRemoteService bookService;
	private List<Book> bookList;
	private Book book;

	public String init() {
		if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user") == null) {
			return "/views/login?faces-redirect=true";
		}
		return null;
	}

	public List<Book> getBookList() {
		return (bookList = bookService.findAll());
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public void deleteSelectedBook() {
		bookService.remove(book);
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
