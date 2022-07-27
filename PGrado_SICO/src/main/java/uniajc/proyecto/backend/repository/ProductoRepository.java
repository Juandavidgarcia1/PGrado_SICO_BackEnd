package uniajc.proyecto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniajc.proyecto.backend.modelo.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}