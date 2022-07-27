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
import uniajc.proyecto.backend.modelo.Producto;
import uniajc.proyecto.backend.repository.ProductoRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

	@Autowired
	private ProductoRepository repositorio;

	// este metodo sirve para listas todos los empleados
	@GetMapping("/productos")
	public List<Producto> listarTodosLosProductos() {
		return repositorio.findAll();
	}

	// Este metodo sirve para buscar un empleado por ID
	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto> consultarProductosPorId(@PathVariable long id) {
		Producto producto = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Producto not exist with id:" + id));
		return ResponseEntity.ok(producto);
	}

	// este metodo sirve para guardar el empleado
	@PostMapping("/productos")
	public Producto guardarProducto(@RequestBody Producto producto) {
		return repositorio.save(producto);
	}

	@PutMapping("/productos/{id}")
	public ResponseEntity<Producto> updateProducto(@PathVariable long id, @RequestBody Producto productoDetails) {
		Producto updateProducto = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Producto not exist with id: " + id));

		updateProducto.setDescripcion(productoDetails.getDescripcion());
		// updateProducto.setExistencia(productoDetails.getExistencia()); Este dato no
		// se actualiza por el maestro
		updateProducto.setstock_minimo(productoDetails.getstock_minimo());

		Producto productoActualizado = repositorio.save(updateProducto);

		return ResponseEntity.ok(productoActualizado);
	}
	
	
	//este metodo sirve para eliminar un producto
		@DeleteMapping("/productos/{id}")
		public ResponseEntity<Map<String,Boolean>> eliminarProducto(@PathVariable Long id){
			Producto producto = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el producto con el ID : " + id));

			repositorio.delete(producto);
			Map<String, Boolean> respuesta = new HashMap<>();
			respuesta.put("eliminar",Boolean.TRUE);
			return ResponseEntity.ok(respuesta);
	    }

}
