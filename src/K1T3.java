import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class K1T3 {

    static ArrayList<Tarefa> lista = new ArrayList<Tarefa>();


    public static void main(String[] args) {
        escolherOpcoes();
    }

    public static void escolherOpcoes() {
        System.out.println("Selecione uma ação.");
        System.out.println("Opção 1 - Criar");
        System.out.println("Opção 2 - Ler");
        System.out.println("Opção 3 - Deletar");
        System.out.println("Opção 4 - finalizar\n");


        Scanner entrada = new Scanner(System.in);
        String opcaoSelecionada = entrada.nextLine();
        System.out.println(opcaoSelecionada);

        if (opcaoSelecionada.equals("1")) {
            Tarefa tarefa = criarTarefa();
            lista.add(tarefa);
        } else if (opcaoSelecionada.equals("2")) {
            for (Tarefa tarefa : lista) {
                System.out.println(tarefa);
            }
        } else if (opcaoSelecionada.equals("4")) {
            return;
        }


        escolherOpcoes();

    }

    public static Tarefa criarTarefa() {

        Tarefa k1t3 = new Tarefa();
        Scanner entrada = new Scanner(System.in);

        System.out.println("Nome da tarefa");
        var nome = entrada.nextLine();
        k1t3.setNome(nome);

        System.out.println("descrição da tarefa");
        var descricao = entrada.nextLine();
        k1t3.setDescricao(descricao);

        System.out.println("Informe o nivel de prioridade de 1 á 5");
        var prioridade = entrada.nextLine();
        k1t3.setNivelPrioridade(Integer.parseInt(prioridade));

        System.out.println("Informe a categoria - importante ou Urgente?");
        var categoria = entrada.nextLine();
        k1t3.setCategoria(categoria);

        System.out.println("Informe a data de termino(dd/MM/YYYY)");
        var dataTermino = entrada.nextLine();
        k1t3.setDataTermino(dataTermino);

        System.out.println("1 - Todo");
        System.out.println("2 - Doing");
        System.out.println("3 - Done");

        var status = entrada.nextLine();

        if (status.equals("1")) {
            k1t3.setStatus(StatusTodo.TODO);
        } else if (status.equals("2")) {
            k1t3.setStatus(StatusTodo.DOING);
        } else if (status.equals("3")) {
            k1t3.setStatus(StatusTodo.DONE);
        }
        System.out.println(k1t3);

        return k1t3;


    }
}







