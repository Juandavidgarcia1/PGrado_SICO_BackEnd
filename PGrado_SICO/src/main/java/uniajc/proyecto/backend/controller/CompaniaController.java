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
import uniajc.proyecto.backend.modelo.Compania;
import uniajc.proyecto.backend.repository.CompaniaRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class CompaniaController {

	@Autowired
	private CompaniaRepository repositorio;

	// este metodo sirve para listas todos los empleados
	@GetMapping("/companias")
	public List<Compania> listarTodosLosCompanias() {
		return repositorio.findAll();
	}

	// Este metodo sirve para buscar un empleado por ID
	@GetMapping("/companias/{id}")
	public ResponseEntity<Compania> consultarCompaniasPorId(@PathVariable long id) {
		Compania compania = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Compania not exist with id:" + id));
		return ResponseEntity.ok(compania);
	}

	// este metodo sirve para guardar el empleado
	@PostMapping("/companias")
	public Compania guardarCompania(@RequestBody Compania compania) {
		return repositorio.save(compania);
	}

	@PutMapping("/companias/{id}")
	public ResponseEntity<Compania> updateCompania(@PathVariable long id, @RequestBody Compania companiaDetails) {
		Compania updateCompania = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Compania not exist with id: " + id));

		updateCompania.setDescripcion(companiaDetails.getDescripcion());
		Compania companiaActualizado = repositorio.save(updateCompania);

		return ResponseEntity.ok(companiaActualizado);
	}
	
	//este metodo sirve para eliminar un compania
		@DeleteMapping("/companias/{id}")
		public ResponseEntity<Map<String,Boolean>> eliminarCompania(@PathVariable Long id){
			Compania compania = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el compania con el ID : " + id));

			repositorio.delete(compania);
			Map<String, Boolean> respuesta = new HashMap<>();
			respuesta.put("eliminar",Boolean.TRUE);
			return ResponseEntity.ok(respuesta);
	    }

}
