
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
import uniajc.proyecto.backend.modelo.Movimiento;
import uniajc.proyecto.backend.repository.MovimientoRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class MovimientoController {

	@Autowired
	private MovimientoRepository repositorio;

	// este metodo sirve para listas todos los empleados
	@GetMapping("/movimientos")
	public List<Movimiento> listarTodosLosMovimientos() {
	//	return repositorio.findAll();
		return   repositorio.listaProcedure();
	}

	
	// Este metodo sirve para buscar un empleado por ID
	@GetMapping("/movimientos/{id}")
	public ResponseEntity<Movimiento> consultarMovimientosPorId(@PathVariable long id) {
		Movimiento movimiento = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movimiento not exist with id:" + id));
		return ResponseEntity.ok(movimiento);
	}

	// este metodo sirve para guardar el empleado
	@PostMapping("/movimientos")
	public Movimiento guardarMovimiento(@RequestBody Movimiento movimiento) {
		return repositorio.save(movimiento);
	}

	@PutMapping("/movimientos/{id}")
	public ResponseEntity<Movimiento> updateMovimiento(@PathVariable long id, @RequestBody Movimiento movimientoDetails) {
		Movimiento updateMovimiento = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movimiento not exist with id: " + id));

		updateMovimiento.setCantidad_movto(movimientoDetails.getCantidad_movto());
		updateMovimiento.setId_naturaleza(movimientoDetails.getId_naturaleza());
		Movimiento movimientoActualizado = repositorio.save(updateMovimiento);

		return ResponseEntity.ok(movimientoActualizado);
	}
	
	
	//este metodo sirve para eliminar un movimiento
		@DeleteMapping("/movimientos/{id}")
		public ResponseEntity<Map<String,Boolean>> eliminarMovimiento(@PathVariable Long id){
			Movimiento movimiento = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el movimiento con el ID : " + id));

			repositorio.delete(movimiento);
			Map<String, Boolean> respuesta = new HashMap<>();
			respuesta.put("eliminar",Boolean.TRUE);
			return ResponseEntity.ok(respuesta);
	    }

}
