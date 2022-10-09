package com.apispringboot.mongodb.api.springboot.mongodb.domain.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {

    private String channel;
    private String code;
    private String service;

}
