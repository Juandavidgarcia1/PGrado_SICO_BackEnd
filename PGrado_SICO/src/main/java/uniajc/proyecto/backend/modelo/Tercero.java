package uniajc.proyecto.backend.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "terceros")
public class Tercero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "descripcion", length = 150, nullable = false)
	private String descripcion;

	@Column(name = "numero")
	private String numero;

	@Column(name = "telefono_1")
	private String telefono_1;

	@Column(name = "telefono_2")
	private String telefono_2;

	@Column(name = "tipo_tercero")
	private Long tipo_tercero;

	public Tercero() {

	}
	
	public Tercero(Long id, String descripcion, String numero, String telefono_1, String telefono_2,
			Long tipo_tercero) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.numero = numero;
		this.telefono_1 = telefono_1;
		this.telefono_2 = telefono_2;
		this.tipo_tercero = tipo_tercero;
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


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getTelefono_1() {
		return telefono_1;
	}


	public void setTelefono_1(String telefono_1) {
		this.telefono_1 = telefono_1;
	}


	public String getTelefono_2() {
		return telefono_2;
	}


	public void setTelefono_2(String telefono_2) {
		this.telefono_2 = telefono_2;
	}


	public Long getTipo_tercero() {
		return tipo_tercero;
	}


	public void setTipo_tercero(Long tipo_tercero) {
		this.tipo_tercero = tipo_tercero;
	}

	

}
