package com.apispringboot.mongodb.api.springboot.mongodb.repository;

import com.apispringboot.mongodb.api.springboot.mongodb.domain.model.Message;
import com.apispringboot.mongodb.api.springboot.mongodb.domain.model.dto.MessageDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserMessageRepository extends MongoRepository<Message, String> {

    @Query("{channel: { $in: ?0 } }")
    List<MessageDTO> findByChannel(Iterable<String> channel, String code, String service);
}
