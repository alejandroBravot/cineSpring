package net.alex.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.alex.app.model.Detalle;
import net.alex.app.repository.DetallesRepository;

@Service
public class DetalleServiceJpa implements IDetalleService {
	
	@Autowired
	DetallesRepository detalleRepo;

	@Override
	public void insertar(Detalle detalle) {
		detalleRepo.save(detalle);
	}

	@Override
	public void eliminar(int idPelicula) {
		detalleRepo.deleteById(idPelicula);
	}

}
