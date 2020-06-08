package com.makefriend.makefriend.service;

import com.makefriend.makefriend.dto.AddTrait;
import com.makefriend.makefriend.model.Trait;
import com.makefriend.makefriend.repository.TraitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraitService {

    private final TraitRepository traitRepository;

    public TraitService(TraitRepository traitRepository) {
        this.traitRepository = traitRepository;
    }

    public Trait findOne(Long id){
        return traitRepository.findById(id).get();
    }
    public List<Trait> findAll(){
        return traitRepository.findAll();
    }
    public Trait findByName(String name){
        return traitRepository.findByName(name);
    }
    public List<Trait> addTrait(AddTrait addTrait){
        Trait t = new Trait(addTrait.getName());
        traitRepository.save(t);
        return findAll();
    }
    public List<Trait> delete(Long id){
        traitRepository.deleteById(id);
        return findAll();
    }
}
