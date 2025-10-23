package crudjpa.prueba.service;

import crudjpa.prueba.model.Mascota;
import crudjpa.prueba.model.Mascota;
import crudjpa.prueba.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService implements IMascotaService {

    @Autowired
    private IMascotaRepository mascotaRepository;

    @Override
    public List<Mascota> getMascota() {
        List<Mascota> listaMascota = mascotaRepository.findAll();

        return listaMascota;
    }

    @Override
    public void saveMascota(Mascota mascota) {

        mascotaRepository.save(mascota);
    }

    @Override
    public void deleteMascota(Long id) {

    mascotaRepository.deleteById(id);

    }

    @Override
    public Mascota findMascota(Long id) {
        Mascota masco= mascotaRepository.findById(id).orElse(null);

        return masco;
    }

    @Override
    public void editMascota(Long idOriginal, Long idNueva, String nuevoNombre, String nuevaEspecie, String neuvaRaza, String nuevocolor) {

        Mascota masco = this.findMascota(idOriginal);
        masco.setId_mascota(idNueva);
        masco.setEspecie(nuevaEspecie);
        masco.setNombre(nuevoNombre);
        masco.setRaza(neuvaRaza);
        masco.setColor(nuevocolor);
        if (masco == null){

            throw new RuntimeException("no se encontro Mascota con id: "+idOriginal);
        }
        this.saveMascota(masco);

    }
}
