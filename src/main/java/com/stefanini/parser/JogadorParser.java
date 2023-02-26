package com.stefanini.parser;

import com.stefanini.dto.CriarJogadorDTO;
import com.stefanini.entity.Jogador;

import java.util.stream.Collectors;

public class JogadorParser {

    public static Jogador dtoToEntity(CriarJogadorDTO dto) {
        Jogador jogador = new Jogador();
        jogador.setNickname(dto.getUsername());
        jogador.setStefamons(dto.getStefamons().stream().map(StefamonParser::dtotoEntity).collect(Collectors.toList()));
        jogador.setPassword(dto.getSenha());
        return jogador;
    }

    public static CriarJogadorDTO entityToDto(Jogador entity) {
        CriarJogadorDTO jogador = new CriarJogadorDTO();
        entity.setNickname(jogador.getUsername());
        entity.setStefamons(jogador.getStefamons().stream().map(StefamonParser::dtotoEntity).collect(Collectors.toList()));
        entity.setPassword(jogador.getSenha());
        return jogador;
    }

}
