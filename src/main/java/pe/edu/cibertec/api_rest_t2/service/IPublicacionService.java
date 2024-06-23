package pe.edu.cibertec.api_rest_t2.service;

import pe.edu.cibertec.api_rest_t2.model.bd.Publicacion;

import java.util.List;
import java.util.Optional;

public interface IPublicacionService {
    List<Publicacion> findAll();
    Optional<Publicacion> findById(int id);
    Publicacion save(Publicacion publicacion);
    void deleteById(int id);
}
