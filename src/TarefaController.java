import models.Alarme;
import models.FilterEnum;
import models.StatusEnum;
import models.Tarefa;

public class TarefaController {
     ArrayList<Tarefa> lista = new ArrayList<Tarefa>();
    public void init() {

        Tarefa tarefaDaAna = new Tarefa();
        tarefaDaAna.setNome("Tarefa agora");

        Alarme alarmeDaAna = new Alarme();
        alarmeDaAna.setDescricao("Agora");
        alarmeDaAna.setAtivo(true);
        alarmeDaAna.setDataHora(LocalDate.now());
        tarefaDaAna.setAlarme(alarmeDaAna);
        lista.add(tarefaDaAna);

        Tarefa tarefaClara = new Tarefa();
        tarefaClara.setNome("Tarefa ontem");

        Alarme alarmeClara = new Alarme();
        alarmeClara.setDescricao("Ontem");
        alarmeClara.setAtivo(true);
        alarmeClara.setDataHora(LocalDate.parse("2023-08-23"));
        tarefaClara.setAlarme(alarmeClara);
        lista.add(tarefaClara);

        checkAlarme();
        escolherOpcoes();
    }

    public void escolherOpcoes() {
        System.out.println("Selecione uma ação.");
        System.out.println("Opção 1 - Criar");
        System.out.println("Opção 2 - Ler");
        System.out.println("Opção 3 - Deletar");
        System.out.println("Opção 4 - finalizar\n");


        Scanner entrada = new Scanner(System.in);
        String opcaoSelecionada = entrada.nextLine();
        System.out.println(opcaoSelecionada);

        if (opcaoSelecionada.equals("1")) {
            criarTarefa();
        } else if (opcaoSelecionada.equals("2")) {
            lerTarefas();
        } else if (opcaoSelecionada.equals("3")) {
            deletarTarefa();
        } else if (opcaoSelecionada.equals("4")) {
            return;
        }

        escolherOpcoes();
    }

    public Tarefa criarTarefa() {

        Tarefa tarefa = new Tarefa();
        Scanner entrada = new Scanner(System.in);

        System.out.println("Nome da tarefa");
        var nome = entrada.nextLine();
        tarefa.setNome(nome);

        System.out.println("descrição da tarefa");
        var descricao = entrada.nextLine();
        tarefa.setDescricao(descricao);

        System.out.println("Informe o nivel de prioridade de 1 á 5");
        var prioridade = entrada.nextLine();
        tarefa.setNivelPrioridade(Integer.parseInt(prioridade));

        System.out.println("Informe a categoria:");
        var categoria = entrada.nextLine();
        tarefa.setCategoria(categoria);

        System.out.println("Informe a data de termino(YYYY-MM-DD)");
        var dataTermino = entrada.nextLine();
        tarefa.setDataTermino(LocalDate.parse(dataTermino));

        System.out.println("1 - Todo");
        System.out.println("2 - Doing");
        System.out.println("3 - Done");

        var status = entrada.nextLine();

        if (status.equals("1")) {
            tarefa.setStatus(StatusEnum.TODO);
        } else if (status.equals("2")) {
            tarefa.setStatus(StatusEnum.DOING);
        } else if (status.equals("3")) {
            tarefa.setStatus(StatusEnum.DONE);
        }
        System.out.println(tarefa);
        lista.add(tarefa);

        return tarefa;
    }
    public void deletarTarefa() {
        lerTarefas();
        System.out.println("Informe o id da tarefa que deseja deletar:");
        Scanner entrada = new Scanner(System.in);
        String id = entrada.nextLine();
        lista.remove(Integer.parseInt(id));
    }
    public void lerTarefas() {

        FilterEnum filtro = getFilter();

        if (filtro == FilterEnum.CATEGORIA) {
            filterByCategoria();
        } else if (filtro == FilterEnum.PRIORIDADE) {
            filterByPrioridade();
        } else if (filtro == FilterEnum.STATUS) {
            filterByStatus();
        } else {
            System.out.println(lista);
        }

    }
    public FilterEnum getFilter() {
        System.out.println("Deseja filtrar por:");
        System.out.println("1 - Categoria");
        System.out.println("2 - Prioridade");
        System.out.println("3 - Status");
        System.out.println("4 - Não filtrar");

        Scanner entrada = new Scanner(System.in);
        String filtro = entrada.nextLine();

        switch (filtro) {
            case "1" -> {
                return FilterEnum.CATEGORIA;
            }
            case "2" -> {
                return FilterEnum.PRIORIDADE;
            }
            case "3" -> {
                return FilterEnum.STATUS;
            }
        }
        return null;
    }
    public void filterByCategoria() {
        Set<String> categorias = new HashSet<String>();
        for (Tarefa tarefa : lista) {
            categorias.add(tarefa.getCategoria());
        }
        System.out.println("Categorias");
        System.out.println(categorias);

        System.out.println("Filtrar por qual categoria: ");
        Scanner entrada = new Scanner(System.in);
        String categoria = entrada.nextLine();

        ArrayList<Tarefa> listaFiltrada = new ArrayList<Tarefa>();

        listaFiltrada.addAll(lista.stream().filter(tarefa -> tarefa.getCategoria().equals(categoria)).toList());

        System.out.println(listaFiltrada);

    }
    public void filterByPrioridade() {
        System.out.println("Seleciona a prioridade(1~5): ");
        Scanner entrada = new Scanner(System.in);
        String prioridade = entrada.nextLine();

        ArrayList<Tarefa> listaFiltrada = new ArrayList<Tarefa>();

        listaFiltrada.addAll(lista.stream().filter(tarefa -> tarefa.getNivelPrioridade() == Integer.parseInt(prioridade)).toList());

        System.out.println(listaFiltrada);
    }
    public void filterByStatus() {
        System.out.println("Selecione o status: ");
        System.out.println("1 - TODO");
        System.out.println("2 - DOING");
        System.out.println("3 - DONE");
        Scanner entrada = new Scanner(System.in);
        String status = entrada.nextLine();

        StatusEnum statusFilter;

        if (status.equals("1")) {
            statusFilter = StatusEnum.TODO;
        } else if (status.equals("2")) {
            statusFilter = StatusEnum.DOING;
        } else if (status.equals("3")) {
            statusFilter = StatusEnum.DONE;
        } else {
            statusFilter = null;
        }

        ArrayList<Tarefa> listaFiltrada = new ArrayList<Tarefa>();

        if (statusFilter != null) {
            listaFiltrada.addAll(lista.stream().filter(tarefa -> tarefa.getStatus() == statusFilter).toList());
        }

        System.out.println(listaFiltrada);
    }
    public void checkAlarme() {
        for (Tarefa tarefa : lista) {
            if (tarefa.getAlarme().getDataHora().equals(LocalDate.now())) {
                System.out.println("Essa tarefa tem um alarme agendado para hoje.");
                System.out.println(tarefa.getNome());
                System.out.println(tarefa.getAlarme().getDescricao());
                System.out.println(tarefa.getAlarme().getDataHora());
            }
        }
    }
}