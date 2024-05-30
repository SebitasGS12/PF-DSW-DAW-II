package com.skillswap.skillswap_core.dto;

import com.skillswap.skillswap_core.entity.Discusiones;
import com.skillswap.skillswap_core.entity.Tags;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class DiscucionesTagsId implements Serializable {

    private static final long serialVersionUID = 1L;
    @ManyToOne
    @JoinColumn(name = "discucionesId")
    private Discusiones obj_Discuciones;

    @ManyToOne
    @JoinColumn(name = "tagsId")
    private Tags obj_Tags;
}
