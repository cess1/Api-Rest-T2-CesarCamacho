package pe.edu.cibertec.api_rest_t2.service;

import pe.edu.cibertec.api_rest_t2.model.bd.Autor;

import java.util.List;
import java.util.Optional;

public interface IAutorService {
    List<Autor> findAll();
    Optional<Autor> findById(int id);
    Autor save(Autor autor);
    void deleteById(int id);
}
