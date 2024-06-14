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
import com.skillswap.skillswap_core.entity.Notificaciones;
import com.skillswap.skillswap_core.exceptions.ResourceNotFoundException;
import com.skillswap.skillswap_core.service.NotificacionesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Estandares.API + "Notificaciones")
@RequiredArgsConstructor
@CrossOrigin(Estandares.CROSS)
public class NotificacionesController {
     private final NotificacionesService notificacionesService;
      @GetMapping
    public ResponseEntity<List<Notificaciones>> listarNotificaciones() {
        return ResponseEntity.ok(notificacionesService.findAll());
    }
     @GetMapping("/{id}")
    public ResponseEntity<Notificaciones> buscarNotificaciones(@PathVariable int id) {
        try {
            Notificaciones notificaciones = notificacionesService.findById(id);
            return ResponseEntity.ok(notificaciones);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }
     @PostMapping
    public ResponseEntity<Notificaciones> guardarNotificaciones(@RequestBody Notificaciones notificaciones) {
        Notificaciones nuevoNotificaciones = notificacionesService.saveNotificaciones(notificaciones);
        return new ResponseEntity<>(nuevoNotificaciones, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Notificaciones> actualizarNotificaciones(@PathVariable int id, @RequestBody Notificaciones newNotificaciones) {
        validarExistencia(id);
        newNotificaciones.setNotificacionesId(id);
        Notificaciones updatedNotificaciones = notificacionesService.saveNotificaciones(newNotificaciones);
        return ResponseEntity.ok(updatedNotificaciones);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarNotificaciones(@PathVariable int id) {
        validarExistencia(id);
        notificacionesService.delteNotificacionesById(id);
        String msg = "Notificacion Eliminada : " + id;
        return ResponseEntity.ok(msg);
    }

    private void validarExistencia(int id) {
        try {
            notificacionesService.findById(id);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }
}