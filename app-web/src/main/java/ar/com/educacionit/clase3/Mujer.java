package ar.com.educacionit.clase3;

//DEFINIR LA CLASE MUJER COMO UNA CLASE HIJA DE HUMANO
public class Mujer extends Humano {
	
	//atributos propios de la clase Mujer
	final static int ovarios = 2;
	private String colorPelo;	
	
	//contructor de la clase Mujer
	public Mujer(String nombre, String apellido, String nacionalidad) {
		
		//incovar al constructor del PADRE (Humano)
		super(nombre, apellido, nacionalidad);		
	}

	@Override
	protected void cantar() {
		System.out.println(this.nombre + " , " +  this.apellido + " cantando");
	}
	
	//alt+shit+s
	//get/sets
	public String getColorPelo() {
		return colorPelo;
	}

	public void setColorPelo(String colorPelo) {
		this.colorPelo = colorPelo;
	}


}
