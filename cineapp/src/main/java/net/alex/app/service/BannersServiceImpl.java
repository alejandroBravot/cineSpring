package net.alex.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.alex.app.model.Banner;

@Service
public class BannersServiceImpl implements IBannersService {

	private List<Banner> lista = null;

	
	/**
	 * En el constructor creamos una lista enlazada con objetos de tipo Banner
	 */
	public BannersServiceImpl() {
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
		try {
			lista = new LinkedList<Banner>();

			Banner banner1 = new Banner();
			banner1.setArchivo("slide1.jpg");
			banner1.setEstatus("Activo");
			banner1.setFecha(formater.parse("17-06-2018"));
			banner1.setId(1);
			banner1.setTitulo("Pelicula 1");

			Banner banner2 = new Banner();
			banner2.setArchivo("slide2.jpg");
			banner2.setEstatus("Inactivo");
			banner2.setFecha(formater.parse("12-06-2016"));
			banner2.setId(2);
			banner2.setTitulo("Pelicula 2");

			Banner banner3 = new Banner();
			banner3.setArchivo("slide3.jpg");
			banner3.setEstatus("Inactivo");
			banner3.setFecha(formater.parse("05-06-2016"));
			banner3.setId(3);
			banner3.setTitulo("Pelicula 3");

			Banner banner4 = new Banner();
			banner4.setArchivo("slide4.jpg");
			banner4.setEstatus("Inactivo");
			banner4.setFecha(formater.parse("17-06-2016"));
			banner4.setId(1);
			banner4.setTitulo("Pelicula 4");

			// Ejercicio: Agregar los objetos Banner a la lista
			lista.add(banner1);
			lista.add(banner2);
			lista.add(banner3);
			lista.add(banner4);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Insertamos un objeto de tipo Banner a la lista
	 */
	@Override
	public void insertar(Banner banner) {
		lista.add(banner);
	}

	/**
	 * Regresamos la lista de objetos Banner
	 */
	@Override
	public List<Banner> buscarTodos() {
		return this.lista;
	}

}
