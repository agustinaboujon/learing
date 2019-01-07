package grupo1.demo;

import grupo1.demo.entity.Raza;
import grupo1.demo.service.RazaInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/raza")
public class RazaController {

    @Autowired
    private RazaInterfaz razaInterfaz;

    @GetMapping(path = "/list")
    public List<Raza> listaMascota() {
        return razaInterfaz.getMascota();
    }

    @GetMapping
    public Raza buscarPorRaza(@RequestParam("animal") String animal) {
        return razaInterfaz.buscarPorRaza(animal);
    }

    @PostMapping
    public List<Raza> razaNueva(@RequestBody Raza nuevo) {
        return razaInterfaz.razaNueva(nuevo);
    }


    @PutMapping
    public List<Raza> modificar(@RequestBody Raza modificada) {
        return razaInterfaz.modificar(modificada);
    }

    @DeleteMapping
    public List<Raza> eliminarRaza(@RequestBody Raza eliminada) {
        return razaInterfaz.eliminarRaza(eliminada);
    }

}
