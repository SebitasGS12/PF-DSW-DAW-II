package com.skillswap.skillswap_core.entity;

import com.skillswap.skillswap_core.dto.DiscucionesTagsId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "discucionesTags")
@Data
public class DiscucionesTags {

    @EmbeddedId
    private DiscucionesTagsId discucionesTagsId;
}
