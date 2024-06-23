package pe.edu.cibertec.api_rest_t2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.api_rest_t2.model.bd.Autor;
import pe.edu.cibertec.api_rest_t2.model.bd.Publicacion;
import pe.edu.cibertec.api_rest_t2.service.AutorService;
import pe.edu.cibertec.api_rest_t2.service.IPublicacionService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/publicacion")
public class PublicacionController {


        @Autowired
        private IPublicacionService publicacionService;

        @GetMapping
        public ResponseEntity<List<Publicacion>> getAllPublicaciones() {
            List<Publicacion> publicaciones = publicacionService.findAll();
            return new ResponseEntity<>(publicaciones, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Publicacion> getPublicacionById(@PathVariable int id) {
            Optional<Publicacion> publicacion = publicacionService.findById(id);
            return publicacion.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

        @PostMapping
        public ResponseEntity<Publicacion> createPublicacion(@RequestBody Publicacion publicacion) {
            Publicacion newPublicacion = publicacionService.save(publicacion);
            return new ResponseEntity<>(newPublicacion, HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Publicacion> updatePublicacion(@PathVariable int id, @RequestBody Publicacion publicacion) {
            Optional<Publicacion> currentPublicacion = publicacionService.findById(id);

            if (currentPublicacion.isPresent()) {
                Publicacion updatedPublicacion = currentPublicacion.get();
                updatedPublicacion.setTitulo(publicacion.getTitulo());
                updatedPublicacion.setResumen(publicacion.getResumen());
                updatedPublicacion.setFechPublicacion(publicacion.getFechPublicacion());
                updatedPublicacion.setAutor(publicacion.getAutor());
                publicacionService.save(updatedPublicacion);
                return new ResponseEntity<>(updatedPublicacion, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

}
