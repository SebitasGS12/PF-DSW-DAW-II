package com.skillswap.skillswap_core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillswap.skillswap_core.entity.Amistades;
import com.skillswap.skillswap_core.entity.Chat;
import com.skillswap.skillswap_core.entity.ChatUsuario;
import com.skillswap.skillswap_core.entity.Notificaciones;
import com.skillswap.skillswap_core.entity.Usuario;
import com.skillswap.skillswap_core.repository.IChatUsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ChatUsuarioService {
      private final IChatUsuarioRepository rechus;

    public int ultimoId(){
        List<ChatUsuario> lista = rechus.findAll();
        if (lista.size() == 0 ) {
            return 1;
        }
        return lista.get(lista.size()-1).getChatUsuarioId()+1 ;
    }

    public List<ChatUsuario> findAll(){
        return rechus.findAll();
    }
           public ChatUsuario findById(int id){
        return  rechus.findById(id).orElseThrow();
    }

    public ChatUsuario saveChatUsuario(ChatUsuario chatUsuario) {
        if (chatUsuario.getChatUsuarioId() == null ){
            chatUsuario.setChatUsuarioId(ultimoId());
        }
        return rechus.save(chatUsuario);
    }
    public void delteChatUsuarioById(Integer id) {
        rechus.deleteById(id);
    }
    public ChatUsuario nullChatUsuario() {
        ChatUsuario chatUsuario = new ChatUsuario();
        chatUsuario.setChatUsuarioId(null);
        return chatUsuario;
    }
    public ChatUsuario newChatUsuario() {
        ChatUsuario chatUsuario = new ChatUsuario();
        chatUsuario.setChatUsuarioId(ultimoId());
        return chatUsuario;
    }


    public ChatUsuario getChatUsuarioOfChatAndUser(Chat chat , Usuario emisor){
        return rechus.findByUsuarioAndChat(emisor, chat);

    }

    public ChatUsuario findByUsuarioAmigo(Usuario usuario) {
        return rechus.findByAmigo(usuario);
    }

    public void saveChatUsuarioWithAmistadAndChat(Amistades amistades, Chat chat) {
       
        ChatUsuario chatUsuario = newChatUsuario();
        
        chatUsuario.setAmigo(amistades.getAmigo());
        chatUsuario.setUsuario(amistades.getUsuario());
        chatUsuario.setChat(chat);

        rechus.save(chatUsuario);
    }

    public ChatUsuario obtenerChatUsuarioByUsuario(int usuarioId, int amigoId) {
    
        return rechus.findByUsuario_usuarioIdAndAmigo_usuarioId(usuarioId,amigoId);
    
    }

}
