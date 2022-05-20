package com.revature.developercorner.service;

import com.revature.developercorner.data.QuestionRepository;
import com.revature.developercorner.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public void addQuestion(Question question){
        questionRepository.save(question);
    }
    public List<Question> getAll(){
        return questionRepository.findAll();
    }

    public Question getById(Question question, Long id){
        questionRepository.findById(id).get();
        return question;
    }

    public void updateQuestion(Question question, Long id){
        Question questionDB = questionRepository.findById(id).get();
        questionDB.setQuestion(question.getQuestion());
        questionDB.setLanguage(question.getLanguage());
        questionDB.setCreated_at(question.getCreated_at());
        questionDB.setUpdated_at(question.getUpdated_at());
        questionRepository.save(questionDB);
    }

    public void delete(Long id){
        questionRepository.deleteById(id);
    }
}
