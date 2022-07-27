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
import uniajc.proyecto.backend.modelo.TipoTercero;
import uniajc.proyecto.backend.repository.TipoTerceroRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoTerceroController {

	@Autowired
	private TipoTerceroRepository repositorio;

	// este metodo sirve para listas todos los empleados
	@GetMapping("/TipoTerceros")
	public List<TipoTercero> listarTodosLosTipoTerceros() {
		return repositorio.findAll();
	}

	// Este metodo sirve para buscar un tipo tercer por ID
	@GetMapping("/TipoTerceros/{id}")
	public ResponseEntity<TipoTercero> consultarTipoTercerosPorId(@PathVariable long id) {
		TipoTercero tipoTercero = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tipo Tercero not exist with id:" + id));
		return ResponseEntity.ok(tipoTercero);
	}

	// este metodo sirve para guardar el tipo tercero
	@PostMapping("/TipoTerceros")
	public TipoTercero guardarTipoTercero(@RequestBody TipoTercero tipoTercero) {
		return repositorio.save(tipoTercero);
	}

	@PutMapping("/TipoTerceros/{id}")
	public ResponseEntity<TipoTercero> updateTipoTercero(@PathVariable long id, @RequestBody TipoTercero tipoTerceroDetails) {
		TipoTercero updateTipoTercero = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tipo Tercero not exist with id: " + id));

		updateTipoTercero.setDescripcion(tipoTerceroDetails.getDescripcion());
		TipoTercero tipoTerceroActualizado = repositorio.save(updateTipoTercero);

		return ResponseEntity.ok(tipoTerceroActualizado);
	}
	
	
	//este metodo sirve para eliminar un tipo Tercero
		@DeleteMapping("/TipoTerceros/{id}")
		public ResponseEntity<Map<String,Boolean>> eliminarTipoTercero(@PathVariable Long id){
			TipoTercero tipoTercero = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el tipoTercero con el ID : " + id));

			repositorio.delete(tipoTercero);
			Map<String, Boolean> respuesta = new HashMap<>();
			respuesta.put("eliminar",Boolean.TRUE);
			return ResponseEntity.ok(respuesta);
	    }

}
