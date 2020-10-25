package net.alex.app.service;

import java.util.List;

import net.alex.app.model.Pelicula;

public interface IPeliculasService {

	List<Pelicula> buscarTodas();
	Pelicula buscarPorId(int idPelicula);
	void insertar(Pelicula pelicula);
	List<String> buscarGeneros();
	void eliminar(int idPelicula);
	
}
