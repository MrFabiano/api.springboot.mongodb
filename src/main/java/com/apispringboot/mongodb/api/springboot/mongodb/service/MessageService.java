package com.apispringboot.mongodb.api.springboot.mongodb.service;

import com.apispringboot.mongodb.api.springboot.mongodb.domain.model.Message;
import com.apispringboot.mongodb.api.springboot.mongodb.domain.model.dto.MessageDTO;
import com.apispringboot.mongodb.api.springboot.mongodb.repository.UserMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private UserMessageRepository userMessageRepository;

    public List<Message> saveList(Message message) {
        Message message1 = userMessageRepository.save(message);
        return Collections.singletonList(message1);
    }

    public List<MessageDTO> createChannel(Message message, String channel, String code, String service){
        List<MessageDTO> byChannel = userMessageRepository.findByChannel(Collections.singleton(channel), code, service);
        if(byChannel != null && byChannel.isEmpty()){
            userMessageRepository.save(message);
        }else{
            userMessageRepository.findByChannel(Collections.singleton(channel), code, service);
        }
        return byChannel;
    }
}
