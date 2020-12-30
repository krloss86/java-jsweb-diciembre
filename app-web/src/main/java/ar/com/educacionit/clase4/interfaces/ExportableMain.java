package ar.com.educacionit.clase4.interfaces;

public class ExportableMain {

	public static void main(String[] args) {
		
		String nombre = "archivo";
		
		Exportable mkv = new MKV();		
		CSV csv = new CSV(nombre);
		PDF pdf = new PDF(nombre);
		XLS xls = new XLS(nombre);
		
		Exportable[] exportables = new Exportable[] {mkv, csv, pdf, xls};
		
		for(Exportable exp : exportables) {
						
			if(exp instanceof ArchivoBase) {
				ArchivoBase archivoBase = (ArchivoBase)exp;				
				System.out.println("Hija de ArchivoBase" +exp.getClass().getSimpleName());
				System.out.println(archivoBase.getNombre());
			}else {
				System.out.println("NO Hija de ArchivoBase" + exp.getClass().getSimpleName());
			}
			exp.exportar();
		}
	}

}
