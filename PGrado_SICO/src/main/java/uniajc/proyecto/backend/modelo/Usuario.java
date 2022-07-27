package uniajc.proyecto.backend.modelo;

import java.util.Collection;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
//import javax.persistence.JoinColumn;

@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@Column(name = "user_name", length = 50, nullable = false, unique = true)
	private String user_name;

	@Column(name = "email", length = 200, nullable = false)
	private String email;

	@Column(name = "password", length = 50, nullable = false)
	private String password;

	@Column(name = "estado", nullable = true)
	private Integer estado;
	
	/*
	//FetchType.EAGER carga peresoza que solo se utilice, cuando se necesite.
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
			name = "usuarios_roles",
			joinColumns = @JoinColumn(name = "usuario_id",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "rol_id",referencedColumnName = "id")
			)
	private Collection<Rol> roles;

	public Collection<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}
*/
	public Usuario() {
	
	}

	public Usuario(Long id, String name, String user_name, String email, String password,
			Integer estado) {
		super();
		this.id = id;
		this.name = name;
		this.user_name = user_name;
		this.email = email;
		this.password = password;
		//this.roles = roles;
		this.estado = estado;
	}

	public Usuario(String name, String user_name, String email, String password, Collection<Rol> roles,
			Integer estado) {
		super();
		this.name = name;
		this.user_name = user_name;
		this.email = email;
		this.password = password;
	//	this.roles = roles;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
}
