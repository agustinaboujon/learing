package grupo1.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mascotaRepository")
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
}
