package grupo1.demo;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MascotaInterfaz{
    public List<Mascota> getMascota();
    public Mascota mascota(String animal);
}