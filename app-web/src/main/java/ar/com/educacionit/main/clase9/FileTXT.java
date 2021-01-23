package ar.com.educacionit.main.clase9;

public class FileTXT extends FileBase implements Parseable<TXT>{

	@Override
	public TXT parsear() {
		
		TXT file = new TXT();
		
		return file;
	}
}
