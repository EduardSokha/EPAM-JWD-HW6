package by.sokhaeduard.sixthhw.controller.command.impl;

import java.util.HashMap;
import java.util.Map;

import by.sokhaeduard.sixthhw.controller.RequestParameters;
import by.sokhaeduard.sixthhw.controller.ResponseParameters;
import by.sokhaeduard.sixthhw.controller.command.Command;
import by.sokhaeduard.sixthhw.service.BookService;
import by.sokhaeduard.sixthhw.service.ServiceException;
import by.sokhaeduard.sixthhw.service.impl.BookServiceImpl;

public class RemoveBookCommand implements Command {
	@Override
	public Map<String, String> execute(Map<String, String> parameters) {
		BookService service = BookServiceImpl.getBookServiceInstance();
		String id = parameters.get(RequestParameters.PARAMETER_ID);
		Map<String, String> response = new HashMap<>();
		try {
			service.removeBook(id);
			response.put(ResponseParameters.STATUS, ResponseParameters.SUCCESS_STATUS);
		} catch (ServiceException e) {
			response.put(ResponseParameters.STATUS, ResponseParameters.ERROR_STATUS);
			response.put(ResponseParameters.MESSAGE, e.getMessage());
		}
		return response;
	}
}
