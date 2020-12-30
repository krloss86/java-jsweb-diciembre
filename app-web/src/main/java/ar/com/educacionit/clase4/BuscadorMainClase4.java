package ar.com.educacionit.clase4;

import ar.com.educacionit.clase3.articulo.Articulo;
import ar.com.educacionit.clase3.articulo.Buscador;
import ar.com.educacionit.clase3.articulo.BuscadorLibro;
import ar.com.educacionit.clase3.articulo.BuscadorPelicula;

public class BuscadorMainClase4 {

	public static void main(String[] args) {
		
		//opciones seleccionadas por el usuario		
		int[] opciones = new int[] {1,3};

		//clave de busqueda del usuari
		String claveBusqueda = "iron man";
		
		//si tildo alguna opcion
		if(opciones.length > 0) {
			
			//creo el vector de los buscadores
			Buscador[] buscadores = new Buscador[opciones.length];
			
			//for(int opcion : opciones) {
			for(int i=0;i < opciones.length; i++) {
				
				int opcion = opciones[i];
				Buscador buscador;
				switch (opcion) {
					case 1:
						//padre = new Hijo()
						buscador = new BuscadorLibro(claveBusqueda);
						break;
					case 2: 
						buscador = new BuscadorMusica(claveBusqueda);
						break;
					case 3: 
						buscador = new BuscadorPelicula(claveBusqueda);
						break;
					case 4: 
						buscador = new BuscadorPasatiempo(claveBusqueda);
						break;
					default:
						buscador = new BuscadorVacio(claveBusqueda);
						break;
					}
					buscadores[i] = buscador;
			}
			
			//tengo los buscadores cargados!!!
			Articulo[] resultadosTotales = null;
			for(Buscador buscador : buscadores) {
				//ctrl+t
				buscador.buscar();
								
				Articulo[] resultados = buscador.getResultados();
				
				if(resultadosTotales == null) {
					resultadosTotales = new Articulo[resultados.length];
					resultadosTotales = resultados;
				}else {
					Articulo[] resultadosTotalesAux = new Articulo[resultados.length + resultadosTotales.length];
					int i;
					for(i = 0;i < resultadosTotales.length; i++) {
						resultadosTotalesAux[i] = resultadosTotales[i];
					}
					for(int j=0;j<resultados.length;j++) {
						resultadosTotalesAux[i] = resultados[j];
					}
					resultadosTotales = resultadosTotalesAux;
				}
			}
			
			int total = resultadosTotales.length;
			System.out.println("Hemos Encontrado "+ total+ " Resultados Para" + claveBusqueda);
			
			//presento los resultados
			for(Articulo resultado : resultadosTotales) {
				resultado.informar();
			}
		}

	}

}
