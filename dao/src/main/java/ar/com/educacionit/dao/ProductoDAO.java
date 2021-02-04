package ar.com.educacionit.dao;

import java.util.ArrayList;
import java.util.Collection;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.DuplicatedExceptions;
import ar.com.educacionit.exceptions.GenericException;
import ar.com.educacionit.exceptions.NonExistsExceptions;

public interface ProductoDAO {

	//crud
	public Producto insert(Producto producto) throws DuplicatedExceptions, GenericException;
	
	public ArrayList<Producto> findAll() throws GenericException;

	public Producto update(Producto producto) throws DuplicatedExceptions, GenericException;

	public Producto getByCodigo(String codigo) throws NonExistsExceptions, GenericException;
	
	public Producto delete(String codigo) throws NonExistsExceptions, GenericException;

	public Collection<Producto> buscar(String claveBusqueda) throws GenericException;
}
