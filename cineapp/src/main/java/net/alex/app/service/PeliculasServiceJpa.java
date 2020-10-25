package net.alex.app.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.alex.app.model.Pelicula;
import net.alex.app.repository.PeliculasRepository;


@Service
public class PeliculasServiceJpa implements IPeliculasService{
	
	@Autowired
	private PeliculasRepository peliculasRepo;
	

	@Override
	public List<Pelicula> buscarTodas() {
		List<Pelicula> listaPeliculas = peliculasRepo.findAll();
		
		return listaPeliculas;
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {
		Optional<Pelicula> detalle = peliculasRepo.findById(idPelicula);
		
		if(detalle.isPresent()) {
			return detalle.get();
		}
		return null;
	}

	@Override
	public void insertar(Pelicula pelicula) {
		peliculasRepo.save(pelicula);
	}

	@Override
	public List<String> buscarGeneros() {
		//lista a obtener de futura BBDD
				List<String> generos = new LinkedList<>();
				
				generos.add("Acci�n");
				generos.add("Aventuras");
				generos.add("Clasicas");
				generos.add("Comedia Rom�ntica");
				generos.add("Drama");
				generos.add("Terror");
				generos.add("Infantil");
				generos.add("Acci�n y Aventura");
				generos.add("Rom�ntica");
				generos.add("Ciencia Ficci�n");
				
				return generos;
	}

	@Override
	public void eliminar(int idPelicula) {
		peliculasRepo.deleteById(idPelicula);	
	}

}
