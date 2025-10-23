package crudjpa.prueba.service;

import crudjpa.prueba.model.Mascota;

import java.util.List;

public interface IMascotaService {


    public List<Mascota> getMascota();

    public void saveMascota(Mascota mascota);

    public void deleteMascota(Long id);

    public Mascota findMascota(Long id);

    public void editMascota(Long idOriginal, Long idNueva, String nuevoNombre, String nuevaEspecie,
                            String neuvaRaza, String nuevocolor);
}

