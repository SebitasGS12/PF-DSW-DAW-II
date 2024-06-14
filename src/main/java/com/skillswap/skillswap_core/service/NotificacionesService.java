package com.skillswap.skillswap_core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillswap.skillswap_core.entity.Notificaciones;
import com.skillswap.skillswap_core.repository.INotificacionesRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NotificacionesService {
    private final INotificacionesRepository renot;

    public int ultimoId(){
        List<Notificaciones> lista = renot.findAll();
        if (lista.size() == 0 ) {
            return 1;
        }
        return lista.get(lista.size()-1).getNotificacionesId()+1 ;
    }

    public List<Notificaciones> findAll(){
        return renot.findAll();
    }
    public Notificaciones findById(int id){
        return  renot.findById(id).orElseThrow();
    }

    public Notificaciones saveNotificaciones(Notificaciones notificaciones) {
        if (notificaciones.getNotificacionesId() == null ){
            notificaciones.setNotificacionesId(ultimoId());
        }
        return renot.save(notificaciones);
    }
    public void delteNotificacionesById(Integer id) {
        renot.deleteById(id);
    }
    public Notificaciones nullNotificaciones() {
        Notificaciones notificaciones = new Notificaciones();
        notificaciones.setNotificacionesId(null);
        return notificaciones;
    }
    public Notificaciones newNotificaciones() {
        Notificaciones notificaciones = new Notificaciones();
        notificaciones.setNotificacionesId(ultimoId());
        return notificaciones;
    }
}
