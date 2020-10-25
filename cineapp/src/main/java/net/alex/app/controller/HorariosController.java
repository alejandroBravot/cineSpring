package net.alex.app.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.alex.app.model.Horario;
import net.alex.app.model.Pelicula;
import net.alex.app.service.IHorariosService;
import net.alex.app.service.IPeliculasService;
import net.alex.app.util.Utileria;

@Controller
@RequestMapping(value="/horarios")
public class HorariosController {
		
	@Autowired
	IPeliculasService servicePeliculas;
	@Autowired
	IHorariosService serviceHorario;
	
	/**
	 * Metodo para mostrar el formulario para crear un nuevo horario
	 * @return
	 */
	@GetMapping(value = "/create")
	public String crear(Model model,@ModelAttribute Horario horario) {
		
		
		model.addAttribute("peliculas", servicePeliculas.buscarTodas());
		model.addAttribute("horario", horario);
				
		
		return "horarios/formHorario";
	}
	
	/**
	 * Metodo que muestra la lista de los horarios
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/index")
	public String mostrarIndex(Model model) {
		List<Horario> listaHorarios = serviceHorario.buscarTodos();
		model.addAttribute("horarios", listaHorarios);
		return "horarios/listHorarios";
	}
		
	/**
	 * Metodo para guardar el registro del Horario
	 * @param horario
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Horario horario, BindingResult result, Model model, RedirectAttributes attributes) {				
		
		if(result.hasErrors()) {
			List<Pelicula> listaPeliculas = servicePeliculas.buscarTodas();
			model.addAttribute("peliculas", listaPeliculas);
			Utileria.obtenerErroresBinding(result);
			return "horarios/formHorario";
		}
		
		serviceHorario.insertar(horario);
		attributes.addFlashAttribute("msg", "El horario fue guardado!");		
		
		return "redirect:/horarios/indexPaginate";
	}
	
	/**
	 * Metodo que muestra la lista de los horarios con paginacion
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Horario> listaHorarios = serviceHorario.buscarTodos(page);
		System.out.print(listaHorarios);
		model.addAttribute("horarios", listaHorarios);
		return "horarios/listHorarios";
	}
	
	/**
	 * Agregamos al modelo, el listado de peliculas para que este disponible
	 * para todos los metodos de este controlador
	 * @return
	 */
	@ModelAttribute("peliculas")
	public List<Pelicula> getPeliculas(){
		return servicePeliculas.buscarTodas();
	}
	

	/**
	 * Metodo para eliminar un registro de horarios
	 * @param idHorario
	 * @param attributes
	 * @return
	 */
	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idHorario, RedirectAttributes attributes) {
		serviceHorario.borrar(idHorario);
		attributes.addFlashAttribute("msg", "El horario fue eliminado!");
		//return "redirect:/horarios/index";
		return "redirect:/horarios/indexPaginate";
	}
	
	/**
	 * Metodo que muestra el formulario para editar un horario
	 * @param idHorario
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int idHorario, Model model) {		
		Horario horario = serviceHorario.buscarPorId(idHorario);			
		model.addAttribute("horario", horario);
		return "horarios/formHorario";
	}
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		

	}
	// Ejercicio: Crear metodo para personalizar el Data Binding para las todas las propiedades de tipo Date	
	
}
