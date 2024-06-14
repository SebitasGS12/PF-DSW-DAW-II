package com.skillswap.skillswap_core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillswap.skillswap_core.entity.Habilidad;
import com.skillswap.skillswap_core.repository.IHabilidadRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HabilidadService {
            private final IHabilidadRepository reha;

    public int ultimoId(){
        List<Habilidad> lista = reha.findAll();
        if (lista.size() == 0 ) {
            return 1;
        }
        return lista.get(lista.size()-1).getHabilidadId()+1 ;
    }

    public List<Habilidad> findAll(){
        return reha.findAll();
    }
    public Habilidad findById(int id){
        return  reha.findById(id).orElseThrow();
    }

    public Habilidad saveHabilidad(Habilidad habilidad) {
        if (habilidad.getHabilidadId() == null ){
            habilidad.setHabilidadId(ultimoId());
        }
       return reha.save(habilidad);
    }
    public void delteHabilidadById(Integer id) {
        reha.deleteById(id);
    }
    public Habilidad nulHabilidad() {
        Habilidad habilidad = new Habilidad();
        habilidad.setHabilidadId(null);
        return habilidad;
    }
    public Habilidad newHabilidad() {
        Habilidad habilidad = new Habilidad();
        habilidad.setHabilidadId(ultimoId());
        return habilidad;
    }
}
