package pe.edu.cibertec.api_rest_t2.model.bd;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAutor")
    private int idAutor;

    @Column(name = "NomAutor", nullable = false, length = 50)
    private String nomAutor;

    @Column(name = "ApeAutor", nullable = false, length = 50)
    private String apeAutor;

    @Column(name = "FechNacAutor", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechNacAutor;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Publicacion> publicaciones;
}
