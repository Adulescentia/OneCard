import Util.Util;

import java.util.*;

import static Util.Util.*;

public class OneCardGame {

    /*This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear.*/
    int amountOfPlayers;
    int turn = -1;
    Card nowcard = new Card(0,0);
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
        printf("\n\nNow on field : [%s]\n",deck.get(0).toString());
        field.add(deck.get(0));
        nowcard = deck.get(0);
        deck.remove(0);
    }

    void progressTurn(int cardNumber, int amountOfDrawCards) {
        if(canPlayerDrawCard(getWhichPlayerTurnNow())) {
            showPlayerCardTheyCanDraw(getWhichPlayerTurnNow());
            drawCards(cardNumber,amountOfDrawCards);
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
            for(Card j : players.get(i).deck) {printf("[%s] ",j.toString());}
        }
    }
    ArrayList<Card> drawAmount (int amount){
        ArrayList<Card> returnList = new ArrayList<>();
        for(int i = 0; i<amount; i++){
            returnList.add(deck.get(0));
            deck.remove(0);
        }
        return returnList;
    }
    int getWhichPlayerTurnNow () {
        turn++;
        return (turn%(amountOfPlayers*2)/2);
    }
    boolean canPlayerDrawCard (int playerNumber) {
        for (Card card : players.get(playerNumber).deck) {
            if (Objects.equals(card.getShape(), nowcard.getShape()) || Objects.equals(card.getFace(), nowcard.getFace())) { return true; }
        }
        return false;
    }
    void showPlayerCardTheyCanDraw (int playerNumber) {
        printf("%s, You can draw   ",players.get(playerNumber).name);
        for (Card card : players.get(playerNumber).deck) {
            if (Objects.equals(card.getShape(), nowcard.getShape()) || Objects.equals(card.getFace(), nowcard.getFace())) {
                printf("[%s]",card.toString());
                canDrawCard.add(card);
            }
        }
    }
    void drawCards (int cardNumber, int amountOfCards ){
        for(Card card : canDrawCard) {

        }
    }
}
