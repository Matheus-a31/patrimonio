package com.desafio.nerds.patrimonio.controller;

import com.desafio.nerds.patrimonio.dto.EquipamentoDTO;
import com.desafio.nerds.patrimonio.model.Equipamento;
import com.desafio.nerds.patrimonio.service.EquipamentoService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipamentos")
public class EquipamentoController {

    private final EquipamentoService service;

    public EquipamentoController(EquipamentoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Equipamento> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipamento> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Equipamento>> buscarPorTipo(@PathVariable String tipo) {
    List<Equipamento> equipamentos = service.buscarPorTipo(tipo);
    return ResponseEntity.ok(equipamentos);
}

    @GetMapping("/serial/{numeroSerie}")
    public ResponseEntity<Equipamento> buscarPorNumeroSerie(@PathVariable String numeroSerie) {
        return ResponseEntity.ok(service.buscarPorNumeroSerie(numeroSerie));
    }

    @PostMapping("/")
    public ResponseEntity<Equipamento> criar(@RequestBody @Valid EquipamentoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipamento> atualizar(@PathVariable Long id, @RequestBody @Valid EquipamentoDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}