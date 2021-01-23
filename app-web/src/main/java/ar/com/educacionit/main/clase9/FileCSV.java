package ar.com.educacionit.main.clase9;

public class FileCSV extends FileBase implements Parseable<CSV> {

	@Override
	public CSV parsear() {
		
		CSV file = new CSV();
		//logica!
		return file;
	}

}
