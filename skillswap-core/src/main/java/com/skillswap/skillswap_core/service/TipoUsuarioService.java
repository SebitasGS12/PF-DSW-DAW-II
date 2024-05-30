package com.skillswap.skillswap_core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillswap.skillswap_core.entity.TipoUsuario;
import com.skillswap.skillswap_core.repository.ITipoUsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipoUsuarioService {
                 private final ITipoUsuarioRepository retiusu;

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

    public void saveTipoUsuario(TipoUsuario tipoUsuario) {
        if (tipoUsuario.getTipoUsuarioID() == null ){
            tipoUsuario.setTipoUsuarioID(ultimoId());
        }
        retiusu.save(tipoUsuario);
    }
    public void delteTipoUsuarioById(Integer id) {
        retiusu.deleteById(id);
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
