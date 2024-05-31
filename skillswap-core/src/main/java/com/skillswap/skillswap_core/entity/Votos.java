package com.skillswap.skillswap_core.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "votos")
@Data
public class Votos {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer votoId;

    private Boolean tipoVoto;

    private Date fechaVoto;

    @ManyToOne
    @JoinColumn(name = "respuestaId")
    private Respuestas obj_Respuesta;

    @ManyToOne
    @JoinColumn(name = "usuarioID")
    private Usuario obj_Usuario;

}
