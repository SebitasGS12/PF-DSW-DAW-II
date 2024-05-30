package com.skillswap.skillswap_core.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "habilidad")
@Data
public class Habilidad {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int habilidadId;
    private String nombre;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "categoriaHabilidadId")
    private CategoriaHabilidad obj_CategoriaHabilidad;

    @ManyToOne
    @JoinColumn(name = "perfilId")
    private Perfil obj_Perfil;

}
