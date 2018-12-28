package grupo1.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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

}
