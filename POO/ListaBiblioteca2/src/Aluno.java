public class Aluno {

    String nome;
    int prioridade;
    String matricula;    // Atributos da classe

    public Aluno(String nome, String matricula, int prioridade) {
        this.nome = nome;
        this.matricula = matricula;
        this.prioridade = prioridade;  //construtor
    }

    public String getNome() {
        return nome;  // getter do nome
    }

    public String getMatricula() {
        return matricula; // getter da matricula
    }

    public int getPrioridade() {
        return prioridade; // getter da prioridade
    }

    public void setNome(String nome) {
        this.nome = nome;  // setter do nome
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula; // setter da matricula
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade; // setter da prioridade
    }

    @Override
    public String toString() {
        return nome + " - " + matricula + " -- Prioridade: " + prioridade;
    } // ''converte'' os dados para uma forma que o java possa ler melhor e mostrar como string( senão tiver sai aquele @jdpajdaj)
}