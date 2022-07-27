package uniajc.proyecto.backend.servicio;

import uniajc.proyecto.backend.dto.UsuarioRegistroDTO;
import uniajc.proyecto.backend.modelo.Usuario;

public interface UsuarioServicio {

	public Usuario save(UsuarioRegistroDTO registroDTO);

}
