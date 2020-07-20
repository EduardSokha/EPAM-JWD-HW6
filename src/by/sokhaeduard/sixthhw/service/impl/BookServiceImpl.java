package by.sokhaeduard.sixthhw.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import by.sokhaeduard.sixthhw.dao.BookDao;
import by.sokhaeduard.sixthhw.dao.DaoException;
import by.sokhaeduard.sixthhw.dao.impl.BookDaoImpl;
import by.sokhaeduard.sixthhw.entity.Book;
import by.sokhaeduard.sixthhw.service.BookService;
import by.sokhaeduard.sixthhw.service.ServiceException;
import by.sokhaeduard.sixthhw.util.DataValidator;

public class BookServiceImpl implements BookService {
	private static BookService INSTANCE_SERVICE;
	private BookDao bookDao;

	private BookServiceImpl() {
		bookDao = BookDaoImpl.getBookDaoInstance();
	}

	public static BookService getBookServiceInstance() {
		if (INSTANCE_SERVICE == null) {
			INSTANCE_SERVICE = new BookServiceImpl();
		}
		return INSTANCE_SERVICE;
	}

	@Override
	public void addBook(String title, String authors, String numberPages, String typography) throws ServiceException {
		if (title == null || authors == null || typography == null || numberPages == null) {
			throw new ServiceException("incorrect param");
		}

		if (!DataValidator.isNumberPagesValid(numberPages)) {
			throw new ServiceException("incorrect param");
		}
		Book book = new Book(title, authors, Integer.parseInt(numberPages), typography);
		bookDao.addBook(book);
	}

	@Override
	public Book findBookById(String id) throws ServiceException {
		if (id == null) {
			throw new ServiceException("incorrect param");
		}

		if (!DataValidator.isIdValid(id)) {
			throw new ServiceException("incorrect id");
		}

		Book findById = bookDao.findById(id);
		if (findById == null) {
			throw new ServiceException("no such book in warehouse");
		}
		return findById;
	}

	@Override
	public void removeBook(String id) throws ServiceException {
		Book findBookById = findBookById(id);
		try {
			bookDao.removeBook(findBookById);
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

	@Override
	public List<Book> findByTitle(String title) throws ServiceException {
		return bookDao.getAllBooks().stream().filter(b -> b.getTitle().equals(title)).collect(Collectors.toList());
	}

	@Override
	public List<Book> sortBooksById() {
		return bookDao.getAllBooks().stream()
				.sorted(Comparator.nullsLast(Comparator.comparing(Book::getId)))
				.collect(Collectors.toList());

	}

	@Override
	public List<Book> sortBooksByTitle() {
		return bookDao.getAllBooks().stream()
				.sorted(Comparator.nullsLast(Comparator.comparing(Book::getTitle)))
				.collect(Collectors.toList());
	}

}