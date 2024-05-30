package com.skillswap.skillswap_core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillswap.skillswap_core.entity.Votos;
import com.skillswap.skillswap_core.repository.IVotosRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VotosService {
    private final IVotosRepository revot;

    public int ultimoId(){
        List<Votos> lista = revot.findAll();
        if (lista.size() == 0 ) {
            return 1;
        }
        return lista.get(lista.size()-1).getVotoId()+1 ;
    }

    public List<Votos> findAll(){
        return revot.findAll();
    }
    public Votos findById(int id){
        return  revot.findById(id).orElseThrow();
    }

    public void saveVotos(Votos votos) {
        if (votos.getVotoId() == null ){
            votos.setVotoId(ultimoId());
        }
        revot.save(votos);
    }
    public void delteVotosById(Integer id) {
        revot.deleteById(id);
    }
    public Votos nullVotos() {
        Votos votos = new Votos();
        votos.setVotoId(null);
        return votos;
    }
    public Votos newVotos() {
        Votos votos = new Votos();
        votos.setVotoId(ultimoId());
        return votos;
    }
}
