package ar.com.educacionit.clase4.interfaces;

public class FileSystemLogger implements ILogger{
	
	@Override
	public void log() {
		System.out.println("Escribiendo en c:/algo!");
		System.out.println("clase4 de jsweb !");
	}

	public String getPath() {
		return "c:/";
	}
}
