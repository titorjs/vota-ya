package com.vota_ya.vota_ya.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "voto")
public class Voto {
    @Id
    private String id;
    private String student;
}
