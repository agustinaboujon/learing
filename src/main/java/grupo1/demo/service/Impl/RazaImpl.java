package grupo1.demo.service.Impl;

import grupo1.demo.entity.Mascota;
import grupo1.demo.entity.Raza;
import grupo1.demo.repository.RazaRepository;
import grupo1.demo.service.RazaInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class RazaImpl implements RazaInterfaz {

    @Autowired
    @Qualifier("razaRepository")
    RazaRepository razaRepository;

    private List<Raza> ListaMascotas() { return razaRepository.findAll(); }

    @Override
    public List<Raza> getMascota() { return ListaMascotas(); }

    @Override
    public Raza buscarPorRaza(String animal) {
        List<Raza> response = ListaMascotas();

        for (Raza raza: response) {
            if (raza.getTipoRaza().equals(animal)) {
                return raza;
            }
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No existe la raza");
    }

    @Override
    public List<Raza> razaNueva(Raza nuevo) {

        List<Raza> response = ListaMascotas();

        for (Raza raza : response) {
            if (raza.getIdRaza() == nuevo.getIdRaza()) {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Ya existe el animal");
            }
        }
        razaRepository.save(nuevo);

        return ListaMascotas();
    }

    @Override
    public List<Raza> modificar(Raza modificada) {
        List<Raza> response = ListaMascotas();
        boolean modificado = false;
        for (Raza raza : response) {
            if (raza.getIdRaza()==modificada.getIdRaza()){
                razaRepository.save(modificada);
                modificado = true;
            }
        }
        if(!modificado){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No existe el animal");
        }

        return ListaMascotas();
    }

    @Override
    public List<Raza> eliminarRaza(Raza eliminada) {
        List<Raza> response = ListaMascotas();
        boolean eliminado = false;
        for (Raza raza : response) {
            if (raza.getIdRaza() == eliminada.getIdRaza()) {
                razaRepository.deleteById(eliminada.getIdRaza());
                eliminado = true;
            }
        }
        if(!eliminado){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No existe el animal");
        }

        return ListaMascotas();
    }

}
