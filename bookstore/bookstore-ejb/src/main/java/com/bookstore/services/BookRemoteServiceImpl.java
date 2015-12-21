package com.bookstore.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import com.bookstore.domain.Book;

@Stateless
public class BookRemoteServiceImpl extends GenericRemoteService<Book> implements BookRemoteService {

	private static final List<Book> testData = new ArrayList<Book>();
	static {
		for (int i = 1; i <= 10; ++i) {
			LocalDateTime date = LocalDateTime.now();
			testData.add(new Book("Book" + i, "Category" + i, date, "Description" + i));
		}
	}

	@Override
	public List<Book> findAll() {
		return testData;
	}

	public BookRemoteServiceImpl() {
		super(Book.class);
	}

	public List<Book> findBooksByCategory(String category) {
		TypedQuery<Book> query = entityManager.createQuery("select b from Book p where b.category=:c", Book.class);
		query.setParameter("c", category);
		return query.getResultList();
	}

}
