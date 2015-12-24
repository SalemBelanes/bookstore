package com.bookstore.services.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.bookstore.domain.Book;
import com.bookstore.domain.User;
import com.bookstore.services.BookRemoteService;
import com.bookstore.services.UserRemoteService;

@Singleton
@Startup
public class DatabasePopulator {
	@EJB
	private UserRemoteService userService;
	@EJB
	private BookRemoteService bookService;

	public DatabasePopulator() {
	}

	@PostConstruct
	public void createData() {
		userService.create(new User("George", "Orwell", "gorwell@bookstore.com", "password"));
		bookService.create(new Book("1984", "Sci-fi book", toDate("24/12/2015 17:40:00"), "Sci-fi"));
	}

	public Date toDate(String formattedDate) {
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM, Locale.FRANCE);
		Date date = null;
		try {
			date = df.parse(formattedDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
