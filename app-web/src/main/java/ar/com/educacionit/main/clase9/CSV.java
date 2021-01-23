package ar.com.educacionit.main.clase9;

public class CSV extends FileBase implements Parseable<CSV>{

	@Override
	public CSV parsear() {
		
		CSV file = new CSV();
		
		return file;
	}
}
