package uniajc.proyecto.backend.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "rol")
public class Rol{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "rol_nombre", length = 50, nullable = false)
	private String rol_nombre;
	
	public Rol() {
		super();
	}
		
	public Rol(String rol_nombre) {
		super();
		this.rol_nombre = rol_nombre;
	}

	public Rol(Integer id, String rol_nombre) {
		super();
		this.id = id;
		this.rol_nombre = rol_nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRol_nombre() {
		return rol_nombre;
	}

	public void setRol_nombre(String rol_nombre) {
		this.rol_nombre = rol_nombre;
	}

	
	
}
