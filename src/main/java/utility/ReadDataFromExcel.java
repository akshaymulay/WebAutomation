package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {
	
	public static String  ReadExcel(int RowNumber,int CellNumber ) throws EncryptedDocumentException, IOException {
		FileInputStream fs=new FileInputStream("A:\\java\\WebAuto\\TestData\\Data.xlsx");
		Sheet s=WorkbookFactory.create(fs).getSheet("LoginPageData");
		String DataValue=s.getRow(RowNumber).getCell(CellNumber).getStringCellValue();
		return DataValue;
	}
 
}
 