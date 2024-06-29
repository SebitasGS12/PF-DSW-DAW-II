package com.skillswap.skillswap_core.negocio;

import com.skillswap.skillswap_core.constants.Estandares;
import com.skillswap.skillswap_core.entity.Usuario;
import com.skillswap.skillswap_core.service.PerfilService;
import com.skillswap.skillswap_core.service.SesionService;
import com.skillswap.skillswap_core.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Estandares.API + "Negocio")
@RequiredArgsConstructor
@CrossOrigin(Estandares.CROSS)
public class WebController {

    private final PerfilService servicePerfil;
    private final UsuarioService usuarioService;
    private final SesionService serviceSesion;

    @PostMapping(value= Estandares.PATH_REGISTRO)
    public ResponseEntity<Usuario> registrarNuevaCuenta(@RequestBody Usuario usuario) {
        try {
            Usuario nuevoUsuario = usuarioService.saveUsuario(usuario);
            servicePerfil.crearPeril(nuevoUsuario);
            return ResponseEntity.ok(nuevoUsuario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping(value= Estandares.PATH_INICIAR_SESION)
    public ResponseEntity<Usuario> inciarSesion(@RequestBody Usuario usuario) {
        Usuario usuarioEncontrado = usuarioService.findByUserAndPass(usuario.getCorreo(), usuario.getContrasenia());
        if (usuarioEncontrado != null) {
            serviceSesion.openSesion(usuarioEncontrado);
            System.out.println( usuario.toString());
            return ResponseEntity.ok(usuarioEncontrado);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PostMapping(value = Estandares.PATH_CERRAR_SESION)
    public ResponseEntity<Usuario> cerrarSesion(@RequestBody Usuario usuario) {
        try {
            serviceSesion.closeSesion();
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
