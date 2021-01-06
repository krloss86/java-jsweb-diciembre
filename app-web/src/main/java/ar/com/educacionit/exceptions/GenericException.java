package ar.com.educacionit.exceptions;

public class GenericException extends Exception {

	private static final long serialVersionUID = -8746428938851512553L;

	public GenericException() {
		super();
	}

	public GenericException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
