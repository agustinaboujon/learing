package grupo1.demo.service;

import grupo1.demo.entity.Mascota;
import grupo1.demo.entity.Raza;

import java.util.List;

public interface RazaInterfaz {
    public List<Raza> getMascota();
    public Raza buscarPorRaza(String animal);
    public List<Raza> razaNueva(Raza nuevo);
    public List<Raza> modificar(Raza modificada);
    public List<Raza> eliminarRaza(Raza eliminada);
}
