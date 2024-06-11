package com.skillswap.skillswap_core.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @JoinColumn(name = "usuarioId")
    private Usuario obj_Usuario;

    @ManyToOne
    @JoinColumn(name = "categoriaForoId")
    private CategoriaForos obj_CategoriaForo;

    @OneToMany(mappedBy = "obj_Foro",cascade =CascadeType.ALL,orphanRemoval = true )
    private List<Discusiones>  discusiones = new ArrayList<>();

}
