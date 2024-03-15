import java.util.ArrayList;

public class TareService {
    private ArrayList<Tarefa> listaTarefas = new ArrayList<Tarefa>();

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

    public Tarefa getTarefaPorNome(String nome) {
        for (Tarefa tarefa : listaTarefas) {
            if (tarefa.getNome().equals(nome)) {
                return tarefa;
            }
        }
        return null;
    }
}