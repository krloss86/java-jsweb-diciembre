package ar.com.educacionit.main.clase9;

public class FileParserMain {

	public static void main(String[] args) {
		
		String clave = "XLS";

		ClaveEnum claveEnum = ClaveEnum.getEnumByClave(clave);
		
		if(claveEnum != null) {
			
			FileBase fileBase = FileBuilder.getParseable(claveEnum);
			
			((Parseable)fileBase).parsear();
		}
	}

}
