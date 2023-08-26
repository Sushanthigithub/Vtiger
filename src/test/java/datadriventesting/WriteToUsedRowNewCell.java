package datadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteToUsedRowNewCell {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		// Step1: Convert Physical file into java readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/TEST DATA.xlsx");

		// step2: open workbook
		Workbook workbook = WorkbookFactory.create(fis);

		// step3: Get control over sheet
		Sheet sheet = workbook.getSheet("Sheet1"); // go to excel and copy sheet1

		// step4: create new row
		Row row = sheet.getRow(4);

		// step5: create new cell
		Cell cell = row.createCell(1);

		// step6: set data into cell
		cell.setCellValue("traniee");

		// step7: save data to excel
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TEST DATA.xlsx");
		workbook.write(fos);

		// step8: close workbook
		workbook.close();
	}

}
