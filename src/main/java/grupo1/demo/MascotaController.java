package grupo1.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
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

    @GetMapping(path = "/list2")
    public Mascota mascota(@RequestParam("animal") String animal) {
        return mascotaInterfaz.mascota(animal);
    }

    @PostMapping("/animalNuevo")
    public List<Mascota> aNuevo(@RequestBody Mascota nuevo){ return mascotaInterfaz.aNuevo(nuevo); }

    @PutMapping("/modificar")
    public List<Mascota> modificar(@RequestBody Mascota modificada) {return mascotaInterfaz.modificar(modificada); }

    @DeleteMapping("/eliminar")
    public List<Mascota> eliminarRaza(@RequestBody Mascota eliminada){return mascotaInterfaz.eliminarRaza(eliminada);}

}
