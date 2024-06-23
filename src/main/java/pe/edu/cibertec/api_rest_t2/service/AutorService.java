package pe.edu.cibertec.api_rest_t2.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.api_rest_t2.model.bd.Autor;
import pe.edu.cibertec.api_rest_t2.repository.AutorRepository;

import java.util.List;
import java.util.Optional;


@Service
public class AutorService implements IAutorService{
    private AutorRepository autorRepository;

    @Override
    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    @Override
    public Optional<Autor> findById(int id) {
        return autorRepository.findById(id);
    }

    @Override
    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public void deleteById(int id) {
        autorRepository.deleteById(id);
    }
}

