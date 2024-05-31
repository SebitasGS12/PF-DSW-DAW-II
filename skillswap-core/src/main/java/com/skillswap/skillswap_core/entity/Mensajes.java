package com.skillswap.skillswap_core.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "mensaje")
@Data
public class Mensajes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mensajeId;
    private String contenido;
    private Date fechaEnvio;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuario obj_usuario;

    @ManyToOne
    @JoinColumn(name = "chatId")
    private Chat obj_chat;
}
