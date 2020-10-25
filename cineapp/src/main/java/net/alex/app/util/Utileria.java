package net.alex.app.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

public class Utileria {

	
	/**
	 * Metodo para devolver lista de String con las fechas siguientes segun el count
	 * @param count
	 * @return
	 */
	public static List<String> getNextDays(int count){
		//creamos el formato de fecha
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		//objeto fecha
		Date start = new Date();
		Calendar cal = Calendar.getInstance();
		
		cal.add(Calendar.DAY_OF_MONTH, count);
		Date endDate = cal.getTime();
		
		GregorianCalendar gcal = new GregorianCalendar();
		
		gcal.setTime(start);
		List<String> nextDays = new ArrayList<String>();
		
		while(!gcal.getTime().after(endDate)) {
			Date d = gcal.getTime();
			gcal.add(Calendar.DATE,1);
			nextDays.add(sdf.format(d));
		}
		return nextDays;
	}
	
	
	/**
	 * guarda las imagenes que se suban desde archivo
	 * @param multiPart
	 * @param request
	 * @return
	 */
	public static String guardarImagen(MultipartFile multiPart, HttpServletRequest request) {
		// Obtenemos el nombre original del archivo
		String nombreOriginal = multiPart.getOriginalFilename();
		nombreOriginal = nombreOriginal.replace(" ", "-");
		String nombreFinal = randomAlphaNumeric(8) + nombreOriginal;
		// Obtenemos la ruta ABSOLUTA del directorio images
		// apache-tomcat/webapps/cineapp/resources/images/
		String rutaFinal = request.getServletContext().getRealPath("/resources/images/");
		try {
			// Formamos el nombre del archivo para guardarlo en el disco duro
			File imageFile = new File(rutaFinal + nombreFinal);
			// Aqui se guarda fisicamente el archivo en el disco duro
			multiPart.transferTo(imageFile);
			return nombreFinal;
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}

	}
	
	
	/**
	 * metodo que genera cadenas aleatorias
	 * @param count
	 * @return
	 */
	public static String randomAlphaNumeric(int count) {
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		
		while(count--!=0) {
			int character = (int) (Math.random() * caracteres.length());
			builder.append(caracteres.charAt(character));
		}
		
		return builder.toString();
	}
	
	
	/**
	 * errores del binding
	 * @param result
	 */
	public static void obtenerErroresBinding(BindingResult result) {
		result.getAllErrors().stream().forEach(res -> System.out.println(res.getDefaultMessage()));
	}
}
