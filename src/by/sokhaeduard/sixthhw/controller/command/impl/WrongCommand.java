package by.sokhaeduard.sixthhw.controller.command.impl;

import java.util.HashMap;
import java.util.Map;

import by.sokhaeduard.sixthhw.controller.ResponseParameters;
import by.sokhaeduard.sixthhw.controller.command.Command;

public class WrongCommand implements Command {
	@Override
	public Map<String, String> execute(Map<String, String> parameters) {
		Map<String, String> response = new HashMap<>();
		response.put(ResponseParameters.STATUS, ResponseParameters.ERROR_STATUS);
		response.put(ResponseParameters.MESSAGE, ResponseParameters.ERROR_MESSAGE);
		return response;
	}
}
