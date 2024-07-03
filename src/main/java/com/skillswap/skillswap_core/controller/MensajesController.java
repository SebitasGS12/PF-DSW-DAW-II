package com.skillswap.skillswap_core.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillswap.skillswap_core.Util.Utils;
import com.skillswap.skillswap_core.constants.Alertas;
import com.skillswap.skillswap_core.constants.Estandares;
import com.skillswap.skillswap_core.entity.Chat;
import com.skillswap.skillswap_core.entity.ChatUsuario;
import com.skillswap.skillswap_core.entity.Mensajes;
import com.skillswap.skillswap_core.entity.Notificaciones;
import com.skillswap.skillswap_core.entity.Perfil;
import com.skillswap.skillswap_core.exceptions.ResourceNotFoundException;
import com.skillswap.skillswap_core.service.ChatService;
import com.skillswap.skillswap_core.service.ChatUsuarioService;
import com.skillswap.skillswap_core.service.MensajeService;
import com.skillswap.skillswap_core.service.NotificacionesService;
import com.skillswap.skillswap_core.service.PerfilService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Estandares.API + "Mensajes")
@RequiredArgsConstructor
@CrossOrigin(Estandares.CROSS)
public class MensajesController {
    private final MensajeService mensajeService;
    private final ChatService chatService;
    private final ChatUsuarioService chatUsuarioService;
    private final NotificacionesService notificacionesService;
    private final PerfilService perfilService;
     @GetMapping
    public ResponseEntity<List<Mensajes>> listarMensaje() {
        return ResponseEntity.ok(mensajeService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Mensajes> buscarMensaje(@PathVariable int id) {
        try {
            Mensajes mensajes = mensajeService.findById(id);
            return ResponseEntity.ok(mensajes);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }


    @GetMapping("/chat/{id}")
    public ResponseEntity<List<Mensajes>> buscarMensajesFromChat(@PathVariable int id) {
        try {
            List<Mensajes> mensajes = mensajeService.findByChatId(chatService.findById(id));
            return ResponseEntity.ok(mensajes);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }


    @PostMapping
    public ResponseEntity<Mensajes> guardarMensajes(@RequestBody Mensajes mensajes) {
        Mensajes nuevoMensaje = mensajeService.saveMensajes(mensajes);

        ChatUsuario chatOfMensaje = chatUsuarioService.getChatUsuarioOfChatAndUser(mensajes.getChat(),mensajes.getObj_Usuario());
        
        Perfil perfilEmisor = perfilService.findByUsuario(mensajes.getObj_Usuario());


        Notificaciones notificiacion = new Notificaciones();

        notificiacion.setTitulo(Alertas.tituloNuevoMensaje);
        notificiacion.setContenido(Alertas.crearMensajeRecibido( perfilEmisor.getNombreCompleto()));
        notificiacion.setFechaCreacion(Utils.getFechaHoy());
        notificiacion.setLeido(Boolean.FALSE);
        notificiacion.setUsuario(chatOfMensaje.getAmigo());

        notificacionesService.saveNotificaciones(notificiacion);


        return new ResponseEntity<>(nuevoMensaje, HttpStatus.CREATED);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Mensajes> actualizarMensajes(@PathVariable int id, @RequestBody Mensajes newMensaje) {
        validarExistencia(id);
        newMensaje.setMensajeId(id);
        Mensajes updatedMensaje = mensajeService.saveMensajes(newMensaje);
        return ResponseEntity.ok(updatedMensaje);
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarMensaje(@PathVariable int id) {
        validarExistencia(id);
        mensajeService.delteMensajesById(id);
        String msg = "Mensaje Eliminado : " + id;
        return ResponseEntity.ok(msg);
    }

    private void validarExistencia(int id) {
        try {
            mensajeService.findById(id);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }
}
