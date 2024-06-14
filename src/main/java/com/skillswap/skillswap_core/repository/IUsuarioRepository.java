package com.skillswap.skillswap_core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillswap.skillswap_core.entity.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer>{
}
