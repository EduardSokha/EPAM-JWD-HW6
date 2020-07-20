package by.sokhaeduard.sixthhw.controller.command;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.sokhaeduard.sixthhw.controller.RequestParameters;
import by.sokhaeduard.sixthhw.controller.ResponseParameters;
import by.sokhaeduard.sixthhw.controller.command.impl.RemoveBookCommand;
import by.sokhaeduard.sixthhw.dao.DaoException;

public class RemoveBookCommandTest {

	@BeforeClass
	public void loadTestData() throws DaoException {
		TestData.loadData();
	}

	@DataProvider(name = "executeData")
	public Object[][] createDataExecute() {
		Map<String, String> parameters = new HashMap<>();
		parameters.put(RequestParameters.PARAMETER_ID, "2");
		Map<String, String> response = new HashMap<>();
		response.put(ResponseParameters.STATUS, ResponseParameters.SUCCESS_STATUS);
		return new Object[][] { { parameters, response } };
	}

	@Test(dataProvider = "executeData")
	public void executeTest(Map<String, String> parameters, Map<String, String> expected) {
		Command command = new RemoveBookCommand();
		Map<String, String> actual = command.execute(parameters);
		assertEquals(actual, expected);
	}
}