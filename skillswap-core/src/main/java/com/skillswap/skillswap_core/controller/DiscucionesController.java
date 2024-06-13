package com.skillswap.skillswap_core.controller;

import com.skillswap.skillswap_core.constants.Estandares;
import com.skillswap.skillswap_core.entity.CategoriaHabilidad;
import com.skillswap.skillswap_core.entity.Discusiones;
import com.skillswap.skillswap_core.exceptions.ResourceNotFoundException;
import com.skillswap.skillswap_core.service.DiscusionesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(Estandares.API + "Discusiones")
@RequiredArgsConstructor
@CrossOrigin(Estandares.CROSS)
public class DiscucionesController {

    private final DiscusionesService service;

    @GetMapping
    public ResponseEntity<List<Discusiones>> listar() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Discusiones> buscar(@PathVariable int id) {
        try {
            Discusiones discusiones = service.findById(id);
            return ResponseEntity.ok(discusiones);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }

    @PostMapping
    public ResponseEntity<Discusiones> guardar(@RequestBody Discusiones discusiones) {
        Discusiones nuevo = service.saveDiscusiones(discusiones);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Discusiones> actualizar(@PathVariable int id, @RequestBody Discusiones discusiones) {
        validarExistencia(id);
        discusiones.setDiscusionesId(id);
        Discusiones update = service.saveDiscusiones(discusiones);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        validarExistencia(id);
        service.delteDiscusionesById(id);
        String msg = "Discusiones Eliminada : " + id;
        return ResponseEntity.ok(msg);
    }

    private void validarExistencia(int id) {
        try {
            service.findById(id);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }
}
