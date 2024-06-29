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
import com.skillswap.skillswap_core.entity.Usuario;
import com.skillswap.skillswap_core.exceptions.ResourceNotFoundException;
import com.skillswap.skillswap_core.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Estandares.API + "Usuario")
@RequiredArgsConstructor
@CrossOrigin(Estandares.CROSS)
public class UsuarioController {
    private final UsuarioService usuarioService;
     @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuario() {
        return ResponseEntity.ok(usuarioService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable int id) {
        try {
            Usuario usuario = usuarioService.findById(id);
            return ResponseEntity.ok(usuario);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }
     @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.saveUsuario(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable int id, @RequestBody Usuario newUsuario) {
        validarExistencia(id);
        newUsuario.setUsuarioId(id);
        Usuario updatedUsuario = usuarioService.saveUsuario(newUsuario);
        return ResponseEntity.ok(updatedUsuario);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable int id) {
        validarExistencia(id);
        usuarioService.delteUsuarioById(id);
        String msg = "Usuario Eliminado : " + id;
        return ResponseEntity.ok(msg);
    }

    private void validarExistencia(int id) {
        try {
            usuarioService.findById(id);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }
}
