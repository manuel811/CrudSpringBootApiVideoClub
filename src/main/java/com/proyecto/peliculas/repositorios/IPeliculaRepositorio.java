package com.proyecto.peliculas.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.peliculas.entidades.Pelicula;

public interface IPeliculaRepositorio extends JpaRepository<Pelicula, Long>{

	@Query(value = "SELECT p FROM Pelicula p WHERE p.precio<30")
	List<Pelicula>busquedaPrecio();
	
	@Query(value="SELECT p FROM Pelicula p WHERE p.nombre LIKE %:filtro% ")
			List<Pelicula>buscarPorNombre(@Param("filtro") String filtro);
	
	
	@Query(value="SELECT * FROM pelicula WHERE pelicula.nombre LIKE %:filtro% OR pelicula.cantidad>20 LIKE %:filtro1%  ", nativeQuery = true)
	List<Pelicula>buscarPorNombreYCantidad(@Param("filtro") String filtro, @Param("filtro1")int filtro1);
			
	

}
