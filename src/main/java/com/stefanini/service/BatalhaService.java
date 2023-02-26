package com.stefanini.service;

import com.stefanini.dto.ResultadoBatalhaDTO;
import com.stefanini.entity.Jogador;
import com.stefanini.entity.Stefamon;
import com.stefanini.parser.ResultadoBatalhaParser;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

@ApplicationScoped
public class BatalhaService {

    @Inject
    private JogadorService jogadorService;

    public ResultadoBatalhaDTO batalhar(Jogador jogador1 , Jogador jogador2) {

        int numeroStefamonJogador1 = 0;
        int numeroStefamonJogador2 = 0;


        while(isJogadorTemStefamonsVivos(jogador1) || isJogadorTemStefamonsVivos(jogador2)) {

            Stefamon stefamonAtual1 = jogador1.getStefamons().get(numeroStefamonJogador1);

            Stefamon stefamonAtual2 = jogador2.getStefamons().get(numeroStefamonJogador2);

            if (stefamonAtual1.isStefamonVivo()) {
                stefamonAtual1.ataque(stefamonAtual2);
                System.out.println(stefamonAtual1.getNome() + " ATACOU O " + stefamonAtual2.getNome());
                System.out.println("VIDA " + stefamonAtual1.getNome() + " : " + stefamonAtual1.getVida());
                System.out.println("VIDA " + stefamonAtual2.getNome() + " : " + stefamonAtual2.getVida());

            } else {
                numeroStefamonJogador1++;
                try {
                    if (jogador1.getStefamons().get(numeroStefamonJogador1) != null) {
                        stefamonAtual1 = jogador1.getStefamons().get(numeroStefamonJogador1);
                    } else {
                        System.out.println("Jogador 1 não possui mais stefamons vivos");
                    }
                } catch (Exception e) {
                    System.out.println("JOGADOR 2 VENCEU!");
                    jogador2.setSaldo(jogador2.getSaldo().add(jogador1.getSaldo().multiply(new BigDecimal(10).divide(new BigDecimal(100)))));
                    return ResultadoBatalhaParser.entityToDTO(jogador2);
                }

            }

            if (stefamonAtual2.isStefamonVivo()) {
                stefamonAtual2.ataque(stefamonAtual1);
                System.out.println(stefamonAtual2.getNome() + " ATACOU O " + stefamonAtual1.getNome());
                System.out.println("VIDA " + stefamonAtual1.getNome() + " : " + stefamonAtual1.getVida());
                System.out.println("VIDA " + stefamonAtual2.getNome() + " : " + stefamonAtual2.getVida());
            } else {
                numeroStefamonJogador2++;
                try {
                    if (jogador2.getStefamons().get(numeroStefamonJogador2) != null) {
                        stefamonAtual2 = jogador1.getStefamons().get(numeroStefamonJogador2);
                    } else {
                        System.out.println("Jogador 2 não possui mais stefamons vivos");
                    }
                } catch (Exception e) {
                    System.out.println("JOGADOR 1 VENCEU!");
                    jogador1.setSaldo(jogador1.getSaldo().add(jogador2.getSaldo().multiply(new BigDecimal(10).divide(new BigDecimal(100)))));
                    return ResultadoBatalhaParser.entityToDTO(jogador1);
                }

            }
        }
        return null;
    }

    private boolean isJogadorTemStefamonsVivos(Jogador jogador) {
        return jogador.getStefamons().stream().anyMatch(stefamon -> stefamon.getVida() > 0);
    }

}
