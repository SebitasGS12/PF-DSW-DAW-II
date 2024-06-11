package com.skillswap.skillswap_core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillswap.skillswap_core.entity.Mensajes;
import com.skillswap.skillswap_core.repository.IMensajeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MensajeService {
    private final IMensajeRepository remen;

    public int ultimoId(){
        List<Mensajes> lista = remen.findAll();
        if (lista.size() == 0 ) {
            return 1;
        }
        return lista.get(lista.size()-1).getMensajeId()+1 ;
    }

    public List<Mensajes> findAll(){
        return remen.findAll();
    }
    public Mensajes findById(int id){
        return  remen.findById(id).orElseThrow();
    }

    public void saveMensajes(Mensajes mensajes) {
        if (mensajes.getMensajeId() == null ){
            mensajes.setMensajeId(ultimoId());
        }
        remen.save(mensajes);
    }
    public void delteMensajesById(Integer id) {
        remen.deleteById(id);
    }
    public Mensajes nullMensajes() {
        Mensajes mensajes = new Mensajes();
        mensajes.setMensajeId(null);
        return mensajes;
    }
    public Mensajes newMensajes() {
        Mensajes mensajes = new Mensajes();
        mensajes.setMensajeId(ultimoId());
        return mensajes;
    }
}
