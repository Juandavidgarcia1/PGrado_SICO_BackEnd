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
import uniajc.proyecto.backend.modelo.Tercero;
import uniajc.proyecto.backend.repository.TerceroRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class TerceroController {

	@Autowired
	private TerceroRepository repositorio;

	// este metodo sirve para listas todos los empleados
	@GetMapping("/terceros")
	public List<Tercero> listarTodosLosTerceros() {
		return repositorio.findAll();
	}

	// Este metodo sirve para buscar un empleado por ID
	@GetMapping("/terceros/{id}")
	public ResponseEntity<Tercero> consultarTercerosPorId(@PathVariable long id) {
		Tercero tercero = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tercero not exist with id:" + id));
		return ResponseEntity.ok(tercero);
	}

	// este metodo sirve para guardar el empleado
	@PostMapping("/terceros")
	public Tercero guardarTercero(@RequestBody Tercero tercero) {
		return repositorio.save(tercero);
	}

	@PutMapping("/terceros/{id}")
	public ResponseEntity<Tercero> updateTercero(@PathVariable long id, @RequestBody Tercero terceroDetails) {
		Tercero updateTercero = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tercero not exist with id: " + id));

		updateTercero.setDescripcion(terceroDetails.getDescripcion());
		// updateTercero.setExistencia(terceroDetails.getExistencia()); Este dato no
		// se actualiza por el maestro
	//	updateTercero.setstock_minimo(terceroDetails.getstock_minimo());

		Tercero terceroActualizado = repositorio.save(updateTercero);

		return ResponseEntity.ok(terceroActualizado);
	}
	
	
	//este metodo sirve para eliminar un tercero
		@DeleteMapping("/terceros/{id}")
		public ResponseEntity<Map<String,Boolean>> eliminarTercero(@PathVariable Long id){
			Tercero tercero = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el tercero con el ID : " + id));

			repositorio.delete(tercero);
			Map<String, Boolean> respuesta = new HashMap<>();
			respuesta.put("eliminar",Boolean.TRUE);
			return ResponseEntity.ok(respuesta);
	    }

}
