package com.skillswap.skillswap_core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillswap.skillswap_core.dto.DiscucionesTagsId;
import com.skillswap.skillswap_core.entity.DiscucionesTags;

@Repository
public interface IDiscucionesTagsRepository extends  JpaRepository<DiscucionesTags,DiscucionesTagsId>     {
    
}
