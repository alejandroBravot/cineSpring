package net.alex.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.alex.app.model.Noticia;

//@Service
public class NoticiaServiceImpl implements INoticiasService {

	@Override
	public void guardar(Noticia noticia) {
		System.out.println(noticia);
	}

	@Override
	public List<Noticia> buscarTodas() {
		// TODO Auto-generated method stub
		return null;
	}

}
