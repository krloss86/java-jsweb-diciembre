package ar.com.educacionit.main.clase9;

public enum ClaveEnum {

	CSV(),
	XLS(),
	TXT();
	
	public static ClaveEnum getEnumByClave(String clave) {
		
		ClaveEnum _enum = null;
		
		for(int i=0; _enum == null && i < ClaveEnum.values().length; i++) {
			if(ClaveEnum.values()[i].name().equalsIgnoreCase(clave)) {
				_enum = ClaveEnum.values()[i];				
			}
		}
		
		return _enum;
	}
}
