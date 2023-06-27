package gia.utp.primerproyecto.model.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "libro")
public class LibroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nombre_libro")
    private String nombreLibro;

    @Column(name = "autor_libro")
    private String autorLibro;

    private String editorial;
}

