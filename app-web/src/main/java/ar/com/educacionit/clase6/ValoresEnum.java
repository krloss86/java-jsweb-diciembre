package ar.com.educacionit.clase6;

public enum ValoresEnum {

	VALOR1("VALOR1"),
	XLS("xls"),
	CSV("csv"),
	PDF("pdf");
	
	private String valor;
	
	private ValoresEnum(String valor) {
		this.valor = valor;
	}
	
	//get
	public String getValor() {
		return this.valor;
	}
	
	public static boolean exist(String value) {
		boolean enumBuscado = false;
		
		for(int i=0;!enumBuscado && i<ValoresEnum.values().length; i++) {
			enumBuscado = ValoresEnum.values()[i].getValor().equals(value);
		}
		
		return enumBuscado;
	}
	
	/**
	 * Pre: existe enum
	 * @param value
	 * @return
	 */
	public static ValoresEnum getEnumByValue(String value) {
		ValoresEnum enumBuscado = null;
		for(ValoresEnum _enum : ValoresEnum.values()) {
			if(_enum.getValor().equals(value)) {
				enumBuscado = _enum;
				break;
			}
		}
		return enumBuscado;
	}
	 
}
