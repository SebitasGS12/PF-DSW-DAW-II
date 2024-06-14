package com.skillswap.skillswap_core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillswap.skillswap_core.entity.CategoriaForos;
import com.skillswap.skillswap_core.repository.ICategoriaForosRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoriaForosService {
         private final ICategoriaForosRepository recafo;

    public int ultimoId(){
        List<CategoriaForos> lista = recafo.findAll();
        if (lista.size() == 0 ) {
            return 1;
        }
        return lista.get(lista.size()-1).getCategoriaId()+1 ;
    }

    public List<CategoriaForos> findAll(){
        return recafo.findAll();
    }
         public CategoriaForos findById(int id){
        return  recafo.findById(id).orElseThrow();
    }


    public CategoriaForos saveCategoriasForos(CategoriaForos categoriaForos) {
        if (categoriaForos.getCategoriaId() == null ){
            categoriaForos.setCategoriaId(ultimoId());
        }
        return recafo.save(categoriaForos);
    }

    public void delteCategoriaForos(Integer id) {
        recafo.deleteById(id);
    }

    public CategoriaForos nullCategoriaForos() {
        CategoriaForos categoriaForos = new CategoriaForos();
        categoriaForos.setCategoriaId(null);
        return categoriaForos;
    }
    public CategoriaForos newCategoriaForos() {
        CategoriaForos categoriaForos = new CategoriaForos();
        categoriaForos.setCategoriaId(ultimoId());
        return categoriaForos;
    }
}
