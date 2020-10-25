package net.alex.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="noticias")
public class Noticia {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String titulo;
	@Column(name="fecha")
	private Date fechaPublicacion;
	private String detalle;
	private String estatus;


	
	/**
	 * constructor de clase
	 */
	public Noticia() {
		this.fechaPublicacion = new Date();
		this.estatus = "Activa";
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
	 * @return the titulo
	 */
	public final String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public final void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the fechaPublicacion
	 */
	public final Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	/**
	 * @param fechaPublicacion the fechaPublicacion to set
	 */
	public final void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	/**
	 * @return the detalle
	 */
	public final String getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle the detalle to set
	 */
	public final void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	/**
	 * @return the estatus
	 */
	public final String getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public final void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	
	@Override
	public String toString() {
		return "Noticia [id=" + id + ", titulo=" + titulo + ", fechaPublicacion=" + fechaPublicacion + ", detalle="
				+ detalle + ", estatus=" + estatus + "]";
	}
	
	

}
