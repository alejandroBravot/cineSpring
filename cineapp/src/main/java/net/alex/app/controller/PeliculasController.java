package net.alex.app.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.alex.app.model.Pelicula;
import net.alex.app.service.IDetalleService;
import net.alex.app.service.IPeliculasService;
import net.alex.app.util.Utileria;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

	@Autowired
	private IPeliculasService servicePelicula;
	@Autowired
	private IDetalleService serviceDetalle;

	@GetMapping("/create")
	public String crear(@ModelAttribute Pelicula pelicula, Model model) {
		

		return "peliculas/formPelicula";
	}

	/**
	 * Muestra un listado de peliculas
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		// creamos lista de pleiculas y llamamos al metodo que biusca todas
		List<Pelicula> listaPeliculas = servicePelicula.buscarTodas();
		// aniadimos al model
		model.addAttribute("peliculas", listaPeliculas);

		// jsp que buscar� para rellenar
		return "peliculas/listPeliculas";
	}

	@PostMapping("/save")
	public String guardar(@ModelAttribute Pelicula pelicula, BindingResult result, RedirectAttributes attrb,
			@RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request) {

		if (result.hasErrors()) {
			Utileria.obtenerErroresBinding(result);
			return "peliculas/formPelicula";
		}

		// cargamos la imagen de la pelicula y seteamos al objeto pelicula
		if (!multiPart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multiPart, request);
			pelicula.setImagen(nombreImagen);
		}

		serviceDetalle.insertar(pelicula.getDetalle());
		servicePelicula.insertar(pelicula);

		attrb.addFlashAttribute("mensaje", "La pelicula " + pelicula.getTitulo() + " ha sido registrada");

		return "redirect:/peliculas/index";
	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idPelicula, Model model) {
		
		Pelicula pelicula = servicePelicula.buscarPorId(idPelicula);
		
		model.addAttribute("pelicula", pelicula);
		
		return "peliculas/formPelicula";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idPelicula, RedirectAttributes attributes) {
		
		Pelicula pelicula = servicePelicula.buscarPorId(idPelicula);
		
		servicePelicula.eliminar(idPelicula);
		serviceDetalle.eliminar(pelicula.getDetalle().getId());
		attributes.addFlashAttribute("mensaje", "La pelicula fue eliminada");
		return "redirect:/peliculas/index";
	}
	
	//metodo que devuelve la lista de generos
	@ModelAttribute("generos")
	public List<String> getGeneros(){
		return servicePelicula.buscarGeneros();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	

}
