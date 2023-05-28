import Util.Util;

import java.util.*;

import static Util.Util.*;

public class OneCardGame {

    /*This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear.*/
    int amountOfPlayers;
    int turn = -1;

    Card nowcard = new Card(0,0);
    ArrayList<Card> canDrawSameNumberCard = new ArrayList<>();
    ArrayList<Card> canDrawCard = new ArrayList<>();
    ArrayList<Card> field = new ArrayList<>(); // make - field(given cards);
    ArrayList<Card> deck = new ArrayList<>(); // make - decks
    ArrayList<Player> players = new ArrayList<>(); // make - players

    /*This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear.*/

    void prepare(int amount, List<String> playerName){

        amountOfPlayers = amount;
        for(int i = 0;i < amountOfPlayers;i++){
            players.add(new Player(playerName.get(i),i));
        }
        makeDeck();
        for (Player player : players) { player.deck.addAll(drawAmount(7)); }
        introducePlayerCard();
        printf("\n\nNow on field : %s\n",deck.get(0).toString());
        field.add(deck.get(0));
        nowcard = deck.get(0);
        deck.remove(0);
    }

    void progressTurn(Scanner input) {
        turn = getTurn();
        println("\n ------------------------------------------------------ \n");
        printf("%s's turn.\n",players.get(turn).name);
        if(canPlayerDrawCard(turn)) {
            print("You can draw   ");
            showCardCanDraw(turn);
            if(canDrawCard.size() > 0) {
                println("\nPlz type here what number of card you'd like to draw.\nIf you want to get a new card, type 0.");
                drawCard(input.nextInt()-1,turn);
                if(Card.compareNumberEveryCard(canDrawCard,field.get(0))){
                    while (true) {
                        printf("You have more %d, so You can draw more.\nIf you draw one more, type 0. Else, type 1\n",field.get(0).num);
                        if(input.nextInt() == 0){
                            print("You can draw   ");
                            showSameNumberCardCanDraw(turn);
                            println("Plz type here what number of card you'd like to draw.");
                        } else {
                            break;
                        }
                    }
                }
            }
        }
//        progressTurn();
    }

    /*This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear.*/
    void makeDeck() {//덱 생성
        for (int i = 0; i < 52; i++) {this.deck.add(new Card(i / 13, i % 13 + 1));}//create - cards in the deck
        this.deck.addAll(Util.listOf(new Card(4, 13),new Card(4,14))); //add - joker
        Collections.shuffle(this.deck); //shuffle - deck
    }

    void introducePlayerCard() {
        for(int i = 0;i < amountOfPlayers;i++){
            printf("\n%s's cards : ",players.get(i).name);
            for(Card j : players.get(i).deck) {printf("%s ",j);}
        }
    }
    void introduceSpecifficPlayerCard(int playerNumber) {
            printf("\n%s's cards : ",players.get(playerNumber).name);
            for(Card j : players.get(playerNumber).deck) {printf("%s ",j.toString());}
    }
    ArrayList<Card> drawAmount (int amount){
        ArrayList<Card> returnList = new ArrayList<>();
        for(int i = 0; i<amount; i++){
            returnList.add(deck.get(0));
            deck.remove(0);
        }
        return returnList;
    }
    int getTurn () {
        turn++;
        return (turn%amountOfPlayers);
    }
    boolean canPlayerDrawCard (int playerNumber) {
        for (Card card : players.get(playerNumber).deck) {
            if (Objects.equals(card.getShape(), nowcard.getShape()) || Objects.equals(card.getFace(), nowcard.getFace())) { return true; }
        }
        return false;
    }
    void showCardCanDraw (int playerNumber) {

        for (Card card : players.get(playerNumber).deck) {
            if (Objects.equals(card.getShape(), nowcard.getShape()) || Objects.equals(card.getFace(), nowcard.getFace())) {
                printf("%s ",card.toString());
                canDrawCard.add(card);
            }
        }
    }
    void drawCard (int cardNumber, int turn){
        if (cardNumber == -1) {
            pickNewCard(turn);
        } else if (cardNumber >= 0) {
            printf("Now, card on field is %s",players.get(turn).deck.get(cardNumber).toString());
            field.add(players.get(turn).deck.get(cardNumber));
            players.get(turn).deck.remove(cardNumber);
            introduceSpecifficPlayerCard(turn);
        } else {
            print("fuck you");
        }

    }
    void drawSameNumberCard (int cardNumber, int turn) {

    }
    void pickNewCard (int playerNumber) {
        players.get(playerNumber).deck.add(deck.get(0));
        deck.remove(0);
        introduceSpecifficPlayerCard(playerNumber);
    }
    void showSameNumberCardCanDraw (int playerNumber) {
        for (Card card : players.get(playerNumber).deck) {
            if (Objects.equals(card.getFace(), nowcard.getFace())) {
                print(card);
                canDrawSameNumberCard.add(card);
            }
        }
    }
}
