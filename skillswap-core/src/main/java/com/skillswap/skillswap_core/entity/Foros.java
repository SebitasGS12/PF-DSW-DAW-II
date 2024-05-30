package com.skillswap.skillswap_core.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "foros")
@Data
public class Foros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foroId;
    private String titulo;
    private String descripcion;
    private Date fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "categoriaForoId")
    private CategoriaForos obj_CategoriaForo;
}
