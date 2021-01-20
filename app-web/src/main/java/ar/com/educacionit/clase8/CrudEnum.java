package ar.com.educacionit.clase8;

public enum CrudEnum {

	CREATE(1),
	READ(2),
	UPDATE(3),
	DELETE(4),
	LIST(5)
	;
	private Integer clave;
	
	private CrudEnum(Integer clave) {
		this.clave = clave;
	}

	public Integer getClave() {
		return clave;
	}
	
}
