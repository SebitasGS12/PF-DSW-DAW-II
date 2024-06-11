package com.skillswap.skillswap_core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillswap.skillswap_core.entity.Respuestas;
import com.skillswap.skillswap_core.repository.IRespuestasRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RespuestasService {
          private final IRespuestasRepository reresp;

    public int ultimoId(){
        List<Respuestas> lista = reresp.findAll();
        if (lista.size() == 0 ) {
            return 1;
        }
        return lista.get(lista.size()-1).getRespuestasId()+1 ;
    }

    public List<Respuestas> findAll(){
        return reresp.findAll();
    }
    public Respuestas findById(int id){
        return  reresp.findById(id).orElseThrow();
    }

    public void saveRespuestas(Respuestas respuestas) {
        if (respuestas.getRespuestasId() == null ){
            respuestas.setRespuestasId(ultimoId());
        }
        reresp.save(respuestas);
    }
    public void delteRespuestasById(Integer id) {
        reresp.deleteById(id);
    }
    public Respuestas nullRespuestas() {
        Respuestas respuestas = new Respuestas();
        respuestas.setRespuestasId(null);
        return respuestas;
    }
    public Respuestas newRespuestas() {
        Respuestas respuestas = new Respuestas();
        respuestas.setRespuestasId(ultimoId());
        return respuestas;
    }
}
