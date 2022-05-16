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

public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Integer upVotes;
    private Integer downVotes;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Long user_id;

    //Constructor without ID:
    public Blog(String title, String content, Integer upVotes, Integer downVotes, Timestamp created_at, Timestamp updated_at, Long user_id) {
        this.title = title;
        this.content = content;
        this.upVotes = upVotes;
        this.downVotes = downVotes;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.user_id = user_id;
    }
}
