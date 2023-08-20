import java.util.Date;

class Tarefa {
    private String nome;
    private String descricao;
    private Date dataTermino;
    private int nivelPrioridade;
    private String categoria;
    private StatusTodo status;

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

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
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

    public StatusTodo getStatus() {
        return status;
    }

    public void setStatus(StatusTodo status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tarefa{" + "nome='" + nome + '\'' + ", descricao='" + descricao + '\'' + ", dataTermino='" + dataTermino + '\'' + ", nivelPrioridade=" + nivelPrioridade + ", categoria='" + categoria + '\'' + ", status='" + status + '\'' + '}';
    }
}




