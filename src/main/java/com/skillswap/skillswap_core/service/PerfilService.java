package com.skillswap.skillswap_core.service;

import java.util.List;

import com.skillswap.skillswap_core.entity.Usuario;
import org.springframework.stereotype.Service;

import com.skillswap.skillswap_core.entity.Perfil;
import com.skillswap.skillswap_core.repository.IPerfilRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PerfilService {
    private final IPerfilRepository reper;

    public int ultimoId() {
        List<Perfil> lista = reper.findAll();
        if (lista.size() == 0) {
            return 1;
        }
        return lista.get(lista.size() - 1).getPerfilID() + 1;
    }

    public List<Perfil> findAll() {
        return reper.findAll();
    }

    public Perfil findById(int id) {
        return reper.findById(id).orElseThrow();
    }

    public Perfil savePerfil(Perfil perfil) {
        if (perfil.getPerfilID() == null) {
            perfil.setPerfilID(ultimoId());
        }
        return reper.save(perfil);
    }

    

    public void deltePerfilById(Integer id) {
        reper.deleteById(id);
    }

    public Perfil nullPerfil() {
        Perfil perfil = new Perfil();
        perfil.setPerfilID(null);
        return perfil;
    }

    public Perfil newPerfil() {
        Perfil perfil = new Perfil();
        perfil.setPerfilID(ultimoId());
        return perfil;
    }

    public Perfil findByUsuario(Usuario usuario) {
        return reper.findByUsuario(usuario);
    }

    public void crearPeril(Usuario usuario) {
        Perfil nuevoPerfil = newPerfil();
        nuevoPerfil.setUsuario(usuario);
        
        reper.save(nuevoPerfil);


    }

}
