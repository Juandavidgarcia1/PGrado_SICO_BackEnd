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
import uniajc.proyecto.backend.modelo.Bodega;
import uniajc.proyecto.backend.repository.BodegaRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class BodegaController {

	@Autowired
	private BodegaRepository repositorio;

	// este metodo sirve para listas todos los empleados
	@GetMapping("/bodegas")
	public List<Bodega> listarTodosLosBodegas() {
		return repositorio.findAll();
	}

	// Este metodo sirve para buscar un empleado por ID
	@GetMapping("/bodegas/{id}")
	public ResponseEntity<Bodega> consultarBodegasPorId(@PathVariable long id) {
		Bodega bodega = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Bodega not exist with id:" + id));
		return ResponseEntity.ok(bodega);
	}

	// este metodo sirve para guardar el empleado
	@PostMapping("/bodegas")
	public Bodega guardarBodega(@RequestBody Bodega bodega) {
		return repositorio.save(bodega);
	}

	@PutMapping("/bodegas/{id}")
	public ResponseEntity<Bodega> updateBodega(@PathVariable long id, @RequestBody Bodega bodegaDetails) {
		Bodega updateBodega = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Bodega not exist with id: " + id));

		updateBodega.setDescripcion(bodegaDetails.getDescripcion());
		Bodega bodegaActualizado = repositorio.save(updateBodega);

		return ResponseEntity.ok(bodegaActualizado);
	}
	
	
	//este metodo sirve para eliminar un bodega
		@DeleteMapping("/bodegas/{id}")
		public ResponseEntity<Map<String,Boolean>> eliminarBodega(@PathVariable Long id){
			Bodega bodega = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el bodega con el ID : " + id));

			repositorio.delete(bodega);
			Map<String, Boolean> respuesta = new HashMap<>();
			respuesta.put("eliminar",Boolean.TRUE);
			return ResponseEntity.ok(respuesta);
	    }

}
