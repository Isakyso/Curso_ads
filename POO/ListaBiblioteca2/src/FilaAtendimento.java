public class FilaAtendimento {

    private ListaEncadeadaBiblioteca fila;

    public FilaAtendimento() {
        fila = new ListaEncadeadaBiblioteca();
    }

    public void adicionarAlunoNoFim(Aluno aluno) {
        fila.insertEnd(aluno); // chama o metodo insertEnd
    }

    public void adicionarAlunoNoInicio(Aluno aluno) {
        fila.insertFirst(aluno); // chama o metodo insertFirst
    }

    public void atenderProximo() {

        if (fila.isEmpty()) {
            System.out.println("Não há alunos na fila.");
            return;
        }

        Aluno aluno = fila.getFirst();

        System.out.println("Atendendo: " + aluno);

        fila.removeFirst();
    }

    public void removerAluno(String matricula) {

        if (fila.remove(matricula)) {
            System.out.println("Aluno removido com sucesso.");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }  // remove o aluno da lista se o mesmo estiver presente na lista

    public void buscarAluno(String matricula) {

        Aluno aluno = fila.search(matricula);

        if (aluno != null) {
            System.out.println("Aluno encontrado:");
            System.out.println(aluno);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    } // pecorre a lista a partir do head atual buscando pelo aluno solicitado

    public void listarAlunos() {
        fila.print();
    }

    public int quantidadeAlunos() {
        return fila.size();
    }
}