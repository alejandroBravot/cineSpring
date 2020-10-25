package net.alex.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.alex.app.model.Banner;
import net.alex.app.service.IBannersService;
import net.alex.app.util.Utileria;

@Controller
@RequestMapping("/banners")
public class BannersController {

	
	@Autowired
	IBannersService serviceBanner;
		
	/**
	 * Metodo para mostrar el listado de banners
	 * @param model
	 * @return
	 */
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		
		List<Banner> listaBanner = serviceBanner.buscarTodos();
		
		model.addAttribute("banners", listaBanner);
		
		 
		return "banners/listBanners";
	}
	
	/**
	 * Metodo para mostrar el formulario para crear un nuevo Banner
	 * @return
	 */
	@GetMapping("/create")
	public String crear() {
		 
		return "banners/formBanner";
		
	}
	
	/**
	 * Metodo para guardar el objeto de modelo de tipo Banner
	 * @return
	 */
	@PostMapping("/save")
	public String guardar(Banner banner,  BindingResult result, RedirectAttributes attrb,
			@RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request) {
		
		
		if (result.hasErrors()) {
			Utileria.obtenerErroresBinding(result);
			return "peliculas/formPelicula";
		}

		// cargamos la imagen de la pelicula y seteamos al objeto pelicula
		if (!multiPart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multiPart, request);
			banner.setArchivo(nombreImagen);
		}
		serviceBanner.insertar(banner);

		attrb.addFlashAttribute("mensaje", "El banner " + banner.getTitulo() + " ha sido cargado");

		
		return "redirect:/banners/index";
	}	
}
