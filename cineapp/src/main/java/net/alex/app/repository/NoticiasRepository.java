package net.alex.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.alex.app.model.Noticia;

@Repository
public interface NoticiasRepository extends JpaRepository<Noticia, Integer> {

	//metodo para encontrar por estatus
	List<Noticia> findByEstatus(String estatus);
	List<Noticia> findByEstatusAndTitulo(String estatus, String titulo);
	List<Noticia> findByFechaPublicacionBetween(Date fecha1, Date fecha2);
}
