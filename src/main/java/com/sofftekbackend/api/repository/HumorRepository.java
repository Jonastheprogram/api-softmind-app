package com.sofftekbackend.api.repository;

import com.sofftekbackend.api.model.HumorStat;
import org.springframework.data.mongodb.repository.Aggregation;
import java.util.List;
import com.sofftekbackend.api.model.Humor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumorRepository extends MongoRepository<Humor, String> {


    @Aggregation(pipeline = {
            "{ '$group': { '_id': '$sentimento', 'count': { '$sum': 1 } } }",
            "{ '$project': { 'sentimento': '$_id', 'count': 1, '_id': 0 } }"
    })
    List<HumorStat> contarSentimentos();
}

