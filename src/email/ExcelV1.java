package email;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelV1 {
	ExcelV1() throws IOException {
		Workbook wb = new HSSFWorkbook();

		OutputStream fileOut = new FileOutputStream("BankStatement.xlsx");
		System.out.println("Excel File has been created successfully.");
		wb.write(fileOut);

	}
}
