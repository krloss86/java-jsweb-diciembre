package ar.com.educacionit.dao;

import java.util.ArrayList;

import ar.com.educacionit.dao.impl.ProductoDAOImpl;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.GenericException;

public class TestConexion {

	public static void main(String[] args) throws GenericException{

		ProductoDAO pdao = new ProductoDAOImpl();

		ArrayList<Producto> productos = pdao.findAll();
		
		for(Producto p : productos) {
			System.out.println(p.toString());
		}
	}

}
