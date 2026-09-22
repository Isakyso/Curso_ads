public class CartaDoBaralho {

    String valor;
    String naipe;

    CartaDoBaralho(String valor, String naipe) {
        this.valor = valor;
        this.naipe = naipe; // construtor da carta
    }

    int pontos() {
        if (valor.equals("J") || valor.equals("Q") || valor.equals("K")) {
            return 10;
        } else if (valor.equals("A")) {
            return 11;
        } else {
            return Integer.parseInt(valor);  // define os valores das cartas
        }
    }
}