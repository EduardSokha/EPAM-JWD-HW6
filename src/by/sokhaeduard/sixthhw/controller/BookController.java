package by.sokhaeduard.sixthhw.controller;

import java.util.Map;

import by.sokhaeduard.sixthhw.controller.command.Command;
import by.sokhaeduard.sixthhw.controller.command.CommandProvider;

public class BookController {
	private static final BookController INSTANCE_CONTROLLER = new BookController();

	private BookController() {
	}

	public static BookController getInstance() {
		return INSTANCE_CONTROLLER;
	}

	public Map<String, String> executeTask(Map<String, String> parameters) {
		String commandName = parameters.get(RequestParameters.PARAMETER_COMMAND_NAME);
		CommandProvider provider = CommandProvider.getInstance();
		Command command = provider.getCommand(commandName);
		return command.execute(parameters);
	}
}
