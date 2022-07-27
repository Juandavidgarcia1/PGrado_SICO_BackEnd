package uniajc.proyecto.backend.dto;

public class UsuarioRegistroDTO {

	private Integer id;
	private String name;
	private String user_name;
	private String email;
	private String password;
	private Integer estado;

	public UsuarioRegistroDTO() {

	}

	public UsuarioRegistroDTO(String name, String user_name, String email, String password, Integer estado) {
		super();
		this.name = name;
		this.user_name = user_name;
		this.email = email;
		this.password = password;
		this.estado = estado;
	}

	public UsuarioRegistroDTO(String email) {
		super();
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
