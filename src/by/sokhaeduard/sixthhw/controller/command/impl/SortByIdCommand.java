package by.sokhaeduard.sixthhw.controller.command.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.sokhaeduard.sixthhw.controller.ResponseParameters;
import by.sokhaeduard.sixthhw.controller.command.Command;
import by.sokhaeduard.sixthhw.entity.Book;
import by.sokhaeduard.sixthhw.service.BookService;
import by.sokhaeduard.sixthhw.service.impl.BookServiceImpl;

public class SortByIdCommand implements Command {
	@Override
	public Map<String, String> execute(Map<String, String> parameters) {
		BookService service = BookServiceImpl.getBookServiceInstance();
		Map<String, String> response = new HashMap<>();
		List<Book> books = service.sortBooksById();
		response.put(ResponseParameters.STATUS, ResponseParameters.SUCCESS_STATUS);
		response.put(ResponseParameters.RESULT, books.toString());
		return response;
	}
}
