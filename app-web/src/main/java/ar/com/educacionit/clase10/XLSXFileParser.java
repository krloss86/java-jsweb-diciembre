package ar.com.educacionit.clase10;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.main.clase9.Parseable;

public class XLSXFileParser extends FileBase implements Parseable<Collection<Producto>> {

	public XLSXFileParser(String nombreArchivo) {
		super(nombreArchivo);
	}

	@Override
	public Collection<Producto> parsear() {
		
		//POI!!!
		File file = new File(this.nombreArchivo);
		
		try {
	        FileInputStream inputStream = new FileInputStream(file);
	         
	        Workbook workbook = new XSSFWorkbook(inputStream);
	        Sheet firstSheet = workbook.getSheetAt(0);
	        Iterator<Row> iterator = firstSheet.iterator();
	         
	        while (iterator.hasNext()) {
	            Row nextRow = iterator.next();
	            Iterator<Cell> cellIterator = nextRow.cellIterator();
	             
	            while (cellIterator.hasNext()) {
	                Cell cell = cellIterator.next();
	                //System.out.print(cell.getStringCellValue());
	                
	                switch (cell.getCellType()) {
	                   case STRING:
	                        System.out.print(cell.getStringCellValue());
	                        break;
	                    case BOOLEAN:
	                        System.out.print(cell.getBooleanCellValue());
	                        break;
	                    case NUMERIC:
	                        System.out.print(cell.getNumericCellValue());
	                        break;
	                }
	                System.out.print(" - ");
	            }
	            System.out.println();
	        }
         
			workbook.close();
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
