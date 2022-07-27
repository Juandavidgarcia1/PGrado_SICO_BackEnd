
package uniajc.proyecto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniajc.proyecto.backend.modelo.Compania;

@Repository
public interface CompaniaRepository extends JpaRepository<Compania, Long> {

}