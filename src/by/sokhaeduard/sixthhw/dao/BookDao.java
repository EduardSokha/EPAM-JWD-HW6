package by.sokhaeduard.sixthhw.dao;

import java.util.List;

import by.sokhaeduard.sixthhw.entity.Book;

public interface BookDao {
	void addBook(Book anotherBook);

	void removeBook(Book anotherBook) throws DaoException;

	Book findById(String id);

	List<Book> getAllBooks();
}
