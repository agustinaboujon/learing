package grupo1.demo;


import grupo1.demo.entity.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import grupo1.demo.service.MascotaInterfaz;


import java.util.List;

@RestController
@RequestMapping(path = "/mascota")
public class MascotaController {

    @Autowired
    private MascotaInterfaz mascotaInterfaz;

    @RequestMapping(path = "/list")
    public List<Mascota> listaMascota(){
        return mascotaInterfaz.getMascota();
    }

    @GetMapping
    public Mascota mascota(@RequestParam("animal") String animal) {
        return mascotaInterfaz.mascota(animal);
    }

    @PostMapping
    public List<Mascota> aNuevo(@RequestBody Mascota nuevo){ return mascotaInterfaz.aNuevo(nuevo); }

    @PutMapping
    public List<Mascota> modificar(@RequestBody Mascota modificada) {return mascotaInterfaz.modificar(modificada); }

    @DeleteMapping
    public List<Mascota> eliminarRaza(@RequestBody Mascota eliminada){return mascotaInterfaz.eliminarRaza(eliminada);}

}
