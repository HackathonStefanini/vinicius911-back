package com.stefanini.service;


import com.stefanini.dto.SucessoLoginDTO;
import com.stefanini.entity.Jogador;
import com.stefanini.exceptions.RegraDeNegocioException;
import com.stefanini.parser.SucessoLoginDTOParser;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.Base64;

@ApplicationScoped
public class LoginService {

    @Inject
    private JogadorService jogadorService;

    public SucessoLoginDTO logar(String username, String password) {
        Jogador jogador = jogadorService.getJogadorByUsername(username);

        if (jogador != null) {
            if (jogador.getPassword().equals(Base64.getEncoder().encodeToString(password.getBytes()))) {
                return SucessoLoginDTOParser.entityToDto(jogador);
            }
        }

        throw new RegraDeNegocioException("Usuário ou senha inválidos", Response.Status.BAD_REQUEST);


    }
 }
