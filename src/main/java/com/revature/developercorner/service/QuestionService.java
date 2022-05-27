package com.revature.developercorner.service;

import com.revature.developercorner.data.QuestionRepository;
import com.revature.developercorner.data.UserRepository;
import com.revature.developercorner.entity.Question;
import com.revature.developercorner.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

// QuestionService Class
// This class will handle the business logic of the Question objects in the application.
@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    // AddQuestion method
    // This method will insert a new Question record in the database:
    public Question addQuestion(Question question){
        // Change created_at to reflect the current time:
        Timestamp currentTime = Timestamp.valueOf(LocalDateTime.now());
        question.setCreated_at(currentTime);
        question.setUpdated_at(null);
        questionRepository.save(question);
        return question;
    }

    // GetAllQuestions method
    // This method will retrieve a List object of Question objects from the database:
    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    // GetQuestionById method
    // This method will retrieve a Question object from the database with the supplied id and calling the
    //  QuestionRepository and supplying the id into the findById method:
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).get();
    }

    // UpdateQuestion method
    // This method will update a Question record in the database by the supplied id:
    public Question updateQuestion(Question question, Long id) {
        // Get the database Question object by querying with the supplied id through the QuestionRepository:
        Question questionDB = questionRepository.findById(id).get();

        // Set the database Question's attributes with the supplied Question object's attributes:
        questionDB.setUserId(question.getUserId());
        questionDB.setLanguage(question.getLanguage());
        questionDB.setQuestion(question.getQuestion());
        questionDB.setSuggestion(question.getSuggestion());

        // Change the updated_at to reflect the updated time:
        Timestamp currentTime = Timestamp.valueOf(LocalDateTime.now());
        questionDB.setUpdated_at(currentTime);

        // Call the QuestionRepository to update the record in the database:
        questionRepository.save(questionDB);
        return questionDB;
    }

    // DeleteQuestion method
    // This method will delete the specified record with the supplied id:
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}
