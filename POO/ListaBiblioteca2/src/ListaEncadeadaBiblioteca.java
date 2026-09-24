public class ListaEncadeadaBiblioteca {

    private node head;
    private int size;

    public ListaEncadeadaBiblioteca() {
        head = null; // head começa nulo pois a lista esta vazia
        size = 0;  // tamnho da fila
    }

    public boolean isEmpty() {
        return head == null; // mostra se a lista esta vazia
    }

    public int size() {
        return size;  // mostra o tamanho da lista
    }

    public void insertFirst(Aluno aluno) {

        node novo = new node(aluno);

        novo.proximo = head;
        head = novo; // faz o novo nó se tornar o head atual

        size++; // aumenta o tamanho
    }

    public void insertEnd(Aluno aluno) {

        node novo = new node(aluno);

        if (head == null) {
            head = novo; // transforma o nó criado no atual head da lista
            size++;
            return;
        }

        node atual = head;

        while (atual.proximo != null) { // essa condiçao faz o while parar antes que proximo no seja nulo
            atual = atual.proximo;
        }

        atual.proximo = novo; // transforma o proximo Nó no Nó atual
        size++;
    }

    public void removeFirst() {

        if (head == null) {
            return;
        }  // condiçao de segurança quaso a lista esteja vazia

        head = head.proximo;
        size--;  // desconecta o Nó atual da lista "Isolando-o"
    }

    public void removeEnd() {

        if (head == null) {
            return; // condiçao de segurança quaso a lista esteja vazia
        }

        if (head.proximo == null) {
            head = null;
            size--;
            return;
        }

        node atual = head;

        while (atual.proximo.proximo != null) {
            atual = atual.proximo;
        }

        atual.proximo = null;
        size--; // diminui o tamanho
    }

    public void print() {

        node atual = head;

        while (atual != null) {

            System.out.println(atual.aluno);

            atual = atual.proximo;   // apenas mostra os Nós registrados na lista
        }
    }

    public Aluno getFirst() {

        if (head == null) {
            return null; // condiçao de segurança quaso a lista esteja vazia
        }

        return head.aluno;
    }

    public Aluno search(String matricula) {

        node atual = head;

        while (atual != null) {

            if (atual.aluno.getMatricula().equals(matricula)) { // executa o getmatricula e se a matricula registrada no Nó atual for igual
                return atual.aluno; // retorna as informaçoes do aluno
            }

            atual = atual.proximo;
        }

        return null;
    }

    public boolean contains(String matricula) {

        node atual = head;

        while (atual != null) {

            if (atual.aluno.getMatricula().equals(matricula)) {
                return true;
            }

            atual = atual.proximo;
        }

        return false;
    }  // confere se a matricula desejada esta presente na lista

    public boolean remove(String matricula) {

        if (head == null) {
            return false;
        }

        if (head.aluno.getMatricula().equals(matricula)) {
            head = head.proximo; // faz o nó apos o head se transformar no head atual
            size--; // diminui o tamanho
            return true;
        }

        node atual = head;

        while (atual.proximo != null) {

            if (atual.proximo.aluno.getMatricula().equals(matricula)) {

                atual.proximo = atual.proximo.proximo;
                size--;

                return true;
            }   // procura pela matricula registrada na classe aluno enquanto a lista nao for nula

            atual = atual.proximo;
        }

        return false;
    }
}