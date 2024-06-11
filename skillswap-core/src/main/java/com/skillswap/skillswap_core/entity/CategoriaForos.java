package com.skillswap.skillswap_core.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "categoriaForos")
@Data
public class CategoriaForos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoriaId;
    private String nombre;
    private String descripcion;
    private Date fechaCreacion;

    @OneToMany(mappedBy = "obj_CategoriaForo" )
    private List<Foros>  foros = new ArrayList<>();
}
