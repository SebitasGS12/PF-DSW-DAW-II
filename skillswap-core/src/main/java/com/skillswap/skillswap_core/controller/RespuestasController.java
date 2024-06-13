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
import com.skillswap.skillswap_core.entity.Respuestas;
import com.skillswap.skillswap_core.exceptions.ResourceNotFoundException;
import com.skillswap.skillswap_core.service.RespuestasService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Estandares.API + "Respuestas")
@RequiredArgsConstructor
@CrossOrigin(Estandares.CROSS)
public class RespuestasController {
       private final RespuestasService respuestasService;
      @GetMapping
    public ResponseEntity<List<Respuestas>> listarRespuesta() {
        return ResponseEntity.ok(respuestasService.findAll());
    }
     @GetMapping("/{id}")
    public ResponseEntity<Respuestas> buscarRespuesta(@PathVariable int id) {
        try {
            Respuestas respuestas = respuestasService.findById(id);
            return ResponseEntity.ok(respuestas);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }
     @PostMapping
    public ResponseEntity<Respuestas> guardarRespuestas(@RequestBody Respuestas respuestas) {
        Respuestas nuevoRespuestas = respuestasService.saveRespuestas(respuestas);
        return new ResponseEntity<>(nuevoRespuestas, HttpStatus.CREATED);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<Respuestas> actualizarRespuestas(@PathVariable int id, @RequestBody Respuestas newRespuestas) {
        validarExistencia(id);
        newRespuestas.setRespuestasId(id);
        Respuestas updatedRespuestas = respuestasService.saveRespuestas(newRespuestas);
        return ResponseEntity.ok(updatedRespuestas);
    }
     @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarRespuestas(@PathVariable int id) {
        validarExistencia(id);
        respuestasService.delteRespuestasById(id);
        String msg = "Respuesta Eliminada : " + id;
        return ResponseEntity.ok(msg);
    }

    private void validarExistencia(int id) {
        try {
            respuestasService.findById(id);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }
}
