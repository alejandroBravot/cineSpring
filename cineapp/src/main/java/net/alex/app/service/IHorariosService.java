package net.alex.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.alex.app.model.Horario;

public interface IHorariosService {

	List<Horario> buscarPorIDPelicula(int idPelicula, Date fecha);
	void insertar(Horario horario);
	Page<Horario> buscarTodos(Pageable page);
	List<Horario> buscarTodos();
	void borrar(Integer idHorario);
	void eliminar(int idHorario);
	Horario buscarPorId(int idHorario);
}
