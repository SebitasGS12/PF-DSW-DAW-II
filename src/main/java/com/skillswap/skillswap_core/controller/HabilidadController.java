package com.skillswap.skillswap_core.controller;

import com.skillswap.skillswap_core.constants.Estandares;
import com.skillswap.skillswap_core.entity.CategoriaHabilidad;
import com.skillswap.skillswap_core.entity.Habilidad;
import com.skillswap.skillswap_core.exceptions.ResourceNotFoundException;
import com.skillswap.skillswap_core.service.HabilidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(Estandares.API + "Habilidad")
@RequiredArgsConstructor
@CrossOrigin(Estandares.CROSS)
public class HabilidadController {

    private final HabilidadService service;

    @GetMapping
    public ResponseEntity<List<Habilidad>> listar() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habilidad> buscar(@PathVariable int id) {
        try {
            Habilidad habilidad = service.findById(id);
            return ResponseEntity.ok(habilidad);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<Habilidad>> buscarPorCategoriaId(@PathVariable int id) {
        try {
            List<Habilidad> habilidad = service.findByCategoriaHabilidadId(id);
            return ResponseEntity.ok(habilidad);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Habilidades con id : " + id);
        }
    }


    @PostMapping
    public ResponseEntity<Habilidad> guardar(@RequestBody Habilidad habilidad) {
        Habilidad nuevo = service.saveHabilidad(habilidad);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habilidad> actualizar(@PathVariable int id, @RequestBody Habilidad habilidad) {
        validarExistencia(id);
        habilidad.setHabilidadId(id);
        Habilidad update = service.saveHabilidad(habilidad);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        validarExistencia(id);
        service.delteHabilidadById(id);
        String msg = "Habilidad Eliminada : " + id;
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
