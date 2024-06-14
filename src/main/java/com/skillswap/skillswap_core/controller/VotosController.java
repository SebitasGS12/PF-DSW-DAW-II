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
import com.skillswap.skillswap_core.entity.Votos;
import com.skillswap.skillswap_core.exceptions.ResourceNotFoundException;
import com.skillswap.skillswap_core.service.VotosService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Estandares.API + "Votos")
@RequiredArgsConstructor
@CrossOrigin(Estandares.CROSS)
public class VotosController {
     private final VotosService votosService;
     @GetMapping
    public ResponseEntity<List<Votos>> listarVotos() {
        return ResponseEntity.ok(votosService.findAll());
    }
     @GetMapping("/{id}")
    public ResponseEntity<Votos> buscarVotos(@PathVariable int id) {
        try {
            Votos votos = votosService.findById(id);
            return ResponseEntity.ok(votos);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }
     @PostMapping
    public ResponseEntity<Votos> guardarVotos(@RequestBody Votos votos) {
        Votos nuevoVotos = votosService.saveVotos(votos);
        return new ResponseEntity<>(nuevoVotos, HttpStatus.CREATED);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<Votos> actualizarVotos(@PathVariable int id, @RequestBody Votos newVotos) {
        validarExistencia(id);
        newVotos.setVotoId(id);
        Votos updatedVotos = votosService.saveVotos(newVotos);
        return ResponseEntity.ok(updatedVotos);
    }
     @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarVotos(@PathVariable int id) {
        validarExistencia(id);
        votosService.delteVotosById(id);
        String msg = "Voto Eliminado : " + id;
        return ResponseEntity.ok(msg);
    }

    private void validarExistencia(int id) {
        try {
            votosService.findById(id);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }
}
