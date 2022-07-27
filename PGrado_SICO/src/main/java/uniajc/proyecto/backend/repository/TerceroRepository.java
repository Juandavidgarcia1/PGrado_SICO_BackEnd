package uniajc.proyecto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniajc.proyecto.backend.modelo.Tercero;

@Repository
public interface TerceroRepository extends JpaRepository<Tercero, Long> {

}