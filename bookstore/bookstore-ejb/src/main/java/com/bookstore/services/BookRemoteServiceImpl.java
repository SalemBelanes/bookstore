package com.bookstore.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import com.bookstore.domain.Book;

@Stateless
public class BookRemoteServiceImpl extends GenericRemoteService<Book> implements BookRemoteService {

	public BookRemoteServiceImpl() {
		super(Book.class);
	}

	@Override
	public List<Book> findBooksByCategory(String category) {
		TypedQuery<Book> query = entityManager.createQuery("select b from Book p where b.category=:c", Book.class);
		query.setParameter("c", category);
		return query.getResultList();
	}

}
