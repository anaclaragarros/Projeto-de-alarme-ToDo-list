import java.util.ArrayList;

public class TarefaService {
    private List<Tarefa> listaTarefas = new ArrayList<>();

    public void criarTarefa(Tarefa tarefa) {
        listaTarefas.add(tarefa);
    }
    public void editarTarefa(Tarefa tarefa) {
        for (int i = 0; i < listaTarefas.size(); i++) {
            if (listaTarefas.get(i).equals(tarefa)) {
                listaTarefas.set(i, tarefa);
                break;
            }
        }
    }
    public void deletarTarefa(Tarefa tarefa) {
        listaTarefas.remove(tarefa);
    }

    public Tarefa getTarefaPorNome(String nome) {
        for (Tarefa tarefa : listaTarefas) {
            if (tarefa.getNome().equals(nome)) {
                return tarefa;
            }
        }
        return null;
    }
    public List<Tarefa> getListaTarefas() {
        return listaTarefas;
    }
    public List<Tarefa> filtrarPorCategoria(String categoria) {
        List<Tarefa> tarefasFiltradas = new ArrayList<>();
        for (Tarefa tarefa : listaTarefas) {
            if (tarefa.getCategoria().equals(categoria)) {
                tarefasFiltradas.add(tarefa);
            }
        }
        return tarefasFiltradas;
    }
}