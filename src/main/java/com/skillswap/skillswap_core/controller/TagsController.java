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
import com.skillswap.skillswap_core.entity.Tags;
import com.skillswap.skillswap_core.exceptions.ResourceNotFoundException;
import com.skillswap.skillswap_core.service.TagsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Estandares.API + "Tags")
@RequiredArgsConstructor
@CrossOrigin(Estandares.CROSS)
public class TagsController {
    private final TagsService tagsService;
     @GetMapping
    public ResponseEntity<List<Tags>> listarTags() {
        return ResponseEntity.ok(tagsService.findAll());
    }
     @GetMapping("/{id}")
    public ResponseEntity<Tags> buscarTags(@PathVariable int id) {
        try {
            Tags tags = tagsService.findById(id);
            return ResponseEntity.ok(tags);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }
     @PostMapping
    public ResponseEntity<Tags> guardarTags(@RequestBody Tags tags) {
        Tags nuevoTags = tagsService.saveTags(tags);
        return new ResponseEntity<>(nuevoTags, HttpStatus.CREATED);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<Tags> actualizarTags(@PathVariable int id, @RequestBody Tags newTags) {
        validarExistencia(id);
        newTags.setTagId(id);
        Tags updatedTags = tagsService.saveTags(newTags);
        return ResponseEntity.ok(updatedTags);
    }
     @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTags(@PathVariable int id) {
        validarExistencia(id);
        tagsService.delteTagsById(id);
        String msg = "Respuesta Eliminada : " + id;
        return ResponseEntity.ok(msg);
    }

    private void validarExistencia(int id) {
        try {
            tagsService.findById(id);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objeto con id : " + id);
        }
    }
}
