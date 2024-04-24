package com.proyecto.peliculas.controlador;

import java.util.List;
import java.util.Optional;

import org.aspectj.lang.reflect.CatchClauseSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.peliculas.entidades.Pelicula;
import com.proyecto.peliculas.servicios.PeliculaServicio;

@RestController
@RequestMapping("peliculas")
public class peliculaControlador {

	@Autowired
	private PeliculaServicio peliculaServicio;
	
	@GetMapping("pelicula")
	
		public ResponseEntity<Pelicula> obtenerTodos(){
			try {
				
				List<Pelicula> obtenerPeliculas=peliculaServicio.listarTodos();
				return new ResponseEntity(obtenerPeliculas,HttpStatus.OK);
				//return ResponseEntity.status(HttpStatus.OK).body(peliculaServicio.findAll());
			} catch (Exception e) {
				
				return ResponseEntity.notFound().build();
				
				
			//return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\"}");
			}
	}
			
			@GetMapping("/id/{id}")
			
			public ResponseEntity<Pelicula>obtenerPorId(@PathVariable Long id){
				
				try {
				Pelicula peliculaId=peliculaServicio.listarId(id);
				return new ResponseEntity(peliculaId,HttpStatus.OK);
					
				}catch(Exception e) {
					
					return ResponseEntity.notFound().build();
				}
			}
			
			
			
			@PostMapping("")
			public ResponseEntity<Pelicula>crear(@RequestBody Pelicula pelicula){
				
			try {
				Pelicula pelicula1=peliculaServicio.crear(pelicula);
				return new ResponseEntity(pelicula1,HttpStatus.CREATED);
				
			}catch(Exception e) {
				return ResponseEntity.notFound().build();
			}
				
				
				
				
			}
			
			
			
			@PutMapping("/id/{id}")
			public ResponseEntity<Pelicula>actualizar(@PathVariable Long id, @RequestBody Pelicula pelicula){
				
				try {
					Pelicula peliculaActualizada=peliculaServicio.actualizar(id);
					peliculaActualizada=peliculaServicio.crear(pelicula);
					return new ResponseEntity(pelicula,HttpStatus.OK);
					
				}catch(Exception e) {
					return ResponseEntity.badRequest().build();
				}
			}
			
			
			@DeleteMapping("/id/{id}")
			
			public ResponseEntity<Pelicula>borrar(@PathVariable Long id){
				try {
					peliculaServicio.borrar(id);
					
					return ResponseEntity.ok().build();
				}
				catch(Exception e) {
					return ResponseEntity.notFound().build();
				}
			}
			
			
			@GetMapping("/precio")
			public ResponseEntity<Pelicula>busqueda(){
				try {
					List<Pelicula>busqueda=peliculaServicio.busquedaPrecio();
					return new ResponseEntity(busqueda,HttpStatus.OK);
				}catch(Exception e) {
					return ResponseEntity.notFound().build();
				}
			}
			
			
			@GetMapping("/nombre/{filtro}")
			
			public ResponseEntity<Pelicula>busquedaNombre(@PathVariable String filtro){
				try {
					List<Pelicula> nombres=peliculaServicio.buscarPorNombre(filtro);
					return new ResponseEntity(nombres,HttpStatus.OK);
				}catch (Exception e) {
					return ResponseEntity.notFound().build();
				}
			}
			
			
			@GetMapping("nombre/{filtro}/cantidad/{filtro1}")
			
			public ResponseEntity<Pelicula>busquedaNombreYCantidad(@PathVariable String filtro, @PathVariable int filtro1){
				
				try {
					List<Pelicula>nombreYCantidad=peliculaServicio.buscarPorNombreYCantidad(filtro, filtro1);
					return new ResponseEntity(nombreYCantidad,HttpStatus.OK);
					
				}catch (Exception e) {
					return ResponseEntity.notFound().build();
				}
				
				
				
			}
			
			
			
			
			
		
	

		
	}
	

