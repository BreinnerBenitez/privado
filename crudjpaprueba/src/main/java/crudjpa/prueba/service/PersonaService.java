package crudjpa.prueba.service;

import crudjpa.prueba.model.Persona;
import crudjpa.prueba.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {
@Autowired
private IPersonaRepository personaRepository;

    @Override
    public List<Persona> getPersonas() {

        List <Persona> listaPersonas = personaRepository.findAll();

        return listaPersonas;
    }

    @Override
    public void savePersona(Persona perso) {

        personaRepository.save(perso);

    }

    @Override
    public void deletePersona(Long id) {

        personaRepository.deleteById(id);


    }

    @Override
    public Persona findPersona(Long id) {
        System.out.println("buscando persona"+id);
        Persona perso= personaRepository.findById(id).orElse(null);

        return perso;
    }

    @Override
    public void editPersona(Long id_original, Long idNueva, String nuevoNombre, String nuevoApellido, int nuevaEdad) {

        Persona perso = this.findPersona(id_original);
        perso.setId (idNueva);
        perso.setApellido(nuevoApellido);
        perso.setNombre(nuevoNombre);
        perso.setEdad(nuevaEdad);
        if (perso == null){

            throw new RuntimeException("no se encontro persona con id: "+id_original);
        }
        this.savePersona(perso);

    }

    @Override
    public void editPersona(Persona per) {
        this.savePersona(per);
    }
}
