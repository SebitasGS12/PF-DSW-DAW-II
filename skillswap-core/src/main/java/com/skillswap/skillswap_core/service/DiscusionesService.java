package com.skillswap.skillswap_core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillswap.skillswap_core.entity.Discusiones;
import com.skillswap.skillswap_core.repository.IDiscusionesRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DiscusionesService {
          private final IDiscusionesRepository redis;

    public int ultimoId(){
        List<Discusiones> lista = redis.findAll();
        if (lista.size() == 0 ) {
            return 1;
        }
        return lista.get(lista.size()-1).getDiscusionesId()+1 ;
    }

    public List<Discusiones> findAll(){
        return redis.findAll();
    }
            public Discusiones findById(int id){
        return  redis.findById(id).orElseThrow();
    }

    public Discusiones saveDiscusiones(Discusiones discusiones) {
        if (discusiones.getDiscusionesId() == null ){
            discusiones.setDiscusionesId(ultimoId());
        }
        return redis.save(discusiones);
    }
    public void delteDiscusionesById(Integer id) {
        redis.deleteById(id);
    }
    public Discusiones nullDiscusiones() {
        Discusiones discusiones = new Discusiones();
        discusiones.setDiscusionesId(null);
        return discusiones;
    }
    public Discusiones newDiscusiones() {
        Discusiones discusiones = new Discusiones();
        discusiones.setDiscusionesId(ultimoId());
        return discusiones;
    }
}
