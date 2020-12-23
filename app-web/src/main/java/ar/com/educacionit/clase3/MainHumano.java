package ar.com.educacionit.clase3;

public class MainHumano {

	public static void main(String[] args) {
		
		//1 - forma
		//Padre p = new Hija();

		Humano padreM = new Mujer("daniela","Tatángelo","Arg");
		padreM.cantar();
		
		Humano padreH = new Hombre("daniela","Tatángelo");
		padreH.cantar();
		
	}

}
