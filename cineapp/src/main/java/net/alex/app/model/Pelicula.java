package net.alex.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="peliculas")
public class Pelicula {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private int duracion;
	private String clasificacion;
	private String genero;
	private String imagen = "cinema.png"; // imagen por defecto
	private Date fechaEstreno;
	@Column(name="estatus")
	private String status = "Activa";
	//@Transient//ignora este atributo durante la persistencia
	@OneToOne
	@JoinColumn(name="idDetalle")
	private Detalle detalle;
	//le decimos que por cada pleicula traiga tambien sus horarios
	@OneToMany(mappedBy = "pelicula", fetch = FetchType.EAGER)
	private List<Horario> horarios;

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
	 * @return the duracion
	 */
	public final int getDuracion() {
		return duracion;
	}

	/**
	 * @param duracion the duracion to set
	 */
	public final void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	/**
	 * @return the clasificacion
	 */
	public final String getClasificacion() {
		return clasificacion;
	}

	/**
	 * @param clasificacion the clasificacion to set
	 */
	public final void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	/**
	 * @return the genero
	 */
	public final String getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public final void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return the imagen
	 */
	public final String getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public final void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * @return the fechaEstreno
	 */
	public final Date getFechaEstreno() {
		return fechaEstreno;
	}

	/**
	 * @param fechaEstreno the fechaEstreno to set
	 */
	public final void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	/**
	 * @return the status
	 */
	public final String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public final void setStatus(String status) {
		this.status = status;
	}

	
	/**
	 * @return the detalle
	 */
	public final Detalle getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle the detalle to set
	 */
	public final void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	
	
	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", duracion=" + duracion + ", clasificacion="
				+ clasificacion + ", genero=" + genero + ", imagen=" + imagen + ", fechaEstreno=" + fechaEstreno
				+ ", status=" + status + ", detalle=" + detalle + "]";
	}


	
}
