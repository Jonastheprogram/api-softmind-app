package com.sofftekbackend.api.controller;

import com.sofftekbackend.api.model.RegDiarioHumor;
import com.sofftekbackend.api.repository.RegDiarioHumorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/registros")
public class RegDiarioHumorController {

    @Autowired
    private RegDiarioHumorRepository registroRepository;

    @PostMapping
    public ResponseEntity<RegDiarioHumor> criarRegistro(@RequestBody RegDiarioHumor registro) {
        registro.setDataRegistro(LocalDateTime.now());
        RegDiarioHumor novoRegistro = registroRepository.save(registro);

        return new ResponseEntity<>(novoRegistro, HttpStatus.CREATED);
    }

    @GetMapping
    public List<RegDiarioHumor> listarTodosRegistros() {
        return registroRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegDiarioHumor> buscarRegistroPorId(@PathVariable String id) {
        return registroRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRegistro(@PathVariable String id) {
        if (!registroRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        registroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}