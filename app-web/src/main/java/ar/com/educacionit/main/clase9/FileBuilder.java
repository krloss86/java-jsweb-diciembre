package ar.com.educacionit.main.clase9;

public class FileBuilder {
	
	public static FileBase getParseable(ClaveEnum claveEnum) {
		
		FileBase fb = null;
		
		switch (claveEnum.name()) {
			case "CSV":
				fb = new FileCSV(); 
				break;
			case "XLS":
				fb = new FileXLS(); 
				break;	
			case "TXT":
				fb = new FileTXT(); 
				break;
		}
		
		return fb;
	}
}
