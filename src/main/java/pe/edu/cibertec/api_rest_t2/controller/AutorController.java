package pe.edu.cibertec.api_rest_t2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.api_rest_t2.model.bd.Autor;
import pe.edu.cibertec.api_rest_t2.service.AutorService;

import java.util.List;
import java.util.Optional;

public class AutorController {
    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<Autor>> getAllAutores() {
        List<Autor> autores = autorService.findAll();
        return new ResponseEntity<>(autores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable int id) {
        Optional<Autor> autor = autorService.findById(id);
        return autor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Autor> createAutor(@RequestBody Autor autor) {
        Autor newAutor = autorService.save(autor);
        return new ResponseEntity<>(newAutor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> updateAutor(@PathVariable int id, @RequestBody Autor autor) {
        Optional<Autor> currentAutor = autorService.findById(id);

        if (currentAutor.isPresent()) {
            Autor updatedAutor = currentAutor.get();
            updatedAutor.setNomAutor(autor.getNomAutor());
            updatedAutor.setApeAutor(autor.getApeAutor());
            updatedAutor.setFechNacAutor(autor.getFechNacAutor());
            autorService.save(updatedAutor);
            return new ResponseEntity<>(updatedAutor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}