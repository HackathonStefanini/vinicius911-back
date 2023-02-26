package com.stefanini.service;

import com.stefanini.dto.CriarJogadorDTO;
import com.stefanini.dto.StefamonDTO;
import com.stefanini.entity.Jogador;
import com.stefanini.entity.Stefamon;
import com.stefanini.exceptions.RegraDeNegocioException;
import com.stefanini.parser.JogadorParser;
import com.stefanini.parser.StefamonParser;
import com.stefanini.repository.StefamonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class StefamonService {

    @Inject
    private StefamonRepository repository;

    public List<StefamonDTO> listarTodos(){
        return repository.listAll().stream().map(StefamonParser::entityToDto).collect(Collectors.toList());
    }

    public Stefamon pegarPorId(Long id) {
        var stefamon =  repository.findById(id);
        if(Objects.isNull(stefamon)) {
            throw new RegraDeNegocioException("Não encontramos nada com o id " + id, Response.Status.NOT_FOUND);
        }
        return stefamon;
    }

    public CriarJogadorDTO comprarStefamon(Jogador jogador, Stefamon stefamon) {
        BigDecimal saldoAtualJogador = jogador.getSaldo();
        StefamonDTO stefamonDTO = StefamonParser.entityToDto(stefamon);
        BigDecimal precoStefamon = stefamonDTO.getPreco();

        if (saldoAtualJogador.compareTo(precoStefamon) >= 0) {
            jogador.getStefamons().add(stefamon);
            return JogadorParser.entityToDto(jogador);
        }

        throw new RegraDeNegocioException("Você não tem saldo suficiente para comprar este stefamon", Response.Status.BAD_REQUEST);

    }

 }
