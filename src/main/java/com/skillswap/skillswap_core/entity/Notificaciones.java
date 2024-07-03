package com.skillswap.skillswap_core.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "notificaciones")
@Data
public class Notificaciones {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer notificacionesId;

    private String titulo;
    private String contenido;
    private Date fechaCreacion;
    private Boolean leido;

    @ManyToOne
    @JoinColumn(name = "imagenId")
    private Imagen obj_imagenId;

    @ManyToOne
    @JoinColumn(name = "usuarioID")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "amigoID")
    private Usuario amigo;

}
