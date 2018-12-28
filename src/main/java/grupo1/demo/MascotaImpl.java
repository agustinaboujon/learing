package grupo1.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MascotaImpl implements MascotaInterfaz {

    @Override
    public List<Mascota> getMascota() {
        return ListaMascotas();
    }

    private List<Mascota> ListaMascotas() {
        List<Mascota> response = new ArrayList<>();

        Mascota mascota = new Mascota("Gato", 4, true);
        response.add(mascota);
        mascota = new Mascota("´Perro", 4, true);
        response.add(mascota);
        mascota = new Mascota("Pajaro", 2, false);
        response.add(mascota);
        mascota = new Mascota("Conejo", 4, true);
        response.add(mascota);
        mascota = new Mascota("Rata", 4, true);
        response.add(mascota);
        mascota = new Mascota("Pato", 3, true);
        response.add(mascota);

        return response;
    }

    @Override
    public Mascota mascota(String raza){
        List<Mascota> response = ListaMascotas();

  //      for(int i = 0 ; i < response.size();i++) {
  //          if(response.get(i).getRaza().equals(raza)) {
  //              return response.get(i);
  //          }
  //      }

        for (Mascota mascota:response) {
            if(mascota.getRaza().equals(raza)) {
                return mascota;
            }
        }

        return null;
    }
}
