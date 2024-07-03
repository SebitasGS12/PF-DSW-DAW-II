package com.skillswap.skillswap_core.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "perfil")
@Data
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer perfilID;

    private String nombre;
    private String apellido;
    private String telefono;

    @Column(nullable = true)
    private Date fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "imagenPerfilId")
    private Imagen obj_imagenPerfilId;

    @ManyToOne
    @JoinColumn(name = "imagenCabeceraId")
    private Imagen obj_imagenCabeceraId;

    private String biografia;

    @OneToOne
    @JoinColumn(name = "usuarioID")
    private Usuario usuario;


    public String getNombreCompleto(){
        return this.nombre + " " + this.apellido;
    }

}
