package ar.com.educacionit.clase4.interfaces;

public class NubeLogger implements ILogger {

	@Override
	public void log() {
		System.out.println("Envianodo log por ftp al aws!");
	}

	public String getNube() {
		return "aws";
	}
}
