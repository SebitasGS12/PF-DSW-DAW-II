package com.skillswap.skillswap_core.controller;

import com.skillswap.skillswap_core.constants.Estandares;
import com.skillswap.skillswap_core.entity.Amistades;
import com.skillswap.skillswap_core.exceptions.ResourceNotFoundException;
import com.skillswap.skillswap_core.service.AmistadesService;
import com.skillswap.skillswap_core.transacciones.Logger;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(Estandares.API + "Amistades")
@RequiredArgsConstructor
public class AmistadesController {

    private final AmistadesService amistadesService;
    Logger log = Logger.getLogger(AmistadesController.class);

    @GetMapping
    public List<Amistades> listarAmistades() {
        log.info("Amistad Listado ");
        return amistadesService.findAll();
    }
    
    @GetMapping("/{id}")
    public Amistades buscarAmistad(@PathVariable int id) {
        log.info("Amistad Busqueda "+id);
        try {
            return amistadesService.findById(id);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objecto con id : "+ id);
        }
    }
    

    @PostMapping
    public Amistades guardarAmistad(@RequestBody Amistades amistad) {
        log.transaccion("Amistad Guardada "+amistad.getAmistadID());
        return amistadesService.saveAmistades(amistad);
    }
    @PutMapping("/{id}")
    public Amistades actualizarAmistad(@PathVariable int id,@RequestBody Amistades newAmistad){
        log.transaccion("Amistad Actualizada " + id);
        validarExistencia(id);
        newAmistad.setAmistadID(id);
        return amistadesService.saveAmistades(newAmistad);
    }

    @DeleteMapping("/{id}")
    public String eliminarAmistad(@PathVariable int id){
        log.transaccion("Amistad Eliminada " + id);

        validarExistencia(id);
        amistadesService.delteAmistadesById(id);
        String msg = "Amistad Eliminada : "+id;
        return msg;
    }

    private void validarExistencia(int id) {
        try {
            log.info("Se buscó una Amistad con id : "+id);   
            amistadesService.findById(id);
        }catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Objecto con id : "+ id);
        }
    }


}
