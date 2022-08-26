package com.ebanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility_Xlsx_for_DDT
{
	public static FileInputStream fis;
	public static  XSSFWorkbook wb;
	public static XSSFSheet Sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static DataFormatter df=new DataFormatter();
	static String DDT[][];

	public static int getRowcount(String filename,String sheet) throws IOException
	{
		fis=new FileInputStream(filename);
		wb=new XSSFWorkbook(fis);
		Sheet = wb.getSheet(sheet);
		int  rows= Sheet.getLastRowNum();
		wb.close();
		fis.close();
		return rows;
	}
	public static int getColumncount(String filename,String sheet) throws IOException
	{
		fis=new FileInputStream(filename);
		wb=new XSSFWorkbook(fis);
		Sheet=wb.getSheet(sheet);
		int cols=Sheet.getRow(0).getLastCellNum();
		wb.close();
		fis.close();
		return cols;
	}
	public static String[][] getExceldata(String filename,String sheet,int rowcount,int colcount) throws IOException
	{	

		DDT=new String[rowcount][colcount];
		for(int i=1;i<=rowcount;i++)
		{
			row=Sheet.getRow(i);
			for(int j=0;j<colcount;j++)
			{
				cell = row.getCell(j);
				DDT[i-1][j]= df.formatCellValue(cell);
			}
		}
		return DDT;
	}
	public static String write_data_to_Excel(String sheetname,Object data[][]) throws IOException
	{
		wb=new XSSFWorkbook();
		Sheet=wb.createSheet(sheetname);
		int 	rows=data.length;
		int cols=data[0].length;
		for(int i=0;i<rows;i++)
		{
			row=Sheet.createRow(i);
			for(int j=0;j<cols;j++)
			{
				cell=row.createCell(j);
				Object value=data[i][j];
				if(value instanceof String)
				{
					cell.setCellValue((String)value);
				}
				else if(value instanceof Integer)
				{
					cell.setCellValue((Integer)value);
				}
				else if(value instanceof Boolean)
				{
					cell.setCellValue((Boolean)value);
				}
				else if (value instanceof Double)
				{
					cell.setCellValue((Double)value);
				}
			}
		}
		String filepath="testdata.xlsx";
		FileOutputStream fos=new FileOutputStream(filepath);
		wb.write(fos);
		wb.close();
		fos.close();
		return filepath;
	}
}
