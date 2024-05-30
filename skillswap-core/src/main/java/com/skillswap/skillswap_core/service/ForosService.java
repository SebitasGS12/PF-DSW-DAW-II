package com.skillswap.skillswap_core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillswap.skillswap_core.entity.Foros;
import com.skillswap.skillswap_core.repository.IForosRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ForosService {
             private final IForosRepository refo;

    public int ultimoId(){
        List<Foros> lista = refo.findAll();
        if (lista.size() == 0 ) {
            return 1;
        }
        return lista.get(lista.size()-1).getForoId()+1 ;
    }

    public List<Foros> findAll(){
        return refo.findAll();
    }
    public Foros findById(int id){
        return  refo.findById(id).orElseThrow();
    }

    public void saveForos(Foros foros) {
        if (foros.getForoId() == null ){
            foros.setForoId(ultimoId());
        }
        refo.save(foros);
    }
    public void delteForosById(Integer id) {
        refo.deleteById(id);
    }
    public Foros nullForos() {
        Foros foros = new Foros();
        foros.setForoId(null);
        return foros;
    }
    public Foros newForos() {
        Foros foros = new Foros();
        foros.setForoId(ultimoId());
        return foros;
    }
}
