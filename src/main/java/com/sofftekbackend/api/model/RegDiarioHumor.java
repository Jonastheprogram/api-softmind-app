package com.sofftekbackend.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "registros_diarios")
public class RegDiarioHumor {

    @Id
    private String id;
    private String cargaTarefas;
    private String apoioEquipe;
    private String desabafo;
    private LocalDateTime dataRegistro;



}