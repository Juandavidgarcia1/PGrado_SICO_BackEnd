package uniajc.proyecto.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uniajc.proyecto.backend.modelo.Movimiento;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

	@Query(value = "{call lista_procedure()}", nativeQuery =  true)
	public List<Movimiento> listaProcedure();
}