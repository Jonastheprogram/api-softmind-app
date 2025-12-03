package com.sofftekbackend.api.repository;

import com.sofftekbackend.api.model.Lembrete;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LembreteRepository extends MongoRepository<Lembrete, String> {
}