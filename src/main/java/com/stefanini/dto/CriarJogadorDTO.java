package com.stefanini.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public class CriarJogadorDTO {

    @NotEmpty
    private String username;

    @Size(min = 4, max = 10)
    private String senha;
    private List<StefamonDTO> stefamons;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<StefamonDTO> getStefamons() {
        return stefamons;
    }

    public void setStefamons(List<StefamonDTO> stefamons) {
        this.stefamons = stefamons;
    }
}
