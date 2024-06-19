package com.skillswap.skillswap_core.negocio;

import com.skillswap.skillswap_core.constants.Estandares;
import com.skillswap.skillswap_core.entity.Usuario;
import com.skillswap.skillswap_core.repository.IPerfilRepository;
import com.skillswap.skillswap_core.service.PerfilService;
import com.skillswap.skillswap_core.service.SesionService;
import com.skillswap.skillswap_core.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.event.MenuEvent;

@RestController
@RequestMapping(Estandares.API + "Negocio")
@RequiredArgsConstructor
@CrossOrigin(Estandares.CROSS)
public class WebController {

    private PerfilService servicePerfil;
    private UsuarioService usuarioService;
    private SesionService serviceSesion;


    @PostMapping(value= Estandares.PATH_REGISTRO)
    public ResponseEntity<Usuario> registrarNuevaCuenta(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.saveUsuario(usuario);
        servicePerfil.crearPeril(nuevoUsuario);
        return  ResponseEntity.ok(nuevoUsuario);
    }

    @PostMapping
        public ResponseEntity<Usuario> inciarSesion(@RequestBody Usuario usuario) {
            if ( usuarioService.findById())


            return new ResponseEntity<>(nuevoUsuario, HttpStatus.ACCEPTED);
        }

    @PostMapping
    public ResponseEntity<Usuario> cerrarSesion(@RequestBody Usuario usuario) {



        return new ResponseEntity<>(nuevoUsuario, HttpStatus.ACCEPTED);
    }



}
