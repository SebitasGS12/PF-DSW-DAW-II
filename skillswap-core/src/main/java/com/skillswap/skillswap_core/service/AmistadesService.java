package com.skillswap.skillswap_core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillswap.skillswap_core.entity.Amistades;
import com.skillswap.skillswap_core.repository.IAmistadesRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AmistadesService {
    private final IAmistadesRepository ream;

    public int ultimoId(){
        List<Amistades> lista = ream.findAll();
        if (lista.size() == 0 ) {
            return 1;
        }
        return lista.get(lista.size()-1).getAmistadID()+1 ;
    }

    public List<Amistades> findAll(){
        return ream.findAll();
    }
     public Amistades findById(int id){
        return  ream.findById(id).orElseThrow();
    }

    public Amistades saveAmistades(Amistades amistades) {
        if (amistades.getAmistadID() == null ){
            amistades.setAmistadID(ultimoId());
        }
        return ream.save(amistades);
    }
    
    public void delteAmistadesById(Integer id) {
        ream.deleteById(id);
    }

    public Amistades nullAmistades() {
        Amistades amistades = new Amistades();
        amistades.setAmistadID(null);
        return amistades;
    }
    public Amistades newAmistades() {
        Amistades amistades = new Amistades();
        amistades.setAmistadID(ultimoId());
        return amistades;
    }
}
