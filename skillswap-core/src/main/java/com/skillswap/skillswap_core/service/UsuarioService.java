package com.skillswap.skillswap_core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skillswap.skillswap_core.entity.Usuarios;
import com.skillswap.skillswap_core.repository.IUsuarioRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final IUsuarioRepository repo;

    public int ultimoId(){
        List<Usuarios> lista = repo.findAll();
        if (lista.size() == 0 ) {
            return 1;
        }
        return lista.get(lista.size()-1).getUsuarioId()+1 ;
    }

    public List<Usuarios> findAll(){
        return repo.findAll();
    }

    public Usuarios findById(int id){
        //Si lo encuentra devolvera el producto , sino generara una exception
        return  repo.findById(id).orElseThrow();
    }

    public void saveUsuario(Usuarios usuario) {
        if (usuario.getUsuarioId() == null ){
            usuario.setUsuarioId(ultimoId());
        }
        repo.save(usuario);
    }

    public void delteUsuarioById(Integer id) {
        repo.deleteById(id);
    }

    public Usuarios nullUsuario() {
        Usuarios usuarios = new Usuarios();
        usuarios.setUsuarioId(null);
        return usuarios;
    }
    public Usuarios newUsuario() {
        Usuarios usuarios = new Usuarios();
        usuarios.setUsuarioId(ultimoId());
        return usuarios;
    }



}
