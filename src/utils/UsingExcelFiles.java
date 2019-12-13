package utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UsingExcelFiles {
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUsernameAndPassword () throws Exception {
		File file = new File("excelInput\\Username.xlsx");
		FileInputStream str = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(str);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		for (int i = 1; i < 2; i++) {
			setUsername(sheet.getRow(1).getCell(0).getStringCellValue());
			setPassword(sheet.getRow(1).getCell(1).getStringCellValue());
		} 
		wb.close();
	}
}
