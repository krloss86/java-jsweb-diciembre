package ar.com.educacionit.main.clase9;

import java.util.ArrayList;
import java.util.List;

public class MainGeneric {

	public static void main(String[] args) {
		
		List<String> nombres = new ArrayList<>();
		
		Parseable<CSV> csvParseable = new FileCSV();

		CSV csv = csvParseable.parsear();
		
		System.out.println(csv);
	}

}
