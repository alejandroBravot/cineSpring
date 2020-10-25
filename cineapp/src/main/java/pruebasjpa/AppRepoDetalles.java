package pruebasjpa;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.alex.app.model.Detalle;
import net.alex.app.model.Pelicula;
import net.alex.app.repository.DetallesRepository;
import net.alex.app.repository.PeliculasRepository;

public class AppRepoDetalles {

	public static void main(String[] args) {
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		
		DetallesRepository repo = context.getBean("detallesRepository", DetallesRepository.class);
		
		List<Detalle> listaDetalles = repo.findAll();
		
		listaDetalles.stream().forEach(p->System.out.println(p));
		

		context.close();

	}

}
