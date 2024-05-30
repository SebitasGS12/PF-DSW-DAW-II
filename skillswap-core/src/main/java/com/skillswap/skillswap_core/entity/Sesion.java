package com.skillswap.skillswap_core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "sesion")
@Data
public class Sesion {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int sesionId;

    @ManyToOne
    @JoinColumn(name = "usuarioID")
    private Usuarios obj_Usuario;

}
