package com.sofftekbackend.api.repository;

import com.sofftekbackend.api.model.RegDiarioHumor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegDiarioHumorRepository extends MongoRepository<RegDiarioHumor, String> {
}