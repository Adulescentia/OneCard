import static  Util.Util.*;
import java.util.*;
import static java.lang.System.out;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        println("Plz type here how many players are going to play this game.");

//        int amountOfPlayer = input.nextInt(); // recieve - player amount
//        input = new Scanner(System.in);
//
//        ArrayList<Card> field; // make - field(given cards);
//        ArrayList<Card> deck = Card.makeDeck(); // make - decks
//        ArrayList<Player> players = Player.makePlayer(amountOfPlayer,input); // make - players
//
//        players = Card.givePlayerCard(players,deck,amountOfPlayer); // shuffle - give result to players
//        for (int i=0; i<7*amountOfPlayer; i++) { deck.remove(i); } //delete - 7*amountOfPlayer cards in the deck


        /*will delete*/
        /*from here*/
        do { // execution statement - OneCard
            Card.introducePlayerCard(players,amountOfPlayer); // intruduce - card to player
        }while(Gamerule.breakGame(players,amountOfPlayer));
        /*to here*/

    }
}

