package com.skillswap.skillswap_core.controller;

import com.skillswap.skillswap_core.constants.Estandares;
import com.skillswap.skillswap_core.entity.CategoriaForos;
import com.skillswap.skillswap_core.entity.CategoriaHabilidad;
import com.skillswap.skillswap_core.exceptions.ResourceNotFoundException;
import com.skillswap.skillswap_core.service.CategoriaHabilidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(Estandares.API + "CategoriaHabilidad")
@RequiredArgsConstructor
@CrossOrigin(Estandares.CROSS)
public class CategoriaHabilidadController {

    private final CategoriaHabilidadService service;

    @GetMapping
    public ResponseEntity<List<CategoriaHabilidad>> listar() {
        return ResponseEntity.ok(service.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaHabilidad> buscar(@PathVariable int id) {
        try {
            CategoriaHabilidad categoriaHabilidad = service.findById(id);
            return ResponseEntity.ok(categoriaHabilidad);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }

    @PostMapping
    public ResponseEntity<CategoriaHabilidad> guardar(@RequestBody CategoriaHabilidad categoriaHabilidad) {
        CategoriaHabilidad nuevo = service.saveCategoriaHabilidad(categoriaHabilidad);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaHabilidad> actualizar(@PathVariable int id, @RequestBody CategoriaHabilidad categoriaHabilidad) {
        validarExistencia(id);
        categoriaHabilidad.setCategoriaHabilidadId(id);
        CategoriaHabilidad update = service.saveCategoriaHabilidad(categoriaHabilidad);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        validarExistencia(id);
        service.delteCategoriaHabilidadById(id);
        String msg = "CategoriaHabilidad Eliminada : " + id;
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
