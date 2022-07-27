package uniajc.proyecto.backend.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_tercero")
public class TipoTercero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "descripcion", length = 150, nullable = false)
	private String descripcion;


	public TipoTercero() {

	}

	public TipoTercero(Long id, String descripcion ) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/*
	 * EXAMPLE UNICO
	 * 
	 * @Column(name = "email", length = 150, nullable=false, unique = true ) private
	 * String email;
	 */

}
