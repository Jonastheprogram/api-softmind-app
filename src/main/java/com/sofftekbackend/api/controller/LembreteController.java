package com.sofftekbackend.api.controller;

import com.sofftekbackend.api.model.Lembrete;
import com.sofftekbackend.api.repository.LembreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/lembretes")
public class LembreteController {

    @Autowired
    private LembreteRepository lembreteRepository;

    @GetMapping
    public List<Lembrete> listarTodos() {
        return lembreteRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Lembrete> criarLembrete(@RequestBody Lembrete lembrete) {
        Lembrete novoLembrete = lembreteRepository.save(lembrete);
        return new ResponseEntity<>(novoLembrete, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLembrete(@PathVariable String id) {
        if (!lembreteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        lembreteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}