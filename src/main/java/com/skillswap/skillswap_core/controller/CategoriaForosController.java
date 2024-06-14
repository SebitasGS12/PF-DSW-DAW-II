package com.skillswap.skillswap_core.controller;

import com.skillswap.skillswap_core.constants.Estandares;
import com.skillswap.skillswap_core.entity.CategoriaForos;
import com.skillswap.skillswap_core.exceptions.ResourceNotFoundException;
import com.skillswap.skillswap_core.service.CategoriaForosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(Estandares.API + "CategoriaForos")
@RequiredArgsConstructor
@CrossOrigin(Estandares.CROSS)
public class CategoriaForosController {

    private final CategoriaForosService service;

    @GetMapping
    public ResponseEntity<List<CategoriaForos>> listar() {
        return ResponseEntity.ok(service.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaForos> buscar(@PathVariable int id) {
        try {
            CategoriaForos categoriaForos = service.findById(id);
            return ResponseEntity.ok(categoriaForos);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }

    @PostMapping
    public ResponseEntity<CategoriaForos> guardar(@RequestBody CategoriaForos categoriaForos) {
        CategoriaForos nuevo = service.saveCategoriasForos(categoriaForos);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaForos> actualizar(@PathVariable int id, @RequestBody CategoriaForos categoriaForos) {
        validarExistencia(id);
        categoriaForos.setCategoriaId(id);
        CategoriaForos update = service.saveCategoriasForos(categoriaForos);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        validarExistencia(id);
        service.delteCategoriaForos(id);
        String msg = "CategoriaForo Eliminada : " + id;
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
