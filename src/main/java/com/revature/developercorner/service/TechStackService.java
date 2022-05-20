package com.revature.developercorner.service;

import com.revature.developercorner.data.TechStackRepository;
import com.revature.developercorner.entity.TechStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechStackService {

    @Autowired
    TechStackRepository techStackRepository;

    public void addTechStack(TechStack techStack){
        techStackRepository.save(techStack);
    }
    public List<TechStack> getAll(){
        return techStackRepository.findAll();
    }

    public TechStack getById(TechStack techStack, Long id){
        techStackRepository.findById(id).get();
        return techStack;
    }

    public void updateTechStack(TechStack techStack, Long id){
        TechStack techStackDB = techStackRepository.findById(id).get();
        techStackDB.setStack(techStack.getStack());

        techStackRepository.save(techStackDB);
    }

    public void delete(Long id){
        techStackRepository.deleteById(id);
    }
}

