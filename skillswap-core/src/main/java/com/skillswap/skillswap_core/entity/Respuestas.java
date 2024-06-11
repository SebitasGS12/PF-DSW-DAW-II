package com.skillswap.skillswap_core.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "respuestas")
@Data
public class Respuestas {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer respuestasId;
    private String contenido;
    private Date fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "usuarioID")
    private Usuario obj_Usuario;

    @ManyToOne
    @JoinColumn(name = "discucionesId")
    private Discusiones obj_Discuciones;

    @OneToMany(mappedBy = "obj_Respuesta",cascade =CascadeType.ALL,orphanRemoval = true )
    private List<Votos>  votos = new ArrayList<>();

}
