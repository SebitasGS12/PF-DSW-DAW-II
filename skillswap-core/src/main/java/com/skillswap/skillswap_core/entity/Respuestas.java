package com.skillswap.skillswap_core.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "respuestas")
@Data
public class Respuestas {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int respuestasId;
    private String contenido;
    private Date fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "usuarioID")
    private Usuarios obj_Usuario;

    @ManyToOne
    @JoinColumn(name = "discucionesId")
    private Discusiones obj_Discuciones;

}
