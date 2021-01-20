package ar.com.educacionit.clase8;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MainMap {

	public static void main(String[] args) {
		
		//ctrl+t
		Map<Integer,String> map = new LinkedHashMap<>();
		
		//cargar, no necesito definir tamaño
		map.put(1, "Lunes");
		map.put(2, "Martes");
		map.put(3, "Miércoles");
		map.put(4, "pepe");
		map.put(5, "Viernes");
		map.put(6, "Sábado");
		map.put(7, "Domingo");

		//System.out.println(map);
		
		//obtener valor
		String dia = map.get(6);
		
		//System.out.println(dia);
		
		//eliminar un valor, lo hago por su clave K
		String diaEliminado = map.remove(9);
		
		//System.out.println(diaEliminado);
		
		//System.out.println(map);
		
		//si existe un valor dentro de un mapa
		String diaAux = map.get(4);
		if(diaAux != null) {
			System.err.println("el 4 existe");
		}
		
		boolean existe4 = map.containsKey(4);
		
		//existe un valor
		boolean existeDomingo = map.containsValue("Domingo");
		
		System.out.println(existe4 + " - "+ existeDomingo );
		
		//otener todas las claves
		Set<Integer> setClaves = map.keySet();
		for(Integer clave : setClaves) {
			String valor = map.get(clave);
			//System.out.println(clave + ", " + valor);
		}
		
		//obtener los valores del mapa
		Collection<String> valores = map.values();
		for(String valor : valores) {
			//System.out.println(valor);
		}
		
		//recorrer un mapa con entry
		Set<Entry<Integer,String>> pares = map.entrySet();
		for(Entry<Integer,String> par : pares ) {
			Integer clave = par.getKey();
			String valor = par.getValue();
			System.out.println(clave + ","+valor);
		}
		
		//actualizar un valor
		String valorErroneo = map.get(4);
		map.put(4,"Jueves");
		for(Entry<Integer,String> par : pares ) {
			Integer clave = par.getKey();
			String valor = par.getValue();
			System.out.println(clave + ","+valor);
		}
	}

}
