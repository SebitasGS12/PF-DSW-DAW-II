package com.skillswap.skillswap_core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillswap.skillswap_core.entity.Notificaciones;
import com.skillswap.skillswap_core.entity.Usuario;

@Repository
public interface INotificacionesRepository extends JpaRepository<Notificaciones, Integer>{
    List<Notificaciones> findByUsuario(Usuario usuario);
}
