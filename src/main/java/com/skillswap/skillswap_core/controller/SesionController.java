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
import com.skillswap.skillswap_core.entity.Sesion;
import com.skillswap.skillswap_core.exceptions.ResourceNotFoundException;
import com.skillswap.skillswap_core.service.SesionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Estandares.API + "Sesion")
@RequiredArgsConstructor
@CrossOrigin(Estandares.CROSS)
public class SesionController {
         private final SesionService sesionService;
    @GetMapping
    public ResponseEntity<List<Sesion>> listarSesion() {
        return ResponseEntity.ok(sesionService.findAll());
    }

    @GetMapping("/actual")
    public ResponseEntity<Sesion> obtenerSesion() {
        return ResponseEntity.ok(sesionService.getSesion());
    }

     @GetMapping("/{id}")
    public ResponseEntity<Sesion> buscarSesion(@PathVariable int id) {
        try {
            Sesion sesion = sesionService.findById(id);
            return ResponseEntity.ok(sesion);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }
     @PostMapping
    public ResponseEntity<Sesion> guardarSesion(@RequestBody Sesion sesion) {
        Sesion nuevoSesion = sesionService.saveSesion(sesion);
        return new ResponseEntity<>(nuevoSesion, HttpStatus.CREATED);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<Sesion> actualizarSesion(@PathVariable int id, @RequestBody Sesion newSesion) {
        validarExistencia(id);
        newSesion.setSesionId(id);
        Sesion updatedSesion = sesionService.saveSesion(newSesion);
        return ResponseEntity.ok(updatedSesion);
    }
     @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarSesion(@PathVariable int id) {
        validarExistencia(id);
        sesionService.deleteSesionById(id);
        String msg = "Respuesta Eliminada : " + id;
        return ResponseEntity.ok(msg);
    }

    private void validarExistencia(int id) {
        try {
            sesionService.findById(id);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }
}
