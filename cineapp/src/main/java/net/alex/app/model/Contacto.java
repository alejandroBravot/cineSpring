package net.alex.app.model;

import java.util.Arrays;
import java.util.List;




public class Contacto {

	private int id;
	private String nombre;
	private String email;
	private int rating;
	private String[] generos;
	private List<String> notificaciones;
	private String comentarios;
	/**
	 * @return the id
	 */
	public final int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public final void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public final String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public final void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the rating
	 */
	public final int getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public final void setRating(int rating) {
		this.rating = rating;
	}
	/**
	 * @return the generos
	 */
	public final String[] getGeneros() {
		return generos;
	}
	/**
	 * @param generos the generos to set
	 */
	public final void setGeneros(String[] generos) {
		this.generos = generos;
	}
	/**
	 * @return the notificaciones
	 */
	public final List<String> getNotificaciones() {
		return notificaciones;
	}
	/**
	 * @param notificaciones the notificaciones to set
	 */
	public final void setNotificaciones(List<String> notificaciones) {
		this.notificaciones = notificaciones;
	}
	/**
	 * @return the comentarios
	 */
	public final String getComentarios() {
		return comentarios;
	}
	/**
	 * @param comentarios the comentarios to set
	 */
	public final void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	@Override
	public String toString() {
		return "Contacto [id=" + id + ", nombre=" + nombre + ", email=" + email + ", rating=" + rating + ", generos="
				+ Arrays.toString(generos) + ", notificaciones=" + notificaciones + ", comentarios=" + comentarios
				+ "]";
	}

	
	
	
	
}
