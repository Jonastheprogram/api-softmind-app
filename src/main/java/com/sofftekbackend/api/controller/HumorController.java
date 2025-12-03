package com.sofftekbackend.api.controller;

import com.sofftekbackend.api.model.Humor;
import com.sofftekbackend.api.model.HumorStat;
import com.sofftekbackend.api.repository.HumorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api/humores")
public class HumorController {

    @Autowired
    private HumorRepository humorRepository;

    @PostMapping
    public ResponseEntity<Humor> criarHumor(@RequestBody Humor humor) {
        humor.setDataCheckin(LocalDateTime.now());
        Humor novoHumor = humorRepository.save(humor);
        return new ResponseEntity<>(novoHumor, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Humor> listarTodosHumores() {
        return humorRepository.findAll();
    }

    @GetMapping("/stats")
    public List<HumorStat> getEstatisticasDeHumor() {
        return humorRepository.contarSentimentos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Humor> buscarHumorPorId(@PathVariable String id) {
        Optional<Humor> humor = humorRepository.findById(id);
        return humor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarHumor(@PathVariable String id) {
        if (!humorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        humorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}