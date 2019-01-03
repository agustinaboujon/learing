package grupo1.demo.repository;

import grupo1.demo.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("mascotaRepository")
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
}
