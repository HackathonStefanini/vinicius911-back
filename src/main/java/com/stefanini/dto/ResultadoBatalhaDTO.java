package com.stefanini.dto;

import java.util.List;

public class ResultadoBatalhaDTO {

    public String vencedor;
    public List<StefamonDTO> stefamonsRestantes;

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    public List<StefamonDTO> getStefamonsRestantes() {
        return stefamonsRestantes;
    }

    public void setStefamonsRestantes(List<StefamonDTO> stefamonsRestantes) {
        this.stefamonsRestantes = stefamonsRestantes;
    }
}
