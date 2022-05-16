package com.revature.developercorner.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

//Lombok annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    private String language;
    private String question;
    private Timestamp created_at;
    private Timestamp updated_at;

    //Constructor without ID:
    public Question(Long user_id, String language, String question, Timestamp created_at, Timestamp updated_at) {
        this.user_id = user_id;
        this.language = language;
        this.question = question;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
