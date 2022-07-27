package uniajc.proyecto.backend.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "descripcion", length = 150, nullable = false)
	private String descripcion;

	@Column(name = "stock_minimo")
	private Long stock_minimo;

	@Column(name = "existencia")
	private Long existencia;

	public Producto() {

	}

	public Producto(Long id, String descripcion, Long stock_minimo, Long existencia) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.stock_minimo = stock_minimo;
		this.existencia = existencia;
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

	public Long getstock_minimo() {
		return stock_minimo;
	}

	public void setstock_minimo(Long stock_minimo) {
		this.stock_minimo = stock_minimo;
	}

	public Long getExistencia() {
		return existencia;
	}

	public void setExistencia(Long existencia) {
		this.existencia = existencia;
	}

	/*
	 * EXAMPLE UNICO
	 * 
	 * @Column(name = "email", length = 150, nullable=false, unique = true ) private
	 * String email;
	 */

}
