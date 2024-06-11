package com.skillswap.skillswap_core.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categoriaHabilidad")
@Data
public class CategoriaHabilidad {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer categoriaHabilidadId;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "imagenId")
    private Imagen obj_imagenId;

}
