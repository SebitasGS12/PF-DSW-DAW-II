package com.skillswap.skillswap_core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillswap.skillswap_core.dto.DiscucionesTagsId;
import com.skillswap.skillswap_core.entity.DiscucionesTags;
import com.skillswap.skillswap_core.entity.Discusiones;
import com.skillswap.skillswap_core.repository.IDiscucionesTagsRepository;
import com.skillswap.skillswap_core.repository.IDiscusionesRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DiscusionesTagsService {
    private final IDiscucionesTagsRepository redistag;

    public List<DiscucionesTags> findAll(){
        return redistag.findAll();
    }

        public DiscucionesTags findById(DiscucionesTagsId id){
        return  redistag.findById(id).orElseThrow();
    }

    public DiscucionesTags saveDiscusiones(DiscucionesTags discusiones) {

        if (validarDiscucionesTagId(discusiones.getDiscucionesTagsId())) {
            return redistag.save(discusiones);
        }    
        return discusiones;
    }
    private boolean validarDiscucionesTagId(DiscucionesTagsId discucionesTagsId) {
        
        if (
            discucionesTagsId.getObj_Discuciones() != null && discucionesTagsId.getObj_Tags() !=null
        ) {
            return true;
        }
        return false;

    }

    public void delteDiscusionesById(DiscucionesTagsId id) {
        redistag.deleteById(id);
    }
    public DiscucionesTags nullDiscusiones() {
        DiscucionesTags discusionesTags = new DiscucionesTags();
        discusionesTags.setDiscucionesTagsId(null);
        return discusionesTags;
    }

}
