package com.bookstore.services;

import java.util.List;

import javax.ejb.Remote;

import com.bookstore.domain.Book;

@Remote
public interface BookRemoteService extends EntityRemoteService<Book> {

	List<Book> findBooksByCategory(String category);
}
