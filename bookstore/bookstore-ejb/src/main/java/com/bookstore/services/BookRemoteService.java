package com.bookstore.services;

import javax.ejb.Remote;

import com.bookstore.domain.Book;

@Remote
public interface BookRemoteService extends EntityRemoteService<Book> {

}
