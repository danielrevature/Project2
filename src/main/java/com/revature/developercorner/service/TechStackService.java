package com.revature.developercorner.service;

import com.revature.developercorner.entity.TechStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechStackService {
  
    @Autowired
    TechStackRepository techStackRepository;

    public TechStack add_Tech_Stack(TechStack techStack){
        techStackRepository.save(techStack);
        return techStack;
    }

    public List<TechStack> get_All_TechStacks(){
        return techStackRepository.findAll();
    }


    public List<TechStack> get_custom_techStack(String flag) {
        return TechStackRepository.getByName();

    }

    public TechStack update_library(TechStack techStack, Long id) {
        TechStack techStackDB = techStackRepository.findById(id).get();
        techStackDB.setTechStack(techStack.getTechStack());
        TechStackRepository.save(techStackDB);
        return techStackDB;
    }

    public void delete_techStack(Long id) {
        techStackRepository.deleteById(id);
    }
}

