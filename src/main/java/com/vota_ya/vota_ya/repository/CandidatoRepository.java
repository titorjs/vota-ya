package com.vota_ya.vota_ya.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CandidatoRepository extends MongoRepository<Candidato, String> {
    Candidato findByPartido(String partido);
}
