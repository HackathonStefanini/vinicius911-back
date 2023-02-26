package com.stefanini.parser;

import com.stefanini.dto.StefamonDTO;
import com.stefanini.entity.Stefamon;

public class StefamonParser {

    public static Stefamon dtotoEntity(StefamonDTO dto) {
        Stefamon stefamon = new Stefamon();
        stefamon.setId(dto.getId());
        stefamon.setAtaque(dto.getAtaque());
        stefamon.setPoder(dto.getPoder());
        stefamon.setInteligencia(dto.getInteligencia());
        stefamon.setVelocidade(dto.getVelocidade());
        stefamon.setDefesa(dto.getDefesa());
        stefamon.setVida(dto.getVida());
        stefamon.setNome(dto.getNome());
        stefamon.setUrlFoto(dto.getUrlFoto());
        return stefamon;
    }

    public static StefamonDTO entityToDto(Stefamon entity) {
        StefamonDTO stefamonDto = new StefamonDTO();
        stefamonDto.setId(entity.getId());
        stefamonDto.setAtaque(entity.getAtaque());
        stefamonDto.setPoder(entity.getPoder());
        stefamonDto.setInteligencia(entity.getInteligencia());
        stefamonDto.setVelocidade(entity.getVelocidade());
        stefamonDto.setDefesa(entity.getDefesa());
        stefamonDto.setVida(entity.getVida());
        stefamonDto.setNome(entity.getNome());
        stefamonDto.setUrlFoto(entity.getUrlFoto());
        return stefamonDto;
    }

}
