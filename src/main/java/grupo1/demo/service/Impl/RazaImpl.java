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
    public List<Raza> getMascota() {
        return ListaMascotas();
    }
}
