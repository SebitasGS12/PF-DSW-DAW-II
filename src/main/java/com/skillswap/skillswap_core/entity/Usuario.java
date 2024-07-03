package com.skillswap.skillswap_core.entity;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usuarioId;
    private String correo;
    private String contrasenia;
    private Date fechaRegistro;
    private Boolean estado;

    //Las foraneas se llamaran de esta manera
    @ManyToOne
    @JoinColumn(name = "tipoUsuarioID")
    private TipoUsuario obj_tipoUsuario;
    
    @JsonIgnore
    @OneToMany(mappedBy = "usuario",cascade =CascadeType.ALL,orphanRemoval = true )
    private List<Amistades>  amistades = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "obj_Usuario",cascade =CascadeType.ALL,orphanRemoval = true )
    private List<Mensajes>  mensajes = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "usuario",cascade =CascadeType.ALL,orphanRemoval = true )
    private List<Notificaciones>  notificaciones = new ArrayList<>();
    
    //TODO AGREGAR NULL AL ELIMINAR
    @JsonIgnore
    @OneToMany(mappedBy = "obj_Usuario" )
    private List<Discusiones>  discusiones = new ArrayList<>();
    
    //TODO AGREGAR NULL AL ELIMINAR
    @JsonIgnore
    @OneToMany(mappedBy = "obj_Usuario")
    private List<Foros>  foros = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "obj_Usuario",cascade =CascadeType.ALL,orphanRemoval = true )
    private List<Respuestas>  respuestas = new ArrayList<>();
}
