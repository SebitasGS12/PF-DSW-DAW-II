package com.skillswap.skillswap_core.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillswap.skillswap_core.entity.Amistades;
import com.skillswap.skillswap_core.entity.Usuario;

@Repository
public interface IAmistadesRepository extends JpaRepository<Amistades, Integer>{

    List<Amistades> findByUsuario(Usuario usuario);
    Optional<Amistades> findByUsuarioAndAmigo(Usuario usuario,Usuario amigo);

}
