package uniajc.proyecto.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniajc.proyecto.backend.exception.ResourceNotFoundException;
import uniajc.proyecto.backend.modelo.Usuario;
import uniajc.proyecto.backend.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repositorio;

	// este metodo sirve para listas todos los empleados
	@GetMapping("/usuarios")
	public List<Usuario> listarTodosLosUsuarios() {
		return repositorio.findAll();
	}

	// Este metodo sirve para buscar un empleado por ID
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> consultarUsuariosPorId(@PathVariable long id) {
		Usuario usuario = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario not exist with id:" + id));
		return ResponseEntity.ok(usuario);
	}

	// este metodo sirve para guardar el empleado
	@PostMapping("/usuarios")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		return repositorio.save(usuario);
	}

	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable long id, @RequestBody Usuario usuarioDetails) {
		Usuario updateUsuario = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario not exist with id: " + id));

			
		//terminar de finalizar los elementos para actualizar.
		updateUsuario.setEmail(usuarioDetails.getEmail());
		Usuario usuarioActualizado = repositorio.save(updateUsuario);

		return ResponseEntity.ok(usuarioActualizado);
	}
	
	//este metodo sirve para eliminar un usuario
		@DeleteMapping("/usuarios/{id}")
		public ResponseEntity<Map<String,Boolean>> eliminarUsuario(@PathVariable Long id){
			Usuario usuario = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el usuario con el ID : " + id));

			repositorio.delete(usuario);
			Map<String, Boolean> respuesta = new HashMap<>();
			respuesta.put("eliminar",Boolean.TRUE);
			return ResponseEntity.ok(respuesta);
	    }

}
