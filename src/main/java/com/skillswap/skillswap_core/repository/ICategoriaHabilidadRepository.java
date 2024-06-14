package com.skillswap.skillswap_core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillswap.skillswap_core.entity.CategoriaHabilidad;

@Repository
public interface ICategoriaHabilidadRepository extends JpaRepository<CategoriaHabilidad, Integer>{

}
