package com.skillswap.skillswap_core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillswap.skillswap_core.Util.Utils;
import com.skillswap.skillswap_core.entity.Chat;
import com.skillswap.skillswap_core.repository.IChatRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ChatService {
        private final IChatRepository rechat;

    public int ultimoId(){
        List<Chat> lista = rechat.findAll();
        if (lista.size() == 0 ) {
            return 1;
        }
        return lista.get(lista.size()-1).getChatId()+1 ;
    }

    public List<Chat> findAll(){
        return rechat.findAll();
    }
         public Chat findById(int id){
        return  rechat.findById(id).orElseThrow();
    }

    public Chat saveChat(Chat chat) {
        if (chat.getChatId() == null ){
            chat.setChatId(ultimoId());
        }
        return rechat.save(chat);
    }
 
    public void deleteChatById(Integer id) {
        rechat.deleteById(id);
    }
    public Chat nullChat() {
        Chat chat = new Chat();
        chat.setChatId(null);
        return chat;
    }

    public Chat newChat() {
        Chat chat = new Chat();
        chat.setChatId(ultimoId());
        return chat;
    }

    public Chat generarNuevoChat() {
        Chat chat = newChat();
        chat.setFechaCreacion(Utils.getFechaHoy());
        chat.setFechaModificacion(Utils.getFechaHoy());
        chat.setNombre("Chat Basico");
        return rechat.save(chat);
    }
}
