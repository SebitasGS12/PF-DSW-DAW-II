package com.skillswap.skillswap_core.controller;

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

import com.skillswap.skillswap_core.constants.Estandares;
import com.skillswap.skillswap_core.entity.Perfil;
import com.skillswap.skillswap_core.exceptions.ResourceNotFoundException;
import com.skillswap.skillswap_core.service.PerfilService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Estandares.API + "Perfil")
@RequiredArgsConstructor
@CrossOrigin(Estandares.CROSS)
public class PerfilController {
       private final PerfilService perfilService;
      @GetMapping
    public ResponseEntity<List<Perfil>> listarPerfil() {
        return ResponseEntity.ok(perfilService.findAll());
    }
     @GetMapping("/{id}")
    public ResponseEntity<Perfil> buscarPerfil(@PathVariable int id) {
        try {
            Perfil perfil = perfilService.findById(id);
            return ResponseEntity.ok(perfil);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }
     @PostMapping
    public ResponseEntity<Perfil> guardarPerfil(@RequestBody Perfil perfil) {
        Perfil nuevoPerfil = perfilService.savePerfil(perfil);
        return new ResponseEntity<>(nuevoPerfil, HttpStatus.CREATED);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<Perfil> actualizarPerfil(@PathVariable int id, @RequestBody Perfil newPerfil) {
        validarExistencia(id);
        newPerfil.setPerfilID(id);
        Perfil updatedPerfil = perfilService.savePerfil(newPerfil);
        return ResponseEntity.ok(updatedPerfil);
    }
     @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPerfil(@PathVariable int id) {
        validarExistencia(id);
        perfilService.deltePerfilById(id);
        String msg = "Notificacion Eliminada : " + id;
        return ResponseEntity.ok(msg);
    }

    private void validarExistencia(int id) {
        try {
            perfilService.findById(id);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }
}
