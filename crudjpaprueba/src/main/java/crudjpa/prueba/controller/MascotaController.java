package crudjpa.prueba.controller;

import crudjpa.prueba.model.Mascota;
import crudjpa.prueba.model.Persona;
import crudjpa.prueba.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MascotaController {
    @Autowired
    IMascotaService interMascota;
    @PostMapping("/mascotas/crear")
    public String createPersona(@RequestBody Mascota masco) {

        interMascota.saveMascota(masco);
        return "la mascota fue crearda correctamente";
    }


}
