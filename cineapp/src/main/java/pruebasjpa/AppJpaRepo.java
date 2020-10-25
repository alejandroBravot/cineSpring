package pruebasjpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import net.alex.app.model.Noticia;
import net.alex.app.repository.NoticiasRepository;
import sun.jvm.hotspot.ui.action.FindAction;

public class AppJpaRepo {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");

		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		// lista de noticias
//		List<Noticia> listaNoticias;
//		listaNoticias = repo.findAll();
//		listaNoticias.stream().forEach(not->System.out.println(not));

		// borrar todos los registros en lote
		// repo.deleteAllInBatch();

		// lista de noticias con ordenamiento (order by)
//		List<Noticia> listaNoticias;
//	
//		listaNoticias = repo.findAll(Sort.by("titulo").ascending());
//		listaNoticias.stream().forEach(not->System.out.println(not));

		// lista ordenada por dos o mas campos
//		List<Noticia> listaNoticias;
//	
//		listaNoticias = repo.findAll(Sort.by("fechaPublicacion").ascending().and(Sort.by("titulo").descending()));
//		listaNoticias.stream().forEach(not->System.out.println(not));

		// findAll con paginacion
//		Page<Noticia> listaNoticias;
//		
//		listaNoticias = repo.findAll(PageRequest.of(0, 10));
//		listaNoticias.stream().forEach(not->System.out.println(not));

		// findAll con paginacion y ordenacion
//		Page<Noticia> listaNoticias;
//
//		listaNoticias = repo.findAll(PageRequest.of(0, 10, Sort.by("titulo")));
//		listaNoticias.stream().forEach(not -> System.out.println(not));
		
		//buscamos con query methods, find by esatus
//		List<Noticia> listNot = repo.findByEstatus("Activa");
//		listNot.stream().forEach(not->System.out.println(not));	
		
		//buscamos con query method por estatus y titulo
//		List<Noticia> lisNot = repo.findByEstatusAndTitulo("Activa", "Star Wars Episodio 8");
//		lisNot.stream().forEach(not->System.out.println(not));	
		
		
		//buscamos entre dos fechas
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//		List<Noticia> lisNot = null;
//		try {
//			lisNot = repo.findByFechaPublicacionBetween(sdf.parse("2015-05-01"), sdf.parse("2019-05-05"));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		lisNot.stream().forEach(not->System.out.println(not));	
		
		context.close();
	}

}
