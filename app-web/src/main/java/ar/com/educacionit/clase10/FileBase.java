package ar.com.educacionit.clase10;

public abstract class FileBase {

	protected String nombreArchivo;
	protected String delimitador;
	
	/**
	 * @param nombreArchivo
	 * @param delimitador
	 */
	public FileBase(String nombreArchivo, String delimitador) {
		this.nombreArchivo = nombreArchivo;
		this.delimitador = delimitador;
	}
	
	public FileBase(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
}
