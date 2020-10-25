package net.alex.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.alex.app.model.Noticia;
import net.alex.app.service.INoticiasService;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {
	
	@Autowired
	private INoticiasService noticiaService;
	
	@GetMapping(value="/create")
	public String crear() {		
		return "noticias/formNoticia";
	}

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Noticia> noticias = noticiaService.buscarTodas();
		
		model.addAttribute("noticias", noticias);
		
		return "noticias/listNoticias";
	}
	
	@PostMapping(value="/save")
	public String guardar(Noticia noticia, RedirectAttributes attributes) {
		noticiaService.guardar(noticia);
		
		attributes.addFlashAttribute("msg", "La datos de la noticia se gaurdaron correctamente");
		return "redirect:/noticias/index";
	}
}
