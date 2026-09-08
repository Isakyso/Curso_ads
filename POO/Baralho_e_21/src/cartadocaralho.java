import java.util.ArrayList;
import java.util.Collections;

public class cartadocaralho {
    String valor;
    String naipe;


    cartadocaralho(String valor, String naipe){
        this.valor = valor;
        this.naipe = naipe;
    }


    static void main() {
        String[] naipes = {"♣️", "♥️", "♦️", "♠️"};
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String frase = "Suas cartas são: ";
        String frasebanca = "As cartas da banca são: ";
        int total = 0;

        ArrayList<cartadocaralho> Deck = new ArrayList<>();

        for (int i = 0; i < naipes.length; i++) {
            for (int j = 0; j < valores.length; j++) {
                Deck.add(new cartadocaralho(valores[j], naipes[i]));

            }
        }  // criar o deck com valores e naipes

        Collections.shuffle(Deck);//embaralha a porra toda
        ArrayList<cartadocaralho> maobanca = new ArrayList<>();//cartas da banca
        ArrayList<cartadocaralho> mao = new ArrayList<>(); // cartas do jogador
        mao.add(Deck.remove(Deck.size() - 1));
        mao.add(Deck.remove(Deck.size() - 1)); // retira as cartas dadas ao jogador do baralho
        maobanca.add(Deck.remove(Deck.size() - 1));
        maobanca.add(Deck.remove(Deck.size() - 1));//retira as cartas dadas a banca do baralho




        for (int i = 0; i < mao.size(); i++) {

            frase = frase + " " + mao.get(i).valor + mao.get(i).naipe; // adicionar as cartas do jogador na frase
        }
        for (int j = 0; j < maobanca.size(); j++) {
            frasebanca = frasebanca + " " + maobanca.get(j).valor + maobanca.get(j).naipe; // adicionar as cartas da banca na frase

        }
        total = calculartotal(mao);//define o total de pontos do jogador
        int totalbanca = calculartotal(maobanca); //calcula o total de pontos da banca
        IO.println(frase); //diz as carta do jogador
        IO.println("Total de pontos = " + total); // mostra o total de pontos do jogador

        IO.println(frasebanca);// mostra as cartas da banca
        IO.println("Total de pontos da Banca: " + totalbanca);// mostra o total de pontos da banca



        boolean continuar = true;
        while ( continuar && total <= 21){
            IO.println("Deseja continuar?");
            String resposta = IO.readln();
            if (resposta.equals("sim")){
                cartadocaralho novacarta =  Deck.remove(Deck.size() - 1);
                total = total + novacarta.pontos();
                IO.println(frase = frase + " " + novacarta.valor + novacarta.naipe);//atualiza as cartas do jogador
            } else {
                continuar = false;
            }
            IO.println("Seus pontos atuais são: " + total);
        } // decidir se continua jogando(jogador)

        while(totalbanca < 17){
            cartadocaralho novacartabanca = Deck.remove(Deck.size() - 1);
            totalbanca = totalbanca + novacartabanca.pontos();
            IO.println(frasebanca = frasebanca + " " + novacartabanca.valor + novacartabanca.naipe);
            IO.println("Os pontos atuais da banca são: " + totalbanca);//atualizar o println (banca)

        }//decidir se continua (banca)

        if (total > 21){
            IO.println("Otário perdeu KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
        }
        else if (total < 21 && continuar == false && totalbanca > total && totalbanca <= 21){
            IO.println("IH ALA PERDEU PRA UM BOT QUE NEM IA TEM KKKKKKKKKKKKKKKK");
        }
        else if (totalbanca > 21 && total <= 21){
            IO.println("A banca estorou e tu ganhou mas não se acostume! 😡");
        }
        else if(total > totalbanca){
            IO.println("Não vai se achando não, mas tu ganhou! 🙄");
        }
        else if(total == totalbanca){
            IO.println("mermão como tu conseguiu empatar com um bot desse? 💀");
        } //condiçoes de vitoria/derrota


    }

    int pontos() {
        if (valor.equals("J") || valor.equals("Q") || valor.equals("K")) {
            return 10;
        } else if (valor.equals("A")) {
            return 11;

        }else{
            return Integer.parseInt(valor);
        } // condiçoes para ganhar pontos


    }
    static int calculartotal(ArrayList<cartadocaralho> maorecebida){
        int total = 0;
        for (int i = 0; i < maorecebida.size(); i++) {
            total = total + maorecebida.get(i).pontos();
        }
        return total; //calcular o total de pontos apos comprar cartas
    }
}