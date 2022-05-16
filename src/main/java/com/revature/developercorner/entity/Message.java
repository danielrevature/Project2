package com.revature.developercorner.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Lombok annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private Long sender;
    private Long recipient;

    //Constructor without ID:
    public Message(String message, Long sender, Long recipient) {
        this.message = message;
        this.sender = sender;
        this.recipient = recipient;
    }
}
