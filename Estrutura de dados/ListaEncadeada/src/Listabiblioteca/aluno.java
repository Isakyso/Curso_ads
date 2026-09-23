public class Aluno{

	String nome;
	String matricula;
	int prioridade;

}

public Aluno(String nome, String matricula, int prioridade) {
	this.nome = nome;
	this.matricula = matricula;
	this.prioridade = prioridade;
}

public String getNome() {
	return nome;
}

public String getMatricula() {
	return matricula;
}

public int getPrioridade() {
	return prioridade;
}

public void setNome( String nome) {
	this.nome = nome;
}

public void setMatricula(String matricula) {
	this.matricula = matricula;
}

public void   setPrioridade( int prioridade) {
	this.prioridade = prioridade;
}

public String toString(){
	return nome + " - " + matricula + " -- Prioridade: " + prioridade;
}

void main() {

    Aluno aluno = new Aluno("Isakysom", "12345", 1);

    IO.println(aluno);
}
