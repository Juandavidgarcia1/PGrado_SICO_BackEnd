package uniajc.proyecto.backend.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "existencias")
public class Existencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "id_producto")
	private Long id_producto;

	@Column(name = "id_bodega")
	private Long id_bodega;

	@Column(name = "cantidad_existencia")
	private Long cantidad_existencia;
	
	public Existencia() {

	}

	public Existencia(Long id,Long id_producto,Long id_bodega, Long cantidad_existencia) {
		super();
		this.id = id;
		this.id_producto = id_producto;
		this.id_bodega = id_bodega;
		this.cantidad_existencia = cantidad_existencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_producto() {
		return id_producto;
	}

	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}

	public Long getId_bodega() {
		return id_bodega;
	}

	public void setId_bodega(Long id_bodega) {
		this.id_bodega = id_bodega;
	}

	public Long getCantidad_existencia() {
		return cantidad_existencia;
	}

	public void setCantidad_existencia(Long cantidad_existencia) {
		this.cantidad_existencia = cantidad_existencia;
	}

	
	/*
	 * EXAMPLE UNICO
	 * 
	 * @Column(name = "email", length = 150, nullable=false, unique = true ) private
	 * String email;
	 */

}
