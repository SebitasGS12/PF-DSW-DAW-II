package com.skillswap.skillswap_core.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.skillswap.skillswap_core.entity.Tags;
import com.skillswap.skillswap_core.repository.ITagsRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TagsService {
               private final ITagsRepository retags;

    public int ultimoId(){
        List<Tags> lista = retags.findAll();
        if (lista.size() == 0 ) {
            return 1;
        }
        return lista.get(lista.size()-1).getTagId()+1 ;
    }

    public List<Tags> findAll(){
        return retags.findAll();
    }
    public Tags findById(int id){
        return  retags.findById(id).orElseThrow();
    }

    public void saveTags(Tags tags) {
        if (tags.getTagId() == null ){
            tags.setTagId(ultimoId());
        }
        retags.save(tags);
    }
    public void delteTagsById(Integer id) {
        retags.deleteById(id);
    }
    public Tags nullTags() {
        Tags tags = new Tags();
        tags.setTagId(null);
        return tags;
    }
    public Tags newTags() {
        Tags tags = new Tags();
        tags.setTagId(ultimoId());
        return tags;
    }
}
