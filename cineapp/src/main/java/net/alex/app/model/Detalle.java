package net.alex.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="detalles")
public class Detalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String director;
	private String actores;
	private String sinopsis;
	private String trailer;
	
	public Detalle() {
		
	}

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
	 * @return the director
	 */
	public final String getDirector() {
		return director;
	}

	/**
	 * @param director the director to set
	 */
	public final void setDirector(String director) {
		this.director = director;
	}

	/**
	 * @return the actores
	 */
	public final String getActores() {
		return actores;
	}

	/**
	 * @param actores the actores to set
	 */
	public final void setActores(String actores) {
		this.actores = actores;
	}

	/**
	 * @return the sinopsis
	 */
	public final String getSinopsis() {
		return sinopsis;
	}

	/**
	 * @param sinopsis the sinopsis to set
	 */
	public final void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	/**
	 * @return the trailer
	 */
	public final String getTrailer() {
		return trailer;
	}

	/**
	 * @param trailer the trailer to set
	 */
	public final void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	@Override
	public String toString() {
		return "Detalle [id=" + id + ", director=" + director + ", actores=" + actores + ", sinopsis=" + sinopsis
				+ ", trailer=" + trailer + "]";
	}
	
	
	
}
