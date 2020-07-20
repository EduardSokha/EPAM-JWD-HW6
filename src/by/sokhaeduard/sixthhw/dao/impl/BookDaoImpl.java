package by.sokhaeduard.sixthhw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import by.sokhaeduard.sixthhw.dao.BookDao;
import by.sokhaeduard.sixthhw.dao.DaoException;
import by.sokhaeduard.sixthhw.entity.Book;

public class BookDaoImpl implements BookDao {
	private static BookDao INSTANCE_DAO;
	private List<Book> books;

	private BookDaoImpl() {
		books = new ArrayList<>();
	}

	public static BookDao getBookDaoInstance() {
		if (INSTANCE_DAO == null) {
			INSTANCE_DAO = new BookDaoImpl();
		}
		return INSTANCE_DAO;
	}

    @Override
    public void addBook(Book anotherBook) {
    	books.add(anotherBook);
    }

    @Override
    public void removeBook(Book anotherBook) throws DaoException{
    	boolean remove = books.remove(anotherBook);
    	if(!remove) {
    		throw new DaoException();
    	}
    }

    @Override
    public Book findById(String id) {
    	for (Book book : books) {
			if(book.getId().equals(id)) {
				return book;
			}
		}
        return null;
    }

	@Override
	public List<Book> getAllBooks() {
		return books;
	}
}
