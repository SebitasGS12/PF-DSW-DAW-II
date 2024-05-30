package com.skillswap.skillswap_core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillswap.skillswap_core.entity.Sesion;
import com.skillswap.skillswap_core.repository.ISesionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SesionService {
              private final ISesionRepository reses;

    public int ultimoId(){
        List<Sesion> lista = reses.findAll();
        if (lista.size() == 0 ) {
            return 1;
        }
        return lista.get(lista.size()-1).getSesionId()+1 ;
    }

    public List<Sesion> findAll(){
        return reses.findAll();
    }
    public Sesion findById(int id){
        return  reses.findById(id).orElseThrow();
    }

    public void saveSesion(Sesion sesion) {
        if (sesion.getSesionId() == null ){
            sesion.setSesionId(ultimoId());
        }
        reses.save(sesion);
    }
    public void delteSesionById(Integer id) {
        reses.deleteById(id);
    }
    public Sesion nullSesion() {
        Sesion sesion = new Sesion();
        sesion.setSesionId(null);
        return sesion;
    }
    public Sesion newSesion() {
        Sesion sesion = new Sesion();
        sesion.setSesionId(ultimoId());
        return sesion;
    }
}
