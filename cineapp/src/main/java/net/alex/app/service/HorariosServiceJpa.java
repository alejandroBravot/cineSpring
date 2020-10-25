package net.alex.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.alex.app.model.Horario;
import net.alex.app.repository.HorariosRepository;

@Service
public class HorariosServiceJpa implements IHorariosService {
	
	@Autowired
	private HorariosRepository horariosRepo;

	@Override
	public List<Horario> buscarPorIDPelicula(int idPelicula, Date fecha) {
		return horariosRepo.findByPelicula_IdAndFechaOrderByHora(idPelicula, fecha);	
	}

	@Override
	public void insertar(Horario horario) {
		horariosRepo.save(horario);
	}

	@Override
	public Page<Horario> buscarTodos(Pageable page) {
		return horariosRepo.findAll(page);
	}

	@Override
	public List<Horario> buscarTodos() {
		return horariosRepo.findAll();
	}

	@Override
	public void borrar(Integer idHorario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int idHorario) {
		horariosRepo.deleteById(idHorario);
	}

	@Override
	public Horario buscarPorId(int idHorario) {
		Optional<Horario> horario = horariosRepo.findById(idHorario);
		
		if (horario.isPresent()) {
			return horario.get();
		}
		return null;
		
	}

}
