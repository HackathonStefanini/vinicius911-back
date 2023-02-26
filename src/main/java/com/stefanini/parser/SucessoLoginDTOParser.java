package com.stefanini.parser;

import com.stefanini.dto.SucessoLoginDTO;
import com.stefanini.entity.Jogador;

public class SucessoLoginDTOParser {

    public static SucessoLoginDTO entityToDto(Jogador jogador) {
        SucessoLoginDTO sucessoLoginDTO = new SucessoLoginDTO();
        sucessoLoginDTO.setMsg("Logado com sucesso!");
        sucessoLoginDTO.setUsername(jogador.getNickname());
        return sucessoLoginDTO;
    }
}
