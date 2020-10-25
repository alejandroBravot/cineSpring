package net.alex.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.alex.app.model.Banner;
import net.alex.app.model.Horario;
import net.alex.app.model.Pelicula;
import net.alex.app.service.IBannersService;
import net.alex.app.service.IHorariosService;
import net.alex.app.service.IPeliculasService;
import net.alex.app.util.Utileria;

@Controller
public class HomeController {

	//inyeccion de la clase PeliculaService que genera las peliculas
	@Autowired
	private IPeliculasService servicePeliculas;
	
	@Autowired
	private IBannersService serviceBanner;
	
	@Autowired
	private IHorariosService serviceHorario;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@GetMapping(value = "/home")
	public String goHome() {
		return "home";
	}
	
	@GetMapping(value="/acerca")
	public String acercaDe() {
		return "acerca";
	}

	
	// metodo para mostrar detalle de pagina
	// @GetMapping(value="/detail/{id}/{fecha}")
	@GetMapping(value = "/detail")
	public String mostrarDetalle(Model model, @RequestParam("idMovie") int idPelicula,
			@RequestParam("fecha") Date fecha) {

		List<Horario> horarios = serviceHorario.buscarPorIDPelicula(idPelicula, fecha);

		model.addAttribute("pelicula", servicePeliculas.buscarPorId(idPelicula));
		model.addAttribute("horarios", horarios);
		model.addAttribute("fechaBusqueda", dateFormat.format(fecha));
		
		return "detalle";
	}

	
	@GetMapping(value = "/")
	public String mostrarPrincipal(Model model) {

		// aniadimos peliculas
		List<Pelicula> listaPeliculas = servicePeliculas.buscarTodas();
		
		List<Banner> listaBanners = serviceBanner.buscarTodos();

		// aniadimos la fecha de filtro
		List<String> listaFechas = Utileria.getNextDays(4);

		model.addAttribute("peliculas", listaPeliculas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("listaFechas", listaFechas);
		
		model.addAttribute("banners", listaBanners);

		return "home";

	}

	
	@PostMapping(value = "/search")
	public String buscar(@RequestParam("fecha") String fecha, Model model) {
		
		// aniadimos peliculas
		List<Pelicula> listaPeliculas = new LinkedList<Pelicula>();
		listaPeliculas = servicePeliculas.buscarTodas();
		
		List<Banner> listaBanners = serviceBanner.buscarTodos();

		// aniadimos la fecha de filtro
		List<String> listaFechas = Utileria.getNextDays(4);

		model.addAttribute("peliculas", listaPeliculas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("listaFechas", listaFechas);
		
		model.addAttribute("banners", listaBanners);

		return "home";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	

}
