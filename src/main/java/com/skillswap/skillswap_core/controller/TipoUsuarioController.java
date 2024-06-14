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
import com.skillswap.skillswap_core.entity.TipoUsuario;
import com.skillswap.skillswap_core.exceptions.ResourceNotFoundException;
import com.skillswap.skillswap_core.service.TipoUsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Estandares.API + "TipoUsuario")
@RequiredArgsConstructor
@CrossOrigin(Estandares.CROSS)
public class TipoUsuarioController {
    private final TipoUsuarioService tipoUsuarioService;
     @GetMapping
    public ResponseEntity<List<TipoUsuario>> listarTipoUsuario() {
        return ResponseEntity.ok(tipoUsuarioService.findAll());
    }
     @GetMapping("/{id}")
    public ResponseEntity<TipoUsuario> buscarTipoUsuario(@PathVariable int id) {
        try {
            TipoUsuario tipoUsuario = tipoUsuarioService.findById(id);
            return ResponseEntity.ok(tipoUsuario);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }
     @PostMapping
    public ResponseEntity<TipoUsuario> guardarTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
        TipoUsuario nuevoTipoUsuario = tipoUsuarioService.saveTipoUsuario(tipoUsuario);
        return new ResponseEntity<>(nuevoTipoUsuario, HttpStatus.CREATED);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoUsuario> actualizarTipoUsuario(@PathVariable int id, @RequestBody TipoUsuario newTipoUsuario) {
        validarExistencia(id);
        newTipoUsuario.setTipoUsuarioID(id);
        TipoUsuario updatedTipoUsuario = tipoUsuarioService.saveTipoUsuario(newTipoUsuario);
        return ResponseEntity.ok(updatedTipoUsuario);
    }
     @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTipoUsuario(@PathVariable int id) {
        validarExistencia(id);
        tipoUsuarioService.deleteTipoUsuarioById(id);
        String msg = "Respuesta Eliminada : " + id;
        return ResponseEntity.ok(msg);
    }

    private void validarExistencia(int id) {
        try {
            tipoUsuarioService.findById(id);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }
}
