package com.skillswap.skillswap_core.controller;

import com.skillswap.skillswap_core.constants.Estandares;
import com.skillswap.skillswap_core.entity.CategoriaHabilidad;
import com.skillswap.skillswap_core.entity.Imagen;
import com.skillswap.skillswap_core.exceptions.ResourceNotFoundException;
import com.skillswap.skillswap_core.service.ImagenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(Estandares.API + "Imagen")
@RequiredArgsConstructor
@CrossOrigin(Estandares.CROSS)
public class ImagenController {

    private final ImagenService service;

    @GetMapping
    public ResponseEntity<List<Imagen>> listar() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imagen> buscar(@PathVariable int id) {
        try {
            Imagen imagen = service.findById(id);
            return ResponseEntity.ok(imagen);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }

    @PostMapping
    public ResponseEntity<Imagen> guardar(@RequestBody Imagen imagen) {
        Imagen nuevo = service.saveImagen(imagen);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imagen> actualizar(@PathVariable int id, @RequestBody Imagen imagen) {
        validarExistencia(id);
        imagen.setImagenID(id);
        Imagen update = service.saveImagen(imagen);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        validarExistencia(id);
        service.delteImagenById(id);
        String msg = "Imagen Eliminada : " + id;
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
