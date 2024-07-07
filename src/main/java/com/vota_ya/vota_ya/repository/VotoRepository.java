package com.vota_ya.vota_ya.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VotoRepository extends MongoRepository<Voto, String> {
    Voto findByStudent(String student);
}
