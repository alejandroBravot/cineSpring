package net.alex.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.alex.app.model.Noticia;
import net.alex.app.repository.NoticiasRepository;

@Service
public class NoticiaServiceJpa implements INoticiasService {

	@Autowired
	private NoticiasRepository noticiaRepo;
	
	@Override
	public void guardar(Noticia noticia) {
		noticiaRepo.save(noticia);
	}

	@Override
	public List<Noticia> buscarTodas() {
		return noticiaRepo.findAll();
	}

}
