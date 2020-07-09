package com.qualiprobdd.e2etests;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Test {
	public static void main(String[] args) throws IOException {
	    Workbook workbook = new XSSFWorkbook();
	    Sheet sheet = workbook.createSheet("sheet1");
	    CellStyle cellStyle = workbook.createCellStyle();
	    CreationHelper createHelper = workbook.getCreationHelper();
	    short dateFormat = createHelper.createDataFormat().getFormat("yyyy-dd-MM");
	    cellStyle.setDataFormat(dateFormat);
	    
	    Row row = sheet.createRow(0);
	    Cell cell = row.createCell(0);
	    cell.setCellValue(Calendar.getInstance());
	    cell.setCellStyle(cellStyle);

	    FileOutputStream fos =new FileOutputStream(new File("src/main/resources/testData/TestData.xlsx"));
	    workbook.write(fos);
	    fos.close();
	    System.out.println("Done");
	}
} 


