public class ListaEncadeada {

    private static class No {
        String Dado;
        No Proximo;

        public No(String Dado) {
            this.Dado = Dado;
            this.Proximo = null; //cria o nó
        }
    }

    private No Head;
    private int tamanho;

    public ListaEncadeada() {
        this.Head = null;
        this.tamanho = 0; //cria os dados da lista
    }

    public void InserirnoInicio(String Dado) {
        No No1 = new No(Dado);

        No1.Proximo = this.Head;
        this.Head = No1;
        this.tamanho++; // transforma a variavel ''proximo'' no novo head e incrementa o tamanho
    }

    public void InserirNoFim(String Dado) {
        No No2 = new No(Dado);
        No atual = this.Head;

        if (this.Head == null) {
            this.Head = No2;// atualiza o head e incrementa o tamanho
            this.tamanho++;
            return;
        } else {
            while (atual.Proximo != null) { // essa condiçao faz o while parar antes do elemento ser nulo
                atual = atual.Proximo; // faz a variavel ''atual'' avançar

            }
            atual.Proximo = No2;//conecta os 2 nós
            this.tamanho++; // incrementa o tamanho
        }
    }
    public void exibirLista() {
        No atual = this.Head;
        while(atual != null){ // essa condiçao exibe o atual mesmo que ele seja nulo
            IO.println(atual.Dado);
            atual = atual.Proximo;
        }
    }
    public int getTamanho(){
        return this.tamanho;
    }
    public boolean buscar(String Dado){
        No atual = this.Head;

        while(atual != null){
            if (atual.Dado.equals(Dado)){
                return true;
            }else {
                atual = atual.Proximo; // avança a variavel atual
            }

        }
        return false;
    }
    public void deletar(String Dado){

        if(this.Head == null){
            return;
        }
        if (this.Head.equals(Dado)){
            this.Head = this.Head.Proximo; // atualiza o head, ''joga'' ele pro proximo numero da lista
            this.tamanho--;
            return;
        }
        No anterior = this.Head;
        No atual = this.Head.Proximo;

        if (atual.Dado.equals(Dado)){
            anterior.Proximo = atual.Proximo;
            this.tamanho--;
            return;
        }
        anterior = atual; // muda o valor anterior  para o valor atual (obviamente)
        atual = atual.Proximo; // muda o valor atual para o proximo valor da lista
    }
}