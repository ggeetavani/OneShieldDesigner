package pkg_Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import pkg_Base.AppBase;

public class CreateSCRDataProvider extends AppBase{

	@DataProvider
	public static Object[][] dp_positivedata() throws IOException {
		Object[][] data = readfrom_excel(userDir+ "//InputFile//OneShieldTestData.xlsx", "PositiveCreateSCR");
		return data;
	}

	public static String[][] readfrom_excel(String file_path, String sheet_name) throws IOException {
		FileInputStream fso = new FileInputStream(file_path);

		// Fetch Data from Excel
		Workbook wb = new XSSFWorkbook(fso);
		Sheet sh = wb.getSheet(sheet_name);
		// Row rw = sh.getRow(2);
		// Cell cl = rw.getCell(1);
		// String data = cl.getStringCellValue();
		int rowcnt = sh.getLastRowNum() - sh.getFirstRowNum();
		int colcnt = sh.getRow(0).getLastCellNum();
		String[][] exceldata = new String[rowcnt][colcnt];

		for (int r = 1; r <= rowcnt; r++) {
			for (int c = 0; c < colcnt; c++) {
				
				if(c == 3)
				{
					exceldata[r-1][c] = String.valueOf(sh.getRow(r).getCell(c).getNumericCellValue());
				}

				exceldata[r-1][c] = sh.getRow(r).getCell(c).getStringCellValue();

			}

		}
		return exceldata;
	}

}
