package com.revature.developercorner.service;


import com.revature.developercorner.data.UserRepository;
import com.revature.developercorner.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //connection to the userrepository
    @Autowired
    UserRepository userRepository;

    public void add_user(User user){
        UserRepository.save(user);
    }





}
