package pruebasjpa;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.alex.app.model.Horario;
import net.alex.app.model.Pelicula;
import net.alex.app.repository.HorariosRepository;
import net.alex.app.repository.PeliculasRepository;

public class AppPruebaHorarios {

	public static void main(String[] args) {
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		
		HorariosRepository repo = context.getBean("horariosRepository", HorariosRepository.class);
		
		List<Horario> listHorario = repo.findAll();
		
		listHorario.stream().forEach(hor->System.out.println(hor));
		

		context.close();

	}

}
