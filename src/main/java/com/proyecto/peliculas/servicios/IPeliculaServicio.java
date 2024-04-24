package com.proyecto.peliculas.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public interface IPeliculaServicio<E> {

	public List<E> listarTodos() throws Exception;// Listar todos
	
	public E listarId(Long id)throws Exception;// Listar por id
	
	public E crear(E entidad) throws Exception; // Crear  
	
	public E actualizar(Long id)throws Exception; //Actualizar
	
	public void borrar(Long id)throws Exception; // Borrar
	
	public List<E> busquedaPrecio()throws Exception; //Busqueda por precio
	
	public List<E>buscarPorNombre(String filtro)throws Exception; //Busqueda por nombre 
	
	public List<E>buscarPorNombreYCantidad(String filtro, int filtro1) throws Exception; // Busqueda pro Nombre y Cantidad
	
}
