package ar.com.educacionit.main.clase9;

public class FileXLS extends FileBase implements Parseable<XLS> {
	
	//ctrl+space
	@Override
	public XLS parsear() {
		
		XLS xls = new XLS();
		
		return xls;
	}
}
