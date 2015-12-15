package com.bookstore.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;

import com.bookstore.domain.Book;

@Stateless
public class BookRemoteServiceImpl implements BookRemoteService {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public boolean create(Book book) {
		try {
			entityManager.persist(book);
		} catch (EntityExistsException ex) {
			return false;
		}
		return true;
	}

	@Override
	public List<Book> findAll() {
		List<Book> bookList = entityManager.createQuery("select b from Book b", Book.class).getResultList();
		return bookList;
	}

	@Override
	public List<Book> findBooksByCategory(String category) {
		TypedQuery<Book> query = entityManager.createQuery("select b from Book p where b.category=:c", Book.class);
		query.setParameter("c", category);
		return query.getResultList();
	}

	@Override
	public boolean remove(Book book) {
		try {
			entityManager.remove(book);
		} catch (IllegalArgumentException | TransactionRequiredException ex) {
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Book book) {
		try {
			entityManager.merge(book);
		} catch (IllegalArgumentException | TransactionRequiredException ex) {
			return false;
		}
		return true;
	}

}
