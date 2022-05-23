package com.revature.developercorner.service;


import com.revature.developercorner.data.QuestionRepository;
import com.revature.developercorner.data.UserRepository;
import com.revature.developercorner.entity.Question;
import com.revature.developercorner.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public Question add_Question(Question question){
        questionRepository.save(question);
        return question;
    }

    public List<Question> get_All_Questions(){
        return questionRepository.findAll();
    }


    public List<Question> get_question_custom(String flag) {
        switch(flag){
            case "new":
                return questionRepository.findByDate();
            case "old":
                return questionRepository.findByDate();
            default:
                return get_All_Questions();
        }
    }


    public Question get_question_by_id(Long id) {
        return questionRepository.findById(id).get();
    }

    public Question update_question(Question question, Long id) {
        Question questionDB = questionRepository.findById(id).get();
        questionDB.setQuestion(question.getQuestion());
        questionDB.setTime(question.getTime());
        questionDB.setAuthor(question.getAuthor());
        questionRepository.save(questionDB);
        return questionDB;
    }

    public void delete_question(Long id) {
        questionRepository.deleteById(id);
    }
}
