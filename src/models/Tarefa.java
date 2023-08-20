package models;

import java.time.LocalDate;

public class Tarefa {
    private String nome;
    private String descricao;
    private LocalDate dataTermino;
    private int nivelPrioridade;
    private String categoria;
    private StatusEnum status;

    private Alarme alarme;

    public Tarefa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public int getNivelPrioridade() {
        return nivelPrioridade;
    }

    public void setNivelPrioridade(int nivelPrioridade) {
        this.nivelPrioridade = nivelPrioridade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }


    public Alarme getAlarme() {
        return alarme;
    }

    public void setAlarme(Alarme alarme) {
        this.alarme = alarme;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataTermino=" + dataTermino +
                ", nivelPrioridade=" + nivelPrioridade +
                ", categoria='" + categoria + '\'' +
                ", status=" + status +
                ", alarme=" + alarme +
                '}';
    }
}




