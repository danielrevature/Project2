package com.revature.developercorner.service;

import com.revature.developercorner.data.UserRepository;
import com.revature.developercorner.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getById(User user, Long id){
        return userRepository.findById(id).get();

    }

    public User getByUserId(User user, Long id){
        return userRepository.findById(id).get();
    }
    public User addUser(User user){
        userRepository.save(user);
        return (user);
    }
    public void update_user(User user, Long id) {
        User userDB = userRepository.findById(id).get();
        userDB.setUsername(user.getUsername());
        userDB.setPassword(user.getPassword());
        userDB.setEMail(user.getEMail());
        userRepository.save(userDB);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
