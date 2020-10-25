package pruebasjpa;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


import org.springframework.context.support.ClassPathXmlApplicationContext;


import net.alex.app.model.Noticia;
import net.alex.app.repository.NoticiasRepository;

public class AppCreate {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		
//		Noticia noticia = new Noticia();
//		noticia.setTitulo("Proximo estreno: Dunkerke");
//		noticia.setDetalle("Proxima pel�cula de Nolan sobre la Sgunra Guerra Mundial");
		//estatus y fecha no hace falta meterlos porque los creo en el constructor de Noticia.
		
		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		//guardar noticia en base datos
		//repo.save(noticia);
		
		//consultar por id
		//System.out.println(repo.findById(1));
		
		
		//update de noticia
//		Optional<Noticia> noticiaOptional;
//		
//		noticiaOptional = repo.findById(1);
//		
//		if (noticiaOptional.isPresent()) {
//			Noticia noticia = noticiaOptional.get();
//			noticia.setTitulo("Dunkerke modificado");
//			repo.save(noticia);
//		}
		
		
		// mirar si existe una entidad con id en particular
//		int idNoticia = 1;
		
//		boolean existe = repo.existsById(1);
//		System.out.println(existe);
//		context.close();
		
		//eliminar por id
//		int idNoticia = 1;
//		
//		repo.deleteById(idNoticia);
		
		
//		//numero de registros de una tabla
//		Long numeroEntidades =
//		repo.count();
//		System.out.println(numeroEntidades);
		
		//recuperar todos los registros de una tabla
//		Iterable<Noticia> itNoticias = repo.findAll();
//		itNoticias.forEach(not-> System.out.println(not));;
		
		//borrar todo
		//repo.deleteAll();
		
		//recuperar vartias entidades por id
	
//		List<Integer> ids = new LinkedList<>();
//		ids.add(1);
//		ids.add(2);
//		ids.add(3);
//		ids.add(4);
//		
//		Iterable<Noticia> listaNoticias = repo.findAllById(ids);
//		listaNoticias.forEach(not->System.out.println(not));
	}

}
