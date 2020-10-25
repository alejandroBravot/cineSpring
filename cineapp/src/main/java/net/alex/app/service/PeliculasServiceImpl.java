package net.alex.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.alex.app.model.Pelicula;

//@Service
public class PeliculasServiceImpl implements IPeliculasService {
	
	private List<Pelicula> listaPelis = null;

	public PeliculasServiceImpl() {
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");

		try {
			this.setListaPelis(new LinkedList<Pelicula>());

			Pelicula peli1 = new Pelicula();
			peli1.setId(1);
			peli1.setTitulo("Shutter Islands");
			peli1.setDuracion(140);
			peli1.setClasificacion("16");
			peli1.setGenero("Intriga");
			peli1.setFechaEstreno(formater.parse("02-05-2012"));
			peli1.setImagen("shutterislands.png");

			Pelicula peli2 = new Pelicula();
			peli2.setId(2);
			peli2.setTitulo("Origen");
			peli2.setDuracion(123);
			peli2.setClasificacion("16");
			peli2.setGenero("Thriller");
			peli2.setFechaEstreno(formater.parse("06-03-2014"));
			peli2.setImagen("inception.png");

			Pelicula peli3 = new Pelicula();
			peli3.setId(3);
			peli3.setTitulo("Infiltrados");
			peli3.setDuracion(111);
			peli3.setClasificacion("16");
			peli3.setGenero("Policiaco");
			peli3.setFechaEstreno(formater.parse("13-08-2015"));
			peli3.setImagen("infiltrados.png");
			peli3.setStatus("Activa");

			Pelicula peli4 = new Pelicula();
			peli4.setId(4);
			peli4.setTitulo("Mememento");
			peli4.setDuracion(111);
			peli4.setClasificacion("18");
			peli4.setGenero("Thriller");
			peli4.setFechaEstreno(formater.parse("22-11-2000"));
			peli4.setImagen("memento.png");
			peli4.setStatus("Activa");

			Pelicula peli5 = new Pelicula();
			peli5.setId(5);
			peli5.setTitulo("Interstellar");
			peli5.setDuracion(163);
			peli5.setClasificacion("18");
			peli5.setGenero("Thriller");
			peli5.setFechaEstreno(formater.parse("17-06-2016"));
			peli5.setImagen("interestellar.png");
			peli5.setStatus("Activa");

			this.getListaPelis().add(peli1);
			this.getListaPelis().add(peli2);
			this.getListaPelis().add(peli3);
			this.getListaPelis().add(peli4);
			this.getListaPelis().add(peli5);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 *Retorna la lista de peliculas creada en el constructor
	 */
	@Override
	public List<Pelicula> buscarTodas() {
		return this.getListaPelis();
	}

	/**
	 * @return the listaPelis
	 */
	public final List<Pelicula> getListaPelis() {
		return listaPelis;
	}

	/**
	 * @param listaPelis the listaPelis to set
	 */
	public final void setListaPelis(List<Pelicula> listaPelis) {
		this.listaPelis = listaPelis;
	}


	
	/**
	 *metodo para buscar por el id de la pelicula
	 * 
	 * @return Pelicula
	 */
	@Override
	public Pelicula buscarPorId(int idPelicula) {
			
		//en la lista de peliculas devolvemos la que sea igual a la peticion
		return listaPelis.stream().
				filter(peli -> peli.getId()==idPelicula).
				findFirst().orElse(null);
	}


	@Override
	public void insertar(Pelicula pelicula) {
		this.listaPelis.add(pelicula);
	}


	@Override
	public List<String> buscarGeneros() {
		
		//lista a obtener de futura BBDD
		List<String> generos = new LinkedList<>();
		
		generos.add("Acción");
		generos.add("Aventuras");
		generos.add("Clasicas");
		generos.add("Comedia Romántica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Acción y Aventura");
		generos.add("Romántica");
		generos.add("Ciencia Ficción");
		
		return generos;
	}


	@Override
	public void eliminar(int idPelicula) {
		// TODO Auto-generated method stub
		
	}

}
