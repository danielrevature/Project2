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

public class TechStack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String stack;

    //Constructor without ID:
    public TechStack(String stack) {
        this.stack = stack;
    }
}
