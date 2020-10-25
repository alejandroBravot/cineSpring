package pruebasjpa;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.alex.app.model.Pelicula;
import net.alex.app.repository.NoticiasRepository;
import net.alex.app.repository.PeliculasRepository;

public class AppPruebasRelaciones {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		
		PeliculasRepository repo = context.getBean("peliculasRepository", PeliculasRepository.class);
		
		List<Pelicula> listaPelis = repo.findAll();
		
		listaPelis.stream().forEach(p->p.getHorarios().stream().forEach(h->System.out.println(h)));
		listaPelis.stream().forEach(System.out::println);
	

		context.close();
	}

}
