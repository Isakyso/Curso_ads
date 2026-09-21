import java.util.ArrayList;
import java.util.Collections;

public class Jogo21 {

    ArrayList<CartaDoBaralho> deck = new ArrayList<>();
    ArrayList<CartaDoBaralho> mao = new ArrayList<>();
    ArrayList<CartaDoBaralho> maobanca = new ArrayList<>();

    int total = 0;
    int totalbanca = 0;

    Jogo21() {

        String[] naipes = {"♣️", "♥️", "♦️", "♠️"};
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (int i = 0; i < naipes.length; i++) {
            for (int j = 0; j < valores.length; j++) {  // cria o deck
                deck.add(new CartaDoBaralho(valores[j], naipes[i]));
            }
        }

        Collections.shuffle(deck); // embaralha o deck
    }

    void iniciarJogo() {

        mao.clear();
        maobanca.clear();

        mao.add(deck.remove(deck.size() - 1));
        mao.add(deck.remove(deck.size() - 1));

        maobanca.add(deck.remove(deck.size() - 1));
        maobanca.add(deck.remove(deck.size() - 1));

        total = calcularTotal(mao);
        totalbanca = calcularTotal(maobanca);
    }

    CartaDoBaralho comprarCarta() {

        CartaDoBaralho novaCarta = deck.remove(deck.size() - 1);

        mao.add(novaCarta);

        total = calcularTotal(mao);

        return novaCarta;
    }

    void jogarBanca() {

        while (totalbanca < 17) {

            CartaDoBaralho novaCarta = deck.remove(deck.size() - 1);

            maobanca.add(novaCarta);

            totalbanca = calcularTotal(maobanca);
        } // condição para banca continuar jogando
    }

    int calcularTotal(ArrayList<CartaDoBaralho> maoRecebida) {

        int total = 0;
        int ases = 0;

        for (int i = 0; i < maoRecebida.size(); i++) {

            total = total + maoRecebida.get(i).pontos();

            if (maoRecebida.get(i).valor.equals("A")) {
                ases++;
            }
        }

        while (total > 21 && ases > 0) {
            total = total - 10;
            ases--;
        }  // define se o valor de A vai ser 11 ou 1

        return total;
    }

    String resultado() {

        if (total > 21) {
            return "Você perdeu!";
        }

        if (totalbanca > 21) {
            return "Você ganhou!";
        }

        if (total > totalbanca) {
            return "Você ganhou!";
        }

        if (total < totalbanca) {
            return "Você perdeu!";
        }

        return "Empate!"; // condições de vitoria/derrota/empate
    }
}