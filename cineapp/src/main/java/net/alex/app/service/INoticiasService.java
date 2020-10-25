package net.alex.app.service;

import java.util.List;

import net.alex.app.model.Noticia;

public interface INoticiasService {

	void guardar(Noticia noticia);
	public List<Noticia> buscarTodas();
}
