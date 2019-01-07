package grupo1.demo.repository;

import grupo1.demo.entity.Raza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("razaRepository")
public interface RazaRepository extends JpaRepository<Raza, Long> {
}
