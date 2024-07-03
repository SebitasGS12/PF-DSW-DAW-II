package com.skillswap.skillswap_core.entity;

import java.time.LocalDateTime;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "amistades")
@Data
public class Amistades {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer amistadID;
    private Date fechaAmistad;
    private Boolean amistadAceptada;

    @ManyToOne
    @JoinColumn(name = "usuarioID")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "amigoId")
    private Usuario amigo;

}
