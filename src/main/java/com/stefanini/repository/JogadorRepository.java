package com.stefanini.repository;

import com.stefanini.dao.GenericDAO;
import com.stefanini.entity.Jogador;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class JogadorRepository extends GenericDAO<Jogador, Long> {

    public Jogador getUserByUsername(String username) {
        return createQuery("SELECT j FROM Jogador j WHERE j.nickname = :nickname")
                .setParameter("nickname", username)
                .getSingleResult();
    }
}
