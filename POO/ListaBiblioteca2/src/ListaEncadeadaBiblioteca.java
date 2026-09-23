public class ListaEncadeadaBiblioteca {

    node head;// head guarda o primeiro nó da lista por isso que tem que ser node
    int tamanho; // cria o tamanho da lista


    public ListaEncadeadaBiblioteca() {
        this.head = null;
        this.tamanho = 0; // apenas define que a lista começa no tamanho 0
    }

    public void InserirNoInicio(Aluno aluno) {
        node newNode = new node(aluno);

        newNode.proximo = head;
        head = newNode;  // faz primeiro com que o proximo do novo nó aponte para o Head atual e em seguida ''atualiza'' o novo nó tornando-o o novo head
        tamanho++; // atualiza o tamanho da lista
    }

    public void InserirNoFinal(Aluno aluno) {
        node newNode2 = new node(aluno); // cria o novo nó
        node nodeatual = this.head; // transforma o node atual no this head

        if (this.head == null) {  // executa apenas se o nó apontar para o ''nulo''
            this.head = newNode2; // atualiza o head para o novo nó
            tamanho++; // aumenta o tamanho
            return;
        } else {
            while (nodeatual.proximo != null) { // essa condição faz o while parar antes que o proximo elemento ser nulo
                nodeatual = nodeatual.proximo; // faz a variavel ''nodeatual'' avançar
            }
        }
        nodeatual.proximo = newNode2; // Conecta o proximo do no atual com newNode2
        tamanho++; // incrementa o tamanho
    }

    public void exibirLista() {
        node nodeatual = this.head; // transforma o node atual no this head
        while (nodeatual != null) { // exibe o nó atual enquanto existir um nó
            IO.println(nodeatual.aluno);
            nodeatual = nodeatual.proximo; // transforma o node atual no node que antes era o proximo dele
        }
    }

    public boolean estaVazia() {
        return head == null; // se o head for nulo ele apenas retorna a palavra ''nulo''
    }

    public int getTamanho() {
        return tamanho; // getter do tamanho
    }

    public void removerdoInicio() {
        if (estaVazia()) {
            return; //se a lista estiver vazia ele retorna nada
        }
        head = head.proximo; // faz com que o head aponte para o proximo meio que ignorando o primeiro nó da lista
        tamanho--;
    }

    public void removerdoFim() {
        node nodeatual = this.head; // transforma o node atual no this head

        if (estaVazia()) {
            return; // para o codigo caso a lista estiver vazia
        }

        if (head.proximo == null) { // parar o metodo para caso a lista so tenha 1 elemento
            head = null;
            tamanho--;
            return;
        }
        while (nodeatual.proximo.proximo != null) { // faz parar 1 nó antes(é meio complicado mesmo)
            nodeatual = nodeatual.proximo;// transforma o node atual no seu nó que vem após dele
        }

        nodeatual.proximo = null; // faz o proximo do no atual ficar nulo
        tamanho--; // diminui o tamanho
    }

    public Aluno BuscarAluno(String matricula) {
        node nodeatual = this.head;
        while (nodeatual != null) { // faz o codigo continuar até o atual ser nulo

            if (nodeatual.aluno.getMatricula().equals(matricula)) { // e o no atual for igual a matricula desejada ele para
                return nodeatual.aluno;
            }
            nodeatual = nodeatual.proximo;
        }
        return null;

    }
}
