package com.skillswap.skillswap_core.controller;

import com.skillswap.skillswap_core.constants.Estandares;
import com.skillswap.skillswap_core.entity.Amistades;
import com.skillswap.skillswap_core.exceptions.ResourceNotFoundException;
import com.skillswap.skillswap_core.service.AmistadesService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
