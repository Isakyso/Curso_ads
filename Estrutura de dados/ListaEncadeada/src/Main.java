public static void main(String[] args) {
    ListaEncadeada historico = new ListaEncadeada();

    historico.InserirNoFim("Digitou 'Olá'");
    historico.InserirNoFim("Digitou 'Olá, mundo'");
    historico.InserirnoInicio("Abriu o documento");

    System.out.println("Tamanho: " + historico.getTamanho());
    historico.exibirLista();

    System.out.println(historico.buscar("Digitou 'Olá'"));
    historico.deletar("Digitou 'Olá'");
    historico.exibirLista();
}
