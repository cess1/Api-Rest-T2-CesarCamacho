package pe.edu.cibertec.api_rest_t2.model.bd;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Publicacion")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPublicacion")
    private int idPublicacion;

    @Column(name = "Titulo", nullable = false, length = 250)
    private String titulo;

    @Column(name = "Resumen", nullable = false, length = 250)
    private String resumen;

    @Column(name = "FechPublicacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechPublicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdAutor", nullable = false)
    private Autor autor;

}
