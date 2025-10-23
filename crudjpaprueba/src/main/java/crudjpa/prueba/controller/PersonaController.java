package crudjpa.prueba.controller;

import crudjpa.prueba.model.Persona;
import crudjpa.prueba.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {
    @Autowired
    private IPersonaService interPersona;


    @GetMapping("/personas/traer")
    public List<Persona> getPersona() {

        return interPersona.getPersonas();
    }

    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona pers) {

        interPersona.savePersona(pers);
        return "la persona fue crearda correctamente";
    }


    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {


        interPersona.deletePersona(id);
        return "peronsa borrada correctamente";
    }

    @PutMapping("/persona/editar/{id_original}")
    public Persona editPersona(@PathVariable Long id_original,
                               @RequestParam(required = false, name = "id") Long nuevaId,
                               @RequestParam(required = false, name = "nombre") String nuevoNombre,
                               @RequestParam(required = false, name = "apellido") String nuevoApellido,
                               @RequestParam(required = false, name = "edad") int nuevaedad) {

        interPersona.editPersona(id_original, nuevaId, nuevoNombre, nuevoApellido, nuevaedad);

        Persona perso = interPersona.findPersona(nuevaId);
        return perso;

    }

    @PutMapping("/persona/editar")
    public Persona editPersona(@RequestBody Persona per){

        interPersona.editPersona(per);

        return interPersona.findPersona(per.getId());

    }

}
