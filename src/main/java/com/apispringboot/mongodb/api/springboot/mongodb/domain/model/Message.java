package com.apispringboot.mongodb.api.springboot.mongodb.domain.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "message-user")
public class Message {

    @Id
    private String id;
    @SerializedName("channel")
    private String channel;
    @SerializedName("code")
    private String code;
    @SerializedName("service")
    private String service;
    @SerializedName("codeFront")
    private String codeFront;
    @SerializedName("detailFront")
    private String detailFront;

    public Message(String id, String channel, String code, String service, String codeFront, String detailFront) {
        this.id = id;
        this.channel = channel;
        this.code = code;
        this.service = service;
        this.codeFront = codeFront;
        this.detailFront = detailFront;
    }
}
