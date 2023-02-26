package com.stefanini.dto;

import java.math.BigDecimal;

public class StefamonDTO {

    private Long id;
    private String nome;
    private Integer vida;
    private Integer ataque;
    private Integer defesa;
    private Integer inteligencia;

    private BigDecimal preco;
    private Integer poder;
    private Integer velocidade;
    private String urlFoto;

    public StefamonDTO() {
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getPreco() {
        Double mediaAtributos = (double) ((this.ataque + this.defesa + this.vida + this.poder + this.inteligencia + this.velocidade) / 6);
        this.preco = new BigDecimal(mediaAtributos);
        return this.preco;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public void setDefesa(Integer defesa) {
        this.defesa = defesa;
    }

    public Integer getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(Integer inteligencia) {
        this.inteligencia = inteligencia;
    }

    public Integer getPoder() {
        return poder;
    }

    public void setPoder(Integer poder) {
        this.poder = poder;
    }

    public Integer getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Integer velocidade) {
        this.velocidade = velocidade;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
