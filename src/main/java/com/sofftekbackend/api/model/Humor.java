package com.sofftekbackend.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "humores")
public class Humor {

    @Id
    private String id;
    private String sentimento;
    private LocalDateTime dataCheckin;
}