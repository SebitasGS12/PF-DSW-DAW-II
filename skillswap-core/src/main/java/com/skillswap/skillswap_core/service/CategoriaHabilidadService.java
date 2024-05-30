package com.skillswap.skillswap_core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillswap.skillswap_core.entity.CategoriaHabilidad;
import com.skillswap.skillswap_core.repository.ICategoriaHabilidadRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoriaHabilidadService {
    private final ICategoriaHabilidadRepository reha;

    public int ultimoId(){
        List<CategoriaHabilidad> lista = reha.findAll();
        if (lista.size() == 0 ) {
            return 1;
        }
        return lista.get(lista.size()-1).getCategoriaHabilidadId()+1 ;
    }

    public List<CategoriaHabilidad> findAll(){
        return reha.findAll();
    }
         public CategoriaHabilidad findById(int id){
        return  reha.findById(id).orElseThrow();
    }

    public void saveCategoriaHabilidad(CategoriaHabilidad categoriaHabilidad) {
        if (categoriaHabilidad.getCategoriaHabilidadId() == null ){
            categoriaHabilidad.setCategoriaHabilidadId(ultimoId());
        }
        reha.save(categoriaHabilidad);
    }
    public void delteCategoriaHabilidadById(Integer id) {
        reha.deleteById(id);
    }
    public CategoriaHabilidad nullCategoriaHabilidad() {
        CategoriaHabilidad categoriaHabilidad = new CategoriaHabilidad();
        categoriaHabilidad.setCategoriaHabilidadId(null);
        return categoriaHabilidad;
    }
    public CategoriaHabilidad newCategoriaHabilidad() {
        CategoriaHabilidad categoriaHabilidad = new CategoriaHabilidad();
        categoriaHabilidad.setCategoriaHabilidadId(ultimoId());
        return categoriaHabilidad;
    }
}
