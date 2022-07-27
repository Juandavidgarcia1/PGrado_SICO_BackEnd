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
import uniajc.proyecto.backend.modelo.Naturaleza;
import uniajc.proyecto.backend.repository.NaturalezaRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class NaturalezaController {

	@Autowired
	private NaturalezaRepository repositorio;

	// este metodo sirve para listas todos los empleados
	@GetMapping("/naturalezas")
	public List<Naturaleza> listarTodosLosNaturaleza() {
		return repositorio.findAll();
	}

	// Este metodo sirve para buscar un empleado por ID
	@GetMapping("/naturalezas/{id}")
	public ResponseEntity<Naturaleza> consultarNaturalezasPorId(@PathVariable long id) {
		Naturaleza naturaleza = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Naturaleza not exist with id:" + id));
		return ResponseEntity.ok(naturaleza);
	}

	// este metodo sirve para guardar el naturalezas
	@PostMapping("/naturalezas")
	public Naturaleza guardarNaturaleza(@RequestBody Naturaleza naturaleza) {
		return repositorio.save(naturaleza);
	}

	@PutMapping("/naturalezas/{id}")
	public ResponseEntity<Naturaleza> updateNaturaleza(@PathVariable long id, @RequestBody Naturaleza naturalezaDetails) {
		Naturaleza updateNaturaleza = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Naturaleza not exist with id: " + id));

		updateNaturaleza.setDescripcion(naturalezaDetails.getDescripcion());
		Naturaleza naturalezaActualizado = repositorio.save(updateNaturaleza);

		return ResponseEntity.ok(naturalezaActualizado);
	}
	
	//este metodo sirve para eliminar un naturaleza
		@DeleteMapping("/naturalezas/{id}")
		public ResponseEntity<Map<String,Boolean>> eliminarNaturaleza(@PathVariable Long id){
			Naturaleza naturaleza = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe la naturaleza con el ID : " + id));

			repositorio.delete(naturaleza);
			Map<String, Boolean> respuesta = new HashMap<>();
			respuesta.put("eliminar",Boolean.TRUE);
			return ResponseEntity.ok(respuesta);
	    }

}
