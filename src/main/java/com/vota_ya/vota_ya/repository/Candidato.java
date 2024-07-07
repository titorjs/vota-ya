package com.vota_ya.vota_ya.repository;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "candidato")
public class Candidato {
    @Id
    private String Id;
    private String partido;
    private String nombreCandidato;
    private int votos;

    public void addVote(){
        votos++;
    }
}
