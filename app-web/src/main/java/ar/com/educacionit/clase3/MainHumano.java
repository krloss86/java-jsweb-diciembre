package ar.com.educacionit.clase3;

public class MainHumano {

	public static void main(String[] args) {
		
		//1 - forma
		//Padre p = new Hija();

		Humano padreM = new Mujer("daniela","Tat�ngelo","Arg");
		padreM.cantar();
		
		Humano padreH = new Hombre("daniela","Tat�ngelo");
		padreH.cantar();
		
	}

}
