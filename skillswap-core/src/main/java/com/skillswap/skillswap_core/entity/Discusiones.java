package com.skillswap.skillswap_core.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "discuciones")
@Data
public class Discusiones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int discusionesId;
    private String titulo;
    private String descripcion;
    private Date fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuarios obj_Usuario;

    @ManyToOne
    @JoinColumn(name = "foroId")
    private Foros obj_Foro;
}
