package com.sofftekbackend.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "lembretes")
public class Lembrete {
    @Id
    private String id;
    private String hora;
    private String descricao;
}