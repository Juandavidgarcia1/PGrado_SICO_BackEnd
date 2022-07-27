package uniajc.proyecto.backend.modelo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movimientos")
public class Movimiento {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "id_producto_movto")
	private Long id_producto_movto;

	@Column(name = "id_bodega_movto")
	private Long id_bodega_movto;

	@Column(name = "id_tercero_movto")
	private Long id_tercero_movto;
	
	@Column(name = "cantidad_movto")
	private Long cantidad_movto;
	
	@Column(name = "id_naturaleza")
	private Long id_naturaleza;
	
	@Column(name = "id_user")
	private Long id_user;
	
	@Column(name = "fecha_movto")
	private Date fecha_movto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_producto_movto() {
		return id_producto_movto;
	}

	public void setId_producto_movto(Long id_producto_movto) {
		this.id_producto_movto = id_producto_movto;
	}

	public Long getId_bodega_movto() {
		return id_bodega_movto;
	}

	public void setId_bodega_movto(Long id_bodega_movto) {
		this.id_bodega_movto = id_bodega_movto;
	}

	public Long getId_tercero_movto() {
		return id_tercero_movto;
	}

	public void setId_tercero_movto(Long id_tercero_movto) {
		this.id_tercero_movto = id_tercero_movto;
	}

	public Long getCantidad_movto() {
		return cantidad_movto;
	}

	public void setCantidad_movto(Long cantidad_movto) {
		this.cantidad_movto = cantidad_movto;
	}

	public Long getId_naturaleza() {
		return id_naturaleza;
	}

	public void setId_naturaleza(Long id_naturaleza) {
		this.id_naturaleza = id_naturaleza;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public Date getFecha_movto() {
		return fecha_movto;
	}

	public void setFecha_movto(Date fecha_movto) {
		this.fecha_movto = fecha_movto;
	}

	public Movimiento() {

	}
	
	public Movimiento(Long id, Long id_producto_movto, Long id_bodega_movto, Long id_tercero_movto, Long cantidad_movto,
			Long id_naturaleza, Long id_user, Date fecha_movto) {
		super();
		this.id = id;
		this.id_producto_movto = id_producto_movto;
		this.id_bodega_movto = id_bodega_movto;
		this.id_tercero_movto = id_tercero_movto;
		this.cantidad_movto = cantidad_movto;
		this.id_naturaleza = id_naturaleza;
		this.id_user = id_user;
		this.fecha_movto = fecha_movto;
	}
	
	

}
