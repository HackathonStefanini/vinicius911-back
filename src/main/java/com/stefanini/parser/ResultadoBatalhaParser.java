package com.stefanini.parser;

import com.stefanini.dto.ResultadoBatalhaDTO;
import com.stefanini.entity.Jogador;

import java.util.stream.Collectors;

public class ResultadoBatalhaParser {

    public static ResultadoBatalhaDTO entityToDTO(Jogador jogador) {
        ResultadoBatalhaDTO resultadoBatalhaDTO = new ResultadoBatalhaDTO();
        resultadoBatalhaDTO.setVencedor(jogador.getNickname());
        resultadoBatalhaDTO.setStefamonsRestantes(jogador.getStefamons().stream().filter(s -> s.getVida() > 0).map(StefamonParser::entityToDto).collect(Collectors.toList()));
        return resultadoBatalhaDTO;
    }
}
