package utlis;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExcel {

	public static String[][] readExcel(String filename) throws IOException {
		//workbook path
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+filename+".xlsx");

		//getting into sheet1
		XSSFSheet wsheet = wb.getSheetAt(0);

		//to get rowCount
		int rowCount = wsheet.getLastRowNum();

		//to get columnCount
		int columnCount = wsheet.getRow(0).getLastCellNum();

		//to get data from excel
		String data[][] = new String[rowCount][columnCount];
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = wsheet.getRow(i);
			for (int j = 0; j < columnCount; j++) {
				String cellValue = row.getCell(j).getStringCellValue();
				data[i-1][j]=cellValue;

			}

		}
		wb.close();
		return data;

	}


}


