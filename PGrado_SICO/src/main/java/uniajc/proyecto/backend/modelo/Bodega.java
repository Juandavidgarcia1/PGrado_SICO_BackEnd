package uniajc.proyecto.backend.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bodegas")
public class Bodega {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "id_cia")
	private Long id_cia;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "descripcion", length = 150, nullable = false)
	private String descripcion;


	public Bodega() {

	}

	public Bodega(Long id,Long id_cia,String codigo, String descripcion ) {
		super();
		this.id = id;
		this.id = id_cia;
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_cia() {
		return id_cia;
	}

	public void setId_cia(Long id_cia) {
		this.id_cia = id_cia;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
