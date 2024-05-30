package com.skillswap.skillswap_core.entity;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuarios {

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

}
