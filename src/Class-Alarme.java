import java.time.LocalDate;

 class Alarme {
    private String descricao;
    private boolean ativo;
    private LocalDate dataHora;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Alarme alarme = (Alarme) obj;
        return descricao.equals(alarme.descricao) && dataHora.equals(alarme.dataHora);
    }

    @Override
    public int hashCode() {
        int result = descricao.hashCode();
        result = 31 * result + dataHora.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Alarme{" +
                "descricao='" + descricao + '\'' +
                ", ativo=" + ativo +
                ", dataHora=" + dataHora +
                '}';
    }
}
