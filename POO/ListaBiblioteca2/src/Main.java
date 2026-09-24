public class Main {

    public static void main(String[] args) {

        FilaAtendimento fila = new FilaAtendimento();

        Aluno ana = new Aluno("Ana", "001", 1);
        Aluno bruno = new Aluno("Bruno", "002", 2);
        Aluno carlos = new Aluno("Carlos", "003", 1);

        System.out.println("=== ADICIONANDO ALUNOS ===");

        fila.adicionarAlunoNoFim(ana);
        fila.adicionarAlunoNoFim(bruno);
        fila.adicionarAlunoNoInicio(carlos);

        System.out.println("\n=== FILA ===");
        fila.listarAlunos();

        System.out.println("\nQuantidade: "
                + fila.quantidadeAlunos());

        System.out.println("\n=== BUSCA ===");
        fila.buscarAluno("002");

        System.out.println("\n=== ATENDIMENTO ===");
        fila.atenderProximo();

        System.out.println("\n=== FILA APÓS ATENDIMENTO ===");
        fila.listarAlunos();

        System.out.println("\n=== REMOÇÃO ===");
        fila.removerAluno("002");

        System.out.println("\n=== FILA FINAL ===");
        fila.listarAlunos();

        System.out.println("\nQuantidade final: "
                + fila.quantidadeAlunos());
    }
}