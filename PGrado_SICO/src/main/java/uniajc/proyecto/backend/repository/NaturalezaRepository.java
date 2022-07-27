package uniajc.proyecto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniajc.proyecto.backend.modelo.Naturaleza;

@Repository
public interface NaturalezaRepository extends JpaRepository<Naturaleza, Long> {

}