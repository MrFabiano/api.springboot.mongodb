package com.apispringboot.mongodb.api.springboot.mongodb.controller;

import com.apispringboot.mongodb.api.springboot.mongodb.domain.model.Message;
import com.apispringboot.mongodb.api.springboot.mongodb.domain.model.dto.MessageDTO;
import com.apispringboot.mongodb.api.springboot.mongodb.repository.UserMessageRepository;
import com.apispringboot.mongodb.api.springboot.mongodb.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user_message/v1")
public class MessageController {

    @Autowired
    private final UserMessageRepository userMessageRepository;

    @Autowired
    private MessageService messageService;

    public MessageController(UserMessageRepository userMessageRepository) {
        this.userMessageRepository = userMessageRepository;
    }


    @PostMapping("/message")
    public ResponseEntity<List<Message>> saveMessage(@RequestBody Message message){
        try{
            return new ResponseEntity<>(messageService.saveList(message), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/message")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<MessageDTO>> createMessage(Message message,
                                                          @RequestParam(value = "channel", required = false) String channel,
                                                          @RequestParam(value = "code", required = false) String code,
                                                          @RequestParam(value = "service", required = false) String service){

        try{
            return new ResponseEntity<>(messageService.createChannel(message, channel, code, service),
                    HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(messageService.createChannel(message, channel, code, service),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
