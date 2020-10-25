package net.alex.app.service;

import java.util.List;
import net.alex.app.model.Banner;

public interface IBannersService {

	void insertar(Banner banner); 
	List<Banner> buscarTodos();
	
}
