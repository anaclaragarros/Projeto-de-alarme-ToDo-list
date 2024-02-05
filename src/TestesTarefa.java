class TarefaServiceTest {import java.util.ArrayList;
import java.util.List;

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

        // Outros métodos de leitura podem ser adicionados conforme necessário

        // Exemplo de método para filtrar tarefas por categoria
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


    @Test
    void editarTarefaDeveAtualizarInformacoesCorretamente() {
        // Given
        TarefaService tarefaService = new TarefaService();
        Tarefa tarefa = new Tarefa();
        tarefa.setNome("Tarefa Original");
        tarefa.setDataTermino(LocalDate.now());
        tarefa.setStatus(StatusEnum.TODO);
        tarefaService.criarTarefa(tarefa);


        tarefa.setNome("Tarefa Editada");
        tarefa.setDataTermino(LocalDate.now().plusDays(3));
//        tarefa.setStatus(StatusEnum.DONE);
        tarefaService.editarTarefa(tarefa);


        Tarefa tarefaEditada = tarefaService.getTarefaPorNome("Tarefa Editada");
        assertNotNull(tarefaEditada);
        assertEquals("Tarefa Editada", tarefaEditada.getNome());
        assertEquals(LocalDate.now().plusDays(3), tarefaEditada.getDataTermino());
        assertEquals(StatusEnum.DONE, tarefaEditada.getStatus());
    }
}