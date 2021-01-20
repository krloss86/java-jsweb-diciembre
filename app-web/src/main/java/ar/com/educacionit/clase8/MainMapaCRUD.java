package ar.com.educacionit.clase8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMapaCRUD {

	public static void main(String[] args) throws Exception{
		
		//cargar un mapa CRUD a partir de un enum
		// 1 - create
		// 2 - read
		// 3 - update
		// 4 - delete

		CrudEnum[] valores = CrudEnum.values();
		Map<Integer, ICrud> map = new HashMap<>();
		
		for(CrudEnum _enum : valores) {
			ICrud accion = getIAccionByEnum(_enum);
			map.put(_enum.getClave(), accion);
		}
		
		//1- cargar producto
		//System.out.println(Arrays.toString(valores));
		int opcion;
		String continuar;
		Scanner teclado = new Scanner(System.in);
		System.out.println(Arrays.toString(CrudEnum.values()));
		do {
			System.out.println("Ingrese una opcion");
			opcion = teclado.nextInt();
			//ejectar accion!
			ICrud accion = map.get(opcion);
			accion.execute();
			
			System.out.println("Continuar? S / N");
			continuar = teclado.next();
		}while(continuar.equals("S"));
		teclado.close();
		System.out.println("FIN");
	}
	
	public static ICrud getIAccionByEnum(CrudEnum _enum) throws Exception {		
		//interface i = new Clase();		
		ICrud accion;
		switch (_enum.getClave()) {
			case 1:
				accion = new Create();
				break;
			case 2:
				accion = new Read();
				break;
			case 3:
				accion = new Update();
				break;
			case 4:
				accion = new Delete();
				break;
			case 5:
				accion = new List();
				break;
		default:
			accion = null;
			break;
		}
		if(accion != null) {
			return accion;
		}
		throw new Exception("No existe la accion asociada a enum" +_enum);		
	}

}
