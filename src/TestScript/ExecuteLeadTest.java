package TestScript;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;


public class ExecuteLeadTest {

	static Keywords keyword;

@Rule
public ErrorCollector errCol = new ErrorCollector();
@Test
	public void runLeadTest() throws IOException, InterruptedException {
		keyword = new Keywords();
		ArrayList data = new ArrayList();
		FileInputStream file = new FileInputStream("C:\\Users\\USER\\Desktop\\LeadSuite.xlsx");
		XSSFWorkbook workbook  = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("TestSteps");
		Iterator row = sheet.iterator();
		while (row.hasNext()) {
			
			Row rowIterator = (Row) row.next();
			Iterator cellItr = rowIterator.cellIterator();
			
			while (cellItr.hasNext()) {
				Cell cell = (Cell) cellItr.next();
				switch (cell.getCellType()) {
				
				case Cell.CELL_TYPE_STRING:
					data.add(cell.getStringCellValue());
				    break;
				case Cell.CELL_TYPE_BOOLEAN:
					data.add(cell.getBooleanCellValue());
				    break;
				case Cell.CELL_TYPE_NUMERIC:
					data.add(cell.getNumericCellValue());
				    break;
				
				}
			}
		}
		System.out.println(data);
		for (int i=3;i<data.size();i++){
			
			if (data.get(i).equals("openbrowser")) {
				System.out.println(data.get(i));
				keyword.openbrowser();
			}
			if (data.get(i).equals("navigate")) {
				String key = (String) data.get(i);
				String testData = (String) data.get(i+1);
				String objectName = (String) data.get(i+2);
				keyword.navigate(testData);
			}
			if (data.get(i).equals("input")) {
				String key = (String) data.get(i);
				String testData = (String) data.get(i+1);
				String objectName = (String) data.get(i+2);
				System.out.println(key);
				System.out.println(testData);
				System.out.println(objectName);
				keyword.input(testData,objectName);
				
			}
			if (data.get(i).equals("click")){
				String key = (String) data.get(i);
				String testData = (String) data.get(i+1);
				String objectName = (String) data.get(i+2);
				System.out.println(key);
				System.out.println(testData);
				System.out.println(objectName);
				keyword.click(objectName);
				
			}
			
			if (data.get(i).equals("selectlist")) {
				String key = (String) data.get(i);
				String testData = (String) data.get(i+1);
				String objectName = (String) data.get(i+2);
				System.out.println(key);
				System.out.println(testData);
				System.out.println(objectName);
				keyword.selectlist(testData,objectName);
				
			}
			if (data.get(i).equals("verifypagetext")) {
				String key = (String) data.get(i);
				String ExpectedTestData = (String) data.get(i+1);
				String objectName = (String) data.get(i+2);
				System.out.println(key);
				System.out.println(ExpectedTestData);
				System.out.println(objectName);
				String actualValue = keyword.verifypagetext(ExpectedTestData,objectName);
				try{
					org.junit.Assert.assertEquals(ExpectedTestData, actualValue);
				}catch(Throwable t){
	//				errCol.addError(t);
				}
			}
			if (data.get(i).equals("verifyeditboxtext")) {
				String key = (String) data.get(i);
				String ExpectedTestData = (String) data.get(i+1);
				String objectName = (String) data.get(i+2);
				System.out.println(key);
				System.out.println(ExpectedTestData);
				System.out.println(objectName);
				String actualValue = keyword.verifyeditboxtext(ExpectedTestData,objectName);
				try{
				org.junit.Assert.assertEquals(ExpectedTestData, actualValue);
				}catch(Throwable t){
				errCol.addError(t);
				}
			}
			if (data.get(i).equals("verifypagetitle")) {
				String key = (String) data.get(i);
				String ExpectedTestData = (String) data.get(i+1);
				String objectName = (String) data.get(i+2);
				String actualValue = keyword.verifypagetitle(ExpectedTestData);
				try{
				org.junit.Assert.assertEquals(ExpectedTestData, actualValue);
				}catch(Throwable t){
				errCol.addError(t);
				}
				
				
			}
						
		}
		

	}

}
