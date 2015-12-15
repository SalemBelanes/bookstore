package com.bookstore.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.bookstore.domain.Book;
import com.bookstore.services.BookRemoteService;

@ManagedBean
@ViewScoped
public class BookBean {

	@EJB
	private BookRemoteService bookService;
	private List<Book> bookList;

	public List<Book> findAllBooks() {
		return (bookList = bookService.findAll());
	}

}
