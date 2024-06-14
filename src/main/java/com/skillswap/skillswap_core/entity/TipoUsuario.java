package com.skillswap.skillswap_core.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tipoUsuario")
@Data
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer tipoUsuarioID;
    private String descripcion;


    //Si queremos que se realize una elminiacion por cascada usamos esto
    //@OneToMany(mappedBy = "obj_tipoUsuario",cascade =CascadeType.ALL,orphanRemoval = true )
    @JsonIgnore
    @OneToMany(mappedBy = "obj_tipoUsuario")
    private List<Usuario>  usuarios = new ArrayList<>();
    //SI NO QUEREMOS ESO
    /*
    *   Lo dejamos asi , pero tendremos que desvicunlarlo automatica mente
    *
    *   La diferencia es que si usamos cascada , eliminara todas las entidades asociadas,
    *  si quitamos la cascada , no lo elmiinara pero podra generar error por la vinculacion de la FK , entonces
    *  tendremos que desvincularlo automaticamente -> ver service.
    * */

}
