package uniajc.proyecto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniajc.proyecto.backend.modelo.TipoTercero;

@Repository
public interface TipoTerceroRepository extends JpaRepository<TipoTercero, Long> {

}