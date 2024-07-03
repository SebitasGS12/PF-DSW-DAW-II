package com.skillswap.skillswap_core.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "chatUsuario")
@Data
public class ChatUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer chatUsuarioId;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;

    
    @ManyToOne
    @JoinColumn(name = "amigoId")
    private Usuario amigo;

    @ManyToOne
    @JoinColumn(name = "chatId")
    private Chat chat;
}
