public class node {
    Aluno aluno; // recebe a informaçao do objeto/classe aluno(conteudo do vagao)
    node proximo;  // irá receber o proximo para indicar pra onde a lista deve avançar

    public node(Aluno aluno){ // cria o nó para receber o conteudo de aluno
        this.aluno = aluno;
        this.proximo = null; // primeiro é nulo pois ainda não há para onde apontar
    }

}
