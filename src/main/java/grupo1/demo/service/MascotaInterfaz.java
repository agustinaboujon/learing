package grupo1.demo.service;

import grupo1.demo.entity.Mascota;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MascotaInterfaz{
    public List<Mascota> getMascota();
    public Mascota mascota(String animal);
    public List<Mascota> aNuevo(Mascota nuevo);
    public List<Mascota> modificar(Mascota modificada);
    public List<Mascota> eliminarRaza(Mascota eliminada);
}
