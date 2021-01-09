package ar.com.educacionit.clase6;

public class EnumMain {

	public static void main(String[] args) {
		
		//un valor en particular
		ValoresEnum valorEnum = ValoresEnum.XLS;
		
		String valor = valorEnum.getValor();
		
		//recorro todos los valores de un enum
		ValoresEnum[] enums = ValoresEnum.values();
		for(ValoresEnum _enum : enums) {
			System.out.println(_enum + " - " + _enum.getValor());
		}

		String valorXYZ = "docx";
		boolean existe = ValoresEnum.exist(valorXYZ);
		if(existe) {
			ValoresEnum ve = ValoresEnum.getEnumByValue(valorXYZ);
		}
	}

}
