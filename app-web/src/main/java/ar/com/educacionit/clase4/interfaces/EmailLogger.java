package ar.com.educacionit.clase4.interfaces;

import java.io.Serializable;

public class EmailLogger implements ILogger, Serializable {

	@Override
	public void log() {
		
		System.out.println("Enviando log al mail de : juan@mail.com");
	}

	public String getDireccion() {
		return  "juan@mail.com";
	}
}
