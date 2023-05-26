import Util.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static Util.Util.printf;
import static Util.Util.println;

public class OneCardGame {

    /*This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear.*/
    int amountOfPlayers;
    ArrayList<Card> field = new ArrayList<>(); // make - field(given cards);
    ArrayList<Card> deck = new ArrayList<>(); // make - decks
    ArrayList<Player> players = new ArrayList<>(); // make - players

    /*This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear.*/

    void prepare(int amount, List<String> playerName){

        amountOfPlayers = amount;
        for(int i = 0;i < amountOfPlayers;i++){
            printf("What's p%d's name?\n",i+1); //이름 묻기
            players.add(new Player(playerName.get(i),i));
            printf("ok, hello %s.\n",players.get(i).name);
        }
        makeDeck();
        for (Player player : players) { player.deck.addAll(drawAmount(7)); }
        introducePlayerCard();
    }







    /*This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear.*/
    void makeDeck() {//덱 생성
        for (int i = 0; i < 52; i++) {this.deck.add(new Card(i / 13, i % 13 + 1));}//create - cards in the deck
        this.deck.addAll(Util.listOf(new Card(4, 13),new Card(4,14))); //add - joker
        Collections.shuffle(this.deck); //shuffle - deck
    }

    void introducePlayerCard() {
        for(int i = 0;i < amountOfPlayers;i++){
            printf("\np%d's cards : ",i+1);
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
}
