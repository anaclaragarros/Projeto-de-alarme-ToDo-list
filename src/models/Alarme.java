package models;

import java.time.LocalDate;

public class Alarme {

    private LocalDate dataHora;
    private String descricao;

    private Boolean ativo;


    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Alarme{" +
                "dataHora=" + dataHora +
                ", descricao='" + descricao + '\'' +
                ", ativo=" + ativo +
                '}';
    }
}
