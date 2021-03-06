package by.sokhaeduard.sixthhw.controller.command.impl;

import java.util.HashMap;
import java.util.Map;

import by.sokhaeduard.sixthhw.controller.RequestParameters;
import by.sokhaeduard.sixthhw.controller.ResponseParameters;
import by.sokhaeduard.sixthhw.controller.command.Command;
import by.sokhaeduard.sixthhw.service.BookService;
import by.sokhaeduard.sixthhw.service.ServiceException;
import by.sokhaeduard.sixthhw.service.impl.BookServiceImpl;

public class AddBookCommand implements Command {

	@Override
	public Map<String, String> execute(Map<String, String> parameters) {
		BookService service = BookServiceImpl.getBookServiceInstance();
		String title = parameters.get(RequestParameters.PARAMETER_TITLE);
		String stringAuthors = parameters.get(RequestParameters.PARAMETER_AUTHORS);
		String stringNumberPages = parameters.get(RequestParameters.PARAMETER_NUMBER_PAGES);
		String typography = parameters.get(RequestParameters.PARAMETER_TYPOGRAPHY);
		Map<String, String> response = new HashMap<>();
		try {
			service.addBook(title, stringAuthors, stringNumberPages, typography);
			response.put(ResponseParameters.STATUS, ResponseParameters.SUCCESS_STATUS);
		} catch (ServiceException e) {
			response.put(ResponseParameters.STATUS, ResponseParameters.ERROR_STATUS);
			response.put(ResponseParameters.MESSAGE, e.getMessage());
		}
		return response;
	}
}
