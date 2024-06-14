package com.skillswap.skillswap_core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillswap.skillswap_core.entity.Usuario;
import com.skillswap.skillswap_core.repository.IUsuarioRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final IUsuarioRepository repo;

    public int ultimoId(){
        List<Usuario> lista = repo.findAll();
        if (lista.size() == 0 ) {
            return 1;
        }
        return lista.get(lista.size()-1).getUsuarioId()+1 ;
    }

    public List<Usuario> findAll(){
        return repo.findAll();
    }

    public Usuario findById(int id){
        //Si lo encuentra devolvera el producto , sino generara una exception
        return  repo.findById(id).orElseThrow();
    }

    public Usuario saveUsuario(Usuario usuario) {
        if (usuario.getUsuarioId() == null ){
            usuario.setUsuarioId(ultimoId());
        }
        return repo.save(usuario);
    }

    public void delteUsuarioById(Integer id) {
        repo.deleteById(id);
    }

    public Usuario nullUsuario() {
        Usuario usuario = new Usuario();
        usuario.setUsuarioId(null);
        return usuario;
    }
    public Usuario newUsuario() {
        Usuario usuario = new Usuario();
        usuario.setUsuarioId(ultimoId());
        return usuario;
    }



}
