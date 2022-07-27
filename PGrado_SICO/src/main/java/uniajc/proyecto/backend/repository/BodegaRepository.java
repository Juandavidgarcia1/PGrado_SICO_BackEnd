package uniajc.proyecto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniajc.proyecto.backend.modelo.Bodega;

@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Long> {

}