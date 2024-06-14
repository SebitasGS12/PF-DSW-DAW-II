package com.skillswap.skillswap_core.service;

import java.util.List;
import java.util.Optional;

import com.skillswap.skillswap_core.entity.Usuario;
import com.skillswap.skillswap_core.repository.IUsuarioRepository;
import org.springframework.stereotype.Service;

import com.skillswap.skillswap_core.entity.TipoUsuario;
import com.skillswap.skillswap_core.repository.ITipoUsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipoUsuarioService {

    private final ITipoUsuarioRepository retiusu;
    private final IUsuarioRepository repoUsu;

    public int ultimoId(){
        List<TipoUsuario> lista = retiusu.findAll();
        if (lista.size() == 0 ) {
            return 1;
        }
        return lista.get(lista.size()-1).getTipoUsuarioID()+1 ;
    }

    public List<TipoUsuario> findAll(){
        return retiusu.findAll();
    }
    public TipoUsuario findById(int id){
        return  retiusu.findById(id).orElseThrow();
    }

    public TipoUsuario saveTipoUsuario(TipoUsuario tipoUsuario) {
        if (tipoUsuario.getTipoUsuarioID() == null ){
            tipoUsuario.setTipoUsuarioID(ultimoId());
        }
        return retiusu.save(tipoUsuario);
    }
    public void deleteTipoUsuarioById(Integer id) {
        Optional<TipoUsuario> optionalTipoUsuario = retiusu.findById(id);
        if (optionalTipoUsuario.isPresent()) {
            TipoUsuario tipoUsuario = optionalTipoUsuario.get();

            // Obtener usuarios asociados y desvincularlos
            List<Usuario> usuarios = tipoUsuario.getUsuarios();
            for (Usuario usuario : usuarios) {
                usuario.setObj_tipoUsuario(null);
                repoUsu.save(usuario);
            }

            // Ahora eliminar el tipoUsuario
            retiusu.deleteById(id);
        } else {
            throw new RuntimeException("TipoUsuario not found");
        }



    }
    public TipoUsuario nullTipoUsuario() {
        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setTipoUsuarioID(null);
        return tipoUsuario;
    }
    public TipoUsuario newTipoUsuario() {
        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setTipoUsuarioID(ultimoId());
        return tipoUsuario;
    }
}
