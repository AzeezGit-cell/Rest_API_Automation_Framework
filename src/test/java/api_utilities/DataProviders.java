package api_utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "UserData")
	public String[][] getAllData() throws IOException {

		String path = System.getProperty("user.dir") + "\\testData\\Rest_API_Data.xlsx";

		ExcelUtility xl = new ExcelUtility(path);

		int rows = xl.getRowCount("Sheet1");
		int cols = xl.getCellCount("Sheet1", 1);

		String data[][] = new String[rows][cols];

		for (int i = 1; i <= rows; i++) {

			for (int j = 0; j < cols; j++) {

				data[i - 1][j] = xl.getCellData("Sheet1", i, j);
			}
		}

		return data;
	}

	@DataProvider(name = "UserNames")
	public String[] getUserNames() throws IOException {

		String path = System.getProperty("user.dir") + "\\testData\\Rest_API_Data.xlsx";

		ExcelUtility xl = new ExcelUtility(path);

		int rows = xl.getRowCount("Sheet1");

		String data[] = new String[rows];

		for (int i = 1; i <= rows; i++) {

			data[i - 1] = xl.getCellData("Sheet1", i, 1);
		}

		return data;
	}
}