package com.skillswap.skillswap_core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tipoUsuario")
@Data
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer tipoUsuarioID;
    private String descripcion;
}
