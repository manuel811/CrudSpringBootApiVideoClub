package com.proyecto.peliculas.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.peliculas.entidades.Pelicula;
import com.proyecto.peliculas.repositorios.IPeliculaRepositorio;

@Service

public class PeliculaServicio implements IPeliculaServicio<Pelicula> {

	@Autowired
	private IPeliculaRepositorio peliculaRepositorio;

	@Override
	public List<Pelicula> listarTodos() throws Exception {
		
		try {
			List<Pelicula>listaPeliculas=peliculaRepositorio.findAll();
			return listaPeliculas;
			
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		
	}
	
	
	

	@Override
	public Pelicula listarId(Long id) throws Exception {

		try {

			Optional<Pelicula> peliculasId = peliculaRepositorio.findById(id);
			return peliculasId.get();

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}
	
	
	
	
	

	@Override
	public Pelicula crear(Pelicula pelicula) throws Exception {

		try {

			return peliculaRepositorio.save(pelicula);

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}
	
	
	

	@Override
	public Pelicula actualizar(Long id) throws Exception {

		try {

			Optional<Pelicula> peliculaActualizada = peliculaRepositorio.findById(id);
			Pelicula pelicula = peliculaActualizada.get();
			pelicula = peliculaRepositorio.save(pelicula);
			return pelicula;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}
	
	
	

	@Override
	public void borrar(Long id) throws Exception {
		try {
			if (peliculaRepositorio.existsById(id)) {
				peliculaRepositorio.deleteById(id);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}
	
	
	
	

	@Override
	public List<Pelicula> busquedaPrecio() throws Exception {

		try {
			List<Pelicula>buscarPelicula=peliculaRepositorio.busquedaPrecio();
			return buscarPelicula;
			
		}catch(Exception e) {
			throw new Exception(e.getMessage()); 
		}
	}
	
	
	



	@Override
	public List<Pelicula> buscarPorNombre(String filtro) throws Exception {
	try {
			
			List<Pelicula>busquedaNombre=peliculaRepositorio.buscarPorNombre(filtro);
			
			return busquedaNombre;
			
			
			
			
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	
	
	

	@Override
	public List<Pelicula> buscarPorNombreYCantidad(String filtro, int filtro1) throws Exception {
		
		try {
			
		List<Pelicula>busquedaNombreYCantidad=peliculaRepositorio.buscarPorNombreYCantidad(filtro, filtro1);
		
		return busquedaNombreYCantidad;
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		
		
		
	}
		
	}
}



		
		
		
		
		
		
		
	




	


	


