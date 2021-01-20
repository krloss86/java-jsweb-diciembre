package ar.com.educacionit.clase8;

import java.util.Scanner;

import ar.com.educacionit.service.ProductoService;
import ar.com.educacionit.service.impl.ProductoServiceImpl;

public abstract class CrudBase {

	protected ProductoService ps; 
	protected Scanner teclado;
	
	public CrudBase() {
		this.ps = new ProductoServiceImpl();
		this.teclado = new Scanner(System.in);
	}
}
