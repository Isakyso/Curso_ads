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

        IO.println("Baralho criado e embaralhado!");
    }

    void iniciarJogo() {

        mao.clear(); // ''limpa'' o arraylist da mão do jogador
        maobanca.clear(); // ''limpa'' o arraylist da mão da banca

        mao.add(deck.remove(deck.size() - 1)); // retira a carta do deck e da ao jogador
        mao.add(deck.remove(deck.size() - 1));

        maobanca.add(deck.remove(deck.size() - 1)); // retira a carta do deck e da para a banca
        maobanca.add(deck.remove(deck.size() - 1));

        total = calcularTotal(mao);
        totalbanca = calcularTotal(maobanca); // calcula o total da mão do jogador e da banca

        IO.println("Começou o jogo!");
        IO.println("Suas cartas: " + mao);
        IO.println("Seu total: " + total);

        IO.println("Cartas da banca: " + maobanca);
        IO.println("Total da banca: " + totalbanca);

        boolean continuar = true;

        while (continuar && total <= 21) {

            IO.println("Deseja comprar outra carta? (sim/nao)");
            String resposta = IO.readln();

            if (resposta.equalsIgnoreCase("sim")) {

                comprarCarta();

            } else if (resposta.equalsIgnoreCase("nao")) {

                continuar = false;

            } else {

                IO.println("Resposta inválida. Digite sim ou nao.");
            }
        } // pergunta ao jogador se ele quer continuar jogando ou não

        if (total <= 21) {
            jogarBanca();
        }

        IO.println("Suas cartas finais: " + mao);
        IO.println("Seu total final: " + total);

        IO.println("Cartas finais da banca: " + maobanca);
        IO.println("Total final da banca: " + totalbanca); // encerra o jogo

        IO.println(resultado());
    }

    CartaDoBaralho comprarCarta() {

        CartaDoBaralho novaCarta = deck.remove(deck.size() - 1);

        mao.add(novaCarta);

        total = calcularTotal(mao);

        IO.println("Você comprou: " + novaCarta);
        IO.println("Suas cartas agora: " + mao);
        IO.println("Seu total agora: " + total);

        return novaCarta;
    } // faz o ato de puxar uma nova carta

    void jogarBanca() {

        IO.println("A banca vai jogar...");

        while (totalbanca < 17) {

            CartaDoBaralho novaCarta = deck.remove(deck.size() - 1);

            maobanca.add(novaCarta);

            totalbanca = calcularTotal(maobanca);

            IO.println("A banca comprou: " + novaCarta);
            IO.println("Cartas da banca: " + maobanca);
            IO.println("Total da banca: " + totalbanca);

        } // condição para banca continuar jogando

        IO.println("A banca parou com " + totalbanca + " pontos.");
    }

    int calcularTotal(ArrayList<CartaDoBaralho> maoRecebida) {

        int total = 0;
        int ases = 0;

        for (int i = 0; i < maoRecebida.size(); i++) {

            total = total + maoRecebida.get(i).pontos();

            if (maoRecebida.get(i).valor.equals("A")) {
                ases++;
            }
        }  // define a quantidade de pontos adquiridas

        while (total > 21 && ases > 0) {
            total = total - 10;
            ases--;
        }  // define se o valor de A vai ser 11 ou 1

        return total;
    }

    String resultado() {

        if (total > 21) {
            IO.println("Você estourou!");
            return "Você perdeu!";
        }

        if (totalbanca > 21) {
            IO.println("A banca estourou!");
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