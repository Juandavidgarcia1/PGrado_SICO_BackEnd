package uniajc.proyecto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniajc.proyecto.backend.modelo.Existencia;

@Repository
public interface ExistenciaRepository extends JpaRepository<Existencia, Long> {

}