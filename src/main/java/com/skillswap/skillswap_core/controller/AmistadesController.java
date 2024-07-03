package com.skillswap.skillswap_core.controller;

import com.skillswap.skillswap_core.Util.Utils;
import com.skillswap.skillswap_core.constants.Estandares;
import com.skillswap.skillswap_core.entity.Amistades;
import com.skillswap.skillswap_core.entity.Chat;
import com.skillswap.skillswap_core.entity.ChatUsuario;
import com.skillswap.skillswap_core.entity.Notificaciones;
import com.skillswap.skillswap_core.exceptions.ResourceNotFoundException;
import com.skillswap.skillswap_core.service.AmistadesService;
import com.skillswap.skillswap_core.service.ChatService;
import com.skillswap.skillswap_core.service.ChatUsuarioService;
import com.skillswap.skillswap_core.service.UsuarioService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(Estandares.API + "Amistades")
@RequiredArgsConstructor
@CrossOrigin(Estandares.CROSS)
public class AmistadesController {

    private final AmistadesService amistadesService;
    private final UsuarioService usuarioService;
    private final ChatService chatService;
    private final ChatUsuarioService chatUsuarioService;


    @GetMapping
    public ResponseEntity<List<Amistades>> listarAmistades() {
        return ResponseEntity.ok(amistadesService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Amistades> buscarAmistad(@PathVariable int id) {
        try {
            Amistades amistad = amistadesService.findById(id);
            return ResponseEntity.ok(amistad);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Amistades>> buscarAmistadesByIdUsuario(@PathVariable int id) {
        try {

            List<Amistades> amistades = amistadesService.findByUsuario(usuarioService.findById(id));
            return ResponseEntity.ok(amistades);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }
    @GetMapping("/existeAmistad")
    public ResponseEntity<Boolean> existeAmistad(@RequestParam int usuarioId, @RequestParam int amigoId) {
        Boolean existe = amistadesService.existeAmistad(usuarioService.findById(usuarioId),usuarioService.findById( amigoId));
        return ResponseEntity.ok(existe);
    }
    @GetMapping("/devolverAmistad")
    public ResponseEntity<List<Amistades>> obtenerAmistadesByUsuarioAndAmigo(@RequestParam int usuarioId, @RequestParam int amigoId) {
        List<Amistades> lstAmistad = new ArrayList<Amistades>();
        Amistades amigo1 = amistadesService.devolverAmistad(usuarioService.findById(usuarioId),usuarioService.findById( amigoId));
        lstAmistad.add(amigo1);
        Amistades amigo2 = amistadesService.devolverAmistad(usuarioService.findById( amigoId),usuarioService.findById(usuarioId));
        lstAmistad.add(amigo2);
        return ResponseEntity.ok(lstAmistad);
    }

    @PostMapping("/registrar")
    public ResponseEntity<List<Amistades>> registrarAmistades(@RequestBody List<Amistades> amistades) {

        List<Amistades> nuevaAmistad = amistadesService.registrarAmistades(amistades);
        Chat chat = chatService.generarNuevoChat();
        chatUsuarioService.saveChatUsuarioWithAmistadAndChat(amistades.get(0),chat);
        chatUsuarioService.saveChatUsuarioWithAmistadAndChat(amistades.get(1),chat);

        return new ResponseEntity<>(nuevaAmistad, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Amistades> guardarAmistad(@RequestBody Amistades amistad) {
        Amistades nuevaAmistad = amistadesService.saveAmistades(amistad);
        return new ResponseEntity<>(nuevaAmistad, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Amistades> actualizarAmistad(@PathVariable int id, @RequestBody Amistades newAmistad) {
        validarExistencia(id);
        newAmistad.setAmistadID(id);
        Amistades updatedAmistad = amistadesService.saveAmistades(newAmistad);
        return ResponseEntity.ok(updatedAmistad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAmistad(@PathVariable int id) {
        validarExistencia(id);
        amistadesService.delteAmistadesById(id);
        String msg = "Amistad Eliminada : " + id;
        return ResponseEntity.ok(msg);
    }

    private void validarExistencia(int id) {
        try {
            amistadesService.findById(id);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }
}
