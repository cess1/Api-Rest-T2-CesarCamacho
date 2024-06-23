package pe.edu.cibertec.api_rest_t2.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.api_rest_t2.model.bd.Publicacion;
import pe.edu.cibertec.api_rest_t2.repository.PublicacionRepository;

import java.util.List;
import java.util.Optional;


@Service
public class PublicacionServie implements IPublicacionService{


    private PublicacionRepository publicacionRepository;

    @Override
    public List<Publicacion> findAll() {
        return publicacionRepository.findAll();
    }

    @Override
    public Optional<Publicacion> findById(int id) {
        return publicacionRepository.findById(id);
    }

    @Override
    public Publicacion save(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    @Override
    public void deleteById(int id) {
        publicacionRepository.deleteById(id);
    }
}
