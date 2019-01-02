package grupo1.demo;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    @Override
    public List<Mascota> aNuevo(Mascota nuevo){
        List<Mascota> response = ListaMascotas();
        response.add(nuevo);
        return response;
    }

    @Override
    public List<Mascota> modificar(Mascota modificada){
        List<Mascota> response = ListaMascotas();
        int posicion = -1;
        for (Mascota mascotita:response) {
            if(mascotita.getRaza().equals(modificada.getRaza())){
              posicion = response.indexOf(mascotita);
            }
        }
        if(posicion!=-1){
         response.get(posicion).setPatas(modificada.getPatas());
         response.get(posicion).setVivo(modificada.getVivo());
        }
        else{
            //response.add(modificada);
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No existe el animal");
        }

        return response;
    }

    @Override
    public List<Mascota> eliminarRaza(Mascota eliminada){
        List<Mascota> response = ListaMascotas();
        int posicion = -1;
        for (Mascota mascotita:response) {
            if(mascotita.getRaza().equals(eliminada.getRaza())){
                posicion = response.indexOf(mascotita);
            }
        }
        if(posicion!=-1){
            response.remove(posicion);
        }
        else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No existe el animal");
        }

        return response;
    }
}
