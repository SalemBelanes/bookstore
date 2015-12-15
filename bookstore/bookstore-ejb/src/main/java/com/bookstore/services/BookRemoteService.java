package com.bookstore.services;

import java.util.List;

import javax.ejb.Remote;

import com.bookstore.domain.Book;

@Remote
public interface BookRemoteService {

	boolean create(Book book);
	boolean update(Book book);
	List<Book> findAll();
	List<Book> findBooksByCategory(String category);
	boolean remove(Book book);
}
