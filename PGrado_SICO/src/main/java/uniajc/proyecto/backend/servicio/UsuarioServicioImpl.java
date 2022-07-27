package uniajc.proyecto.backend.servicio;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
/*
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
*/
import org.springframework.stereotype.Service;
import uniajc.proyecto.backend.dto.UsuarioRegistroDTO;
import uniajc.proyecto.backend.modelo.Usuario;
import uniajc.proyecto.backend.modelo.Rol;
import uniajc.proyecto.backend.repository.UsuarioRepository;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	private UsuarioRepository usuarioRepositorio;

	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	
	public UsuarioServicioImpl(UsuarioRepository usuarioRepositorio) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
	}
//Se creo en la clase Rol un constructor con solo un nombre.
	
	@Override
	public Usuario save(UsuarioRegistroDTO registroDTO) {
		Usuario usuario = new Usuario(registroDTO.getName(),
				registroDTO.getUser_name(),registroDTO.getEmail(),
				registroDTO.getPassword(), Arrays.asList(new Rol("ROLE_USER")),registroDTO.getEstado());
		return usuarioRepositorio.save(usuario);
	}

	
}
