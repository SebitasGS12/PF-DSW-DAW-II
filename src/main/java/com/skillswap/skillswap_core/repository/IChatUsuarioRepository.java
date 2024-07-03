package com.skillswap.skillswap_core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillswap.skillswap_core.entity.Chat;
import com.skillswap.skillswap_core.entity.ChatUsuario;
import com.skillswap.skillswap_core.entity.Usuario;

@Repository
public interface IChatUsuarioRepository extends JpaRepository <ChatUsuario, Integer>{

    ChatUsuario findByAmigo(Usuario usuario);

    ChatUsuario findByUsuarioAndChat(Usuario usuario,Chat chat);

}
