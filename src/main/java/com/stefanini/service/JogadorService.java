package com.stefanini.service;

import com.stefanini.dto.CriarJogadorDTO;
import com.stefanini.entity.Jogador;
import com.stefanini.entity.Stefamon;
import com.stefanini.exceptions.RegraDeNegocioException;
import com.stefanini.parser.JogadorParser;
import com.stefanini.parser.StefamonParser;
import com.stefanini.repository.JogadorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.core.Response;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class JogadorService {

    @Inject
    private JogadorRepository jogadorRepository;

    @Inject
    private StefamonService stefamonService;

    public void salvar(@Valid CriarJogadorDTO dto) {
        Jogador jogador = JogadorParser.dtoToEntity(dto);
        jogador.setPassword(encriptSenha(jogador.getPassword()));
        jogadorRepository.save(jogador);
    }

    public Jogador pegarPorId(Long id) {
        var jogador = jogadorRepository.findById(id);
        if(Objects.isNull(jogador)) {
            throw new RegraDeNegocioException("Ocorreu um erro ao buscar o Jogador de id " + id, Response.Status.NOT_FOUND);
        }
        return jogador;
    }

    public Jogador getJogadorByUsername(String username) {
        return jogadorRepository.getUserByUsername(username);
    }

    public void alterar(CriarJogadorDTO dto, Long id) {
        Jogador jogador = JogadorParser.dtoToEntity(dto);
        jogador.setId(id);
        jogador.setPassword(encriptSenha(jogador.getPassword()));
        jogadorRepository.update(jogador);
    }

    public void deletar(Long id) {
        jogadorRepository.delete(id);
    }

    public List<Jogador> listarTodos() {
        return jogadorRepository.listAll();
    }

    private String encriptSenha(String senha) {
        return Base64.getEncoder().encodeToString(senha.getBytes());
    }

    public Jogador gerarBot() {
        Jogador jogador = new Jogador();
        List<Stefamon> stefamons = stefamonService.listarTodos().stream().map(StefamonParser::dtotoEntity).collect(Collectors.toList());
        int size = stefamons.size();

        while(jogador.getStefamons().size() < 6) {
            int v = (int) Math.random() * (size - 0) + 0;
            if (!jogador.getStefamons().contains(stefamons.get(v))) {
                jogador.getStefamons().add(stefamons.get(v));
            }
        }

        return jogador;
    }
}
