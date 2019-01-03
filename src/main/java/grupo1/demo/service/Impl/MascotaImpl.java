package grupo1.demo.service.Impl;

import grupo1.demo.entity.Mascota;
import grupo1.demo.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import grupo1.demo.service.MascotaInterfaz;

import java.util.List;

@Service
public class MascotaImpl implements MascotaInterfaz {

    @Autowired
    @Qualifier("mascotaRepository")
    MascotaRepository mascotaRepository;

    @Override
    public List<Mascota> getMascota() {
        return ListaMascotas();
    }

    private List<Mascota> ListaMascotas() {
        /*List<Mascota> response = new ArrayList<>();

        Mascota mascota = new Mascota(1, "Gato", 4, true);
        response.add(mascota);
        mascota = new Mascota(2,"´Perro", 4, true);
        response.add(mascota);
        mascota = new Mascota(3,"Pajaro", 2, false);
        response.add(mascota);
        mascota = new Mascota(5,"Conejo", 4, true);
        response.add(mascota);
        mascota = new Mascota(4, "Rata", 4, true);
        response.add(mascota);
        mascota = new Mascota(6,"Pato", 3, true);
        response.add(mascota);

        return response;*/

        return mascotaRepository.findAll();
    }

    @Override
    public Mascota mascota(String raza) {
        List<Mascota> response = ListaMascotas();

        for (Mascota mascota : response) {
            if (mascota.getRaza().equals(raza)) {
                return mascota;
            }
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No existe el animal");
    }

    @Override
    public List<Mascota> aNuevo(Mascota nuevo) {
        List<Mascota> response = ListaMascotas();

        for (Mascota mascota : response) {
            if (mascota.getIdMascota()==nuevo.getIdMascota()) {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Ya existe el animal");
            }
        }
        mascotaRepository.save(nuevo);

        return ListaMascotas();
    }

    @Override
    public List<Mascota> modificar(Mascota modificada) {
        List<Mascota> response = ListaMascotas();
        boolean modificado = false;
        /*for (Mascota mascotita : response) {
            if (mascotita.getRaza().equals(modificada.getRaza())) {
                mascotita.setPatas(modificada.getPatas());
                mascotita.setVivo(modificada.getVivo());
                mascotita.setRaza(modificada.getRaza());
                mascotita.setGruñir(modificada.getGruñir());
                modificado = true;
            }
        }
        if (!modificado) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No existe el animal");
        }
        return response;*/
        for (Mascota mascotita : response) {
            if (mascotita.getIdMascota()==modificada.getIdMascota()){
                mascotaRepository.save(modificada);
                modificado = true;
            }
        }
        if(!modificado){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No existe el animal");
        }

        return mascotaRepository.findAll();
    }

    @Override
    public List<Mascota> eliminarRaza(Mascota eliminada) {
        List<Mascota> response = ListaMascotas();
        boolean eliminado = false;
        for (Mascota mascotita : response) {
            if (mascotita.getIdMascota()==eliminada.getIdMascota()) {
                mascotaRepository.deleteById(eliminada.getIdMascota());
                eliminado = true;
            }
        }
        if(!eliminado){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No existe el animal");
        }

        return mascotaRepository.findAll();
    }
}
