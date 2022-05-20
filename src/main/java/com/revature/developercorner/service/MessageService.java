package com.revature.developercorner.service;

import com.revature.developercorner.data.MessageRepository;
import com.revature.developercorner.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public Message addMessage(Message message){
        messageRepository.save(message);
        return message;
    }
    public List<Message> getAll(){
        return messageRepository.findAll();
    }

    public Message getById(Message message, Long id){
        messageRepository.findById(id).get();
        return message;
    }

    public void update(Message message, Long id){
        Message messageDB = messageRepository.findById(id).get();
        messageDB.setMessage(message.getMessage());
        messageDB.setSender(message.getSender());
        messageDB.setRecipient(message.getRecipient());
        messageRepository.save(messageDB);
    }

    public void delete(Long id){
        messageRepository.deleteById(id);
    }

}
