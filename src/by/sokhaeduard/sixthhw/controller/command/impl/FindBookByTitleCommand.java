package by.sokhaeduard.sixthhw.controller.command.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.sokhaeduard.sixthhw.controller.RequestParameters;
import by.sokhaeduard.sixthhw.controller.ResponseParameters;
import by.sokhaeduard.sixthhw.controller.command.Command;
import by.sokhaeduard.sixthhw.entity.Book;
import by.sokhaeduard.sixthhw.service.BookService;
import by.sokhaeduard.sixthhw.service.ServiceException;
import by.sokhaeduard.sixthhw.service.impl.BookServiceImpl;

public class FindBookByTitleCommand implements Command {
	@Override
	public Map<String, String> execute(Map<String, String> parameters) {
		BookService service = BookServiceImpl.getBookServiceInstance();
		String title = parameters.get(RequestParameters.PARAMETER_TITLE);
		Map<String, String> response = new HashMap<>();
		try {
			List<Book> books = service.findByTitle(title);
			response.put(ResponseParameters.STATUS, ResponseParameters.SUCCESS_STATUS);
			response.put(ResponseParameters.RESULT, books.toString());
		} catch (ServiceException e) {
			response.put(ResponseParameters.STATUS, ResponseParameters.ERROR_STATUS);
			response.put(ResponseParameters.MESSAGE, e.getMessage());
		}
		return response;
	}
}
