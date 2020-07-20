package by.sokhaeduard.sixthhw.controller.command;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.sokhaeduard.sixthhw.controller.RequestParameters;
import by.sokhaeduard.sixthhw.controller.ResponseParameters;
import by.sokhaeduard.sixthhw.controller.command.impl.FindBookByTitleCommand;
import by.sokhaeduard.sixthhw.dao.DaoException;
import by.sokhaeduard.sixthhw.entity.Book;

public class FindBookByTitleCommandTest {

	@BeforeClass
	public void loadTestData() throws DaoException {
		TestData.loadData();
	}

	@DataProvider(name = "executeData")
	public Object[][] createDataExecute() {
		Map<String, String> parameters = new HashMap<>();
		parameters.put(RequestParameters.PARAMETER_TITLE, "War and Peace");
		Book book = new Book("1", "War and Peace", "Lev", 581, "Konica Minolta");
		List<Book> books = new ArrayList<>();
		books.add(book);
		Map<String, String> response = new HashMap<>();
		response.put(ResponseParameters.STATUS, ResponseParameters.SUCCESS_STATUS);
		response.put(ResponseParameters.RESULT, books.toString());		
		return new Object[][] { { parameters, response } };
	}

	@Test(dataProvider = "executeData")
	public void executeTest(Map<String, String> parameters, Map<String, String> expected) {
		Command command = new FindBookByTitleCommand();
		Map<String, String> actual = command.execute(parameters);
		assertEquals(actual, expected);
	}
}