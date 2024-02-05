public void checkAlarme() {
    for (Tarefa tarefa : lista) {
        if (tarefa.getAlarme().getDataHora().equals(LocalDate.now())) {
            System.out.println("Essa tarefa tem um alarme agendado para hoje.");
            System.out.println(tarefa.getNome());
            System.out.println(tarefa.getAlarme().getDescricao());
            System.out.println(tarefa.getAlarme().getDataHora());
        }

        System.out.println("Configurar alarme? (S/N)");
        var configurarAlarme = entrada.nextLine();

        if (configurarAlarme.equalsIgnoreCase("S")) {
            criarAlarme(tarefa);
        }

        System.out.println(tarefa);
        lista.add(tarefa);

        return tarefa;
    }

    public void criarAlarme (Tarefa tarefa){
        Alarme alarme = new Alarme();
        Scanner entrada = new Scanner(System.in);

        System.out.println("Descrição do alarme");
        var descricao = entrada.nextLine();
        alarme.setDescricao(descricao);

        System.out.println("Informe a antecedência do alarme em horas:");
        var antecedencia = entrada.nextInt();
        alarme.setDataHora(tarefa.getDataTermino().minusHours(antecedencia));

        tarefa.setAlarme(alarme);
    }
    public void checkAlarme () {
        for (Tarefa tarefa : lista) {
            if (tarefa.getAlarme() != null && tarefa.getAlarme().getDataHora().isAfter(LocalDate.now())) {
                System.out.println("Essa tarefa tem um alarme agendado para hoje.");
                System.out.println(tarefa.getNome());
                System.out.println(tarefa.getAlarme().getDescricao());
                System.out.println(tarefa.getAlarme().getDataHora());
            }
        }
    }
}