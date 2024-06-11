package com.skillswap.skillswap_core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillswap.skillswap_core.entity.Imagen;
import com.skillswap.skillswap_core.repository.ImagenRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImagenService {
               private final ImagenRepository reima;

    public int ultimoId(){
        List<Imagen> lista = reima.findAll();
        if (lista.size() == 0 ) {
            return 1;
        }
        return lista.get(lista.size()-1).getImagenID()+1 ;
    }

    public List<Imagen> findAll(){
        return reima.findAll();
    }
    public Imagen findById(int id){
        return  reima.findById(id).orElseThrow();
    }

    public void saveImagen(Imagen imagen) {
        if (imagen.getImagenID() == null ){
            imagen.setImagenID(ultimoId());
        }
        reima.save(imagen);
    }
    public void delteImagenById(Integer id) {
        reima.deleteById(id);
    }
    public Imagen nullImagen() {
        Imagen imagen = new Imagen();
        imagen.setImagenID(null);
        return imagen;
    }
    public Imagen newImagen() {
        Imagen imagen = new Imagen();
        imagen.setImagenID(ultimoId());
        return imagen;
    }
}
