package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadfromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// Step1: Convert Physical file into java readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/TEST DATA.xlsx");

		// step2: open workbook
		Workbook workbook = WorkbookFactory.create(fis);

		// step3: Get control over sheet
		Sheet sheet = workbook.getSheet("Sheet1"); // go to excel and copy sheet1

		// Step4: Get control over Row
		Row row = sheet.getRow(1);
		Row row2 = sheet.getRow(3);

		// Step5: Get control over cell
		Cell cell = row.getCell(1);
		Cell cell2 = row2.getCell(1);

		// Step6: Fetch data
		System.out.println(cell.getStringCellValue());
		System.out.println(cell2.getNumericCellValue());

		// step7:Close workbook
		workbook.close();
	}

}
