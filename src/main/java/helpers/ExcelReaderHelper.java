package helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReaderHelper 
{
	String path;
	Logger log=LoggerHelper.getLogger(ExcelReaderHelper.class);
	XSSFWorkbook workbook ;
	XSSFSheet sheet;
	String cellData;
	
	
	ExcelReaderHelper(String filePath) throws InvalidFormatException, IOException
	{
		this.path=filePath;	
		log.info("Excel File Path is:==>"+this.path);
		FileInputStream fis=new FileInputStream(new File(this.path));
		workbook = new XSSFWorkbook(fis);
	}
	
	public int getRowCount(String sheetName)
	{
		if(sheetName==null)
		{
			log.error("Sheet name is null");
		}
		sheet = workbook.getSheet(sheetName);
		int Rcount=sheet.getLastRowNum();
		return Rcount;
	}
	
	public int getColumnCount(String sheetName)
	{
		if(sheetName==null)
		{
			log.error("Sheet name is null");
		}
		sheet = workbook.getSheet(sheetName);
		int Colcount=sheet.getRow(0).getLastCellNum();
		return Colcount;
	}
	
	public String readExcelData(String sheetName,int RowNum,int colNum)
	{
		try
		{
			if(sheetName==null)
			{
				log.error("Sheet name is null");
			}
			if(RowNum==-1)
			{
				RowNum=0;
			}
			if(colNum==-1)
			{
				colNum=0;
			}
			
			sheet=workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(RowNum);
			XSSFCell cell = row.getCell(colNum);
			if(cell.getCellType()==CellType.STRING)
			{
				cellData=cell.getStringCellValue();
			}
			else if(cell.getCellType()==CellType.BOOLEAN)
			{
				cellData=Boolean.toString(cell.getBooleanCellValue());
			}
			else if(cell.getCellType()==CellType.NUMERIC)
			{
				cellData=Integer.toString((int) cell.getNumericCellValue());
			}
			else if(cell.getCellType()==CellType.BLANK)
			{
				cellData="";
			}
			else if(cell.getCellType()==CellType.FORMULA)
			{
				cellData=Integer.toString((int) cell.getNumericCellValue());
						
				if (DateUtil.isCellDateFormatted(cell))
				{
					Date date = cell.getDateCellValue();
					cellData=date.toString();
				}
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return cellData;
	}
	
}
