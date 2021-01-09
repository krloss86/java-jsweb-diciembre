package ar.com.educacionit.dao;

import java.util.ArrayList;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.DuplicatedExceptions;
import ar.com.educacionit.exceptions.GenericException;

public interface ProductoDAO {

	//crud
	public Producto insert(Producto producto) throws DuplicatedExceptions, GenericException;
	
	public ArrayList<Producto> findAll() throws GenericException;
}
