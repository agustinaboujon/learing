package grupo1.demo;

import grupo1.demo.entity.Raza;
import grupo1.demo.service.RazaInterfaz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/raza")
public class RazaController {

    @Autowired
    private RazaInterfaz razaInterfaz;

    @GetMapping(path = "/list")
    public List<Raza> listaMascota(){ return razaInterfaz.getMascota();
    }

}
