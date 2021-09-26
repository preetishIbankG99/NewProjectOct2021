package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
public Sheet readExcel() throws IOException{
		File file =	new File("E:\\Eclipse All versions\\Workspace\\SeleniumUse\\src\\main\\java\\testdata\\TestData.xlsx");
		
		FileInputStream inputStream = new FileInputStream(file);
		
				wb = new XSSFWorkbook(inputStream);
		
		
		sh = wb.getSheet("Sheet1");
		 return sh;	
		
		}
}
