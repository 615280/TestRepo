package util.excelfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

/**
 * @Description TODO
 * 
 * @author hzhuolirong
 * 2017年2月10日 上午10:25:17
 */
public class ExcelFile {
	public static void main(String[] args) {
		try {
			createDEMOFile("a", "b");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getFileInfo(File file, List<?> list) throws Exception {
		Workbook wb = WorkbookFactory.create(new FileInputStream(file));
		Sheet sheet1 = wb.getSheetAt(0);
		for(Row row : sheet1){
			for(Cell cell : row){
				System.out.print(cell.getColumnIndex());
				switch (cell.getCellTypeEnum()) {
				case STRING:
					System.out.println(cell.getRichStringCellValue().getString());
					break;
				case NUMERIC:
					if(DateUtil.isCellDateFormatted(cell)){
						System.out.println(cell.getDateCellValue());
					} else {
						System.out.println(cell.getNumericCellValue());
					}
					break;
				case BOOLEAN:
					System.out.println(cell.getBooleanCellValue());
					break;
				case FORMULA:
					System.out.println(cell.getCellFormula());
					break;
				case BLANK:
					System.out.println();
					break;
				default:
					break;
				}
			}
			System.out.println("============");
		}
	}
	
	public static FileOutputStream createDEMOFile(String origin, String updateInfo) throws Exception{
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("名称列表");
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue(origin);
		row.createCell(1).setCellValue(updateInfo);
		
		FileOutputStream fileOut = new FileOutputStream("d:/workbook.xls");
		wb.write(fileOut);
		fileOut.close();
		return fileOut;
	}
}
