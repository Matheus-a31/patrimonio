package com.desafio.nerds.patrimonio.service;


import com.desafio.nerds.patrimonio.dto.EquipamentoDTO;
import com.desafio.nerds.patrimonio.exception.*;
import com.desafio.nerds.patrimonio.model.Equipamento;
import com.desafio.nerds.patrimonio.repository.EquipamentoRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoService {

    private final EquipamentoRepository repository;

    public EquipamentoService(EquipamentoRepository repository) {
        this.repository = repository;
    }

    public List<Equipamento> listarTodos() {
        return repository.findAll();
    }

    public Equipamento buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Equipamento não encontrado"));
    }

    public Equipamento buscarPorNumeroSerie(String numeroSerie) {
        return repository.findByNumeroSerie(numeroSerie)
                .orElseThrow(() -> new NaoEncontradoException("Equipamento não encontrado com serial: " + numeroSerie));
    }

    public List<Equipamento> buscarPorTipo(String tipo) {
        List<Equipamento> lista = repository.findByTipo(tipo);
        
        if (lista.isEmpty()) {
            throw new NaoEncontradoException("Nenhum equipamento encontrado com o tipo: " + tipo);
        }
        
        return lista;
    }
    

    public Equipamento salvar(EquipamentoDTO dto) {
        if (repository.existsByNumeroSerie(dto.numeroSerie())) {
            throw new RegraNegocioException("Já existe um equipamento com este número de série.");
        }

        Equipamento equipamento = new Equipamento();
        BeanUtils.copyProperties(dto, equipamento);
        return repository.save(equipamento);
    }

    public Equipamento atualizar(Long id, EquipamentoDTO dto) {
        Equipamento equipamentoExistente = buscarPorId(id);

        var equipamentoComMesmoSerial = repository.findByNumeroSerie(dto.numeroSerie());
        if (equipamentoComMesmoSerial.isPresent() && !equipamentoComMesmoSerial.get().getId().equals(id)) {
            throw new RegraNegocioException("Número de série já cadastrado em outro equipamento.");
        }

        BeanUtils.copyProperties(dto, equipamentoExistente, "id");
        return repository.save(equipamentoExistente);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new NaoEncontradoException("Equipamento não encontrado para exclusão");
        }
        repository.deleteById(id);
    }
}
