package com.revature.developercorner.service;


import com.revature.developercorner.data.UserRepository;
import com.revature.developercorner.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    //connection to the userrepository
    @Autowired
    UserRepository userRepository;

    public void add_user(User user){
        // check to see if user already exist:
        Optional<User> user_By_Email = UserRepository.find_User_By_Email(user.getEMail());
        if(user_By_Email.isPresent()){
            throw new IllegalStateException("This Email is already in use!");
        }


        UserRepository.save(user);


    }



    public void user_LogIn(User user){
        // check to see if user already exist:
        Optional<User> user_By_Email = UserRepository.find_User_By_Email(user.getEMail());
        if(!user_By_Email.isPresent()){
            throw new IllegalStateException("The Email you used is not registered!");
        }




        UserRepository.save(user);


    }








}
