import Util.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static Util.Util.printf;

public class OneCardGame {

    /*This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear.*/
    int amountOfPlayers;
    ArrayList<Card> field; // make - field(given cards);
    ArrayList<Card> deck;// make - decks
    ArrayList<Player> players; // make - players

    /*This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear.*/

    void prepare(Scanner input){
        receiveAmountOfPlayers(input);
        makePlayer(input);
        makeDeck();
        givePlayerCard();
        introducePlayerCard();
    }







    /*This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear.*/
    void makeDeck() {//덱 생성
        for (int i = 0; i < 52; i++) {this.deck.add(new Card(i / 13, i % 13 + 1));}//create - cards in the deck
        this.deck.addAll(Util.ListOf(new Card(4, 13),new Card(4,14))); //add - joker
        Collections.shuffle(this.deck); //shuffle - deck
    }

    static void introduce(Card card) {
        printf("[%s] ",card.toString());
    }
    void introducePlayerCard() {
        for(int i = 0;i < this.amountOfPlayers;i++){
            printf("\np%d's cards : ",i+1);
            for(Card j : this.players.get(i).deck) {introduce(j);}
        }
    }

    void makePlayer(Scanner input) { //플레이어 리스트 생성
        for(int i = 0;i < this.amountOfPlayers;i++){
            printf("What's p%d's name?\n",i+1); //이름 묻기
            this.players.add(new Player(input.nextLine(),i));
            printf("ok, hello %s.\n",this.players.get(i).name);
        }
    }

    void givePlayerCard() {
        for (int i = 0; i < amountOfPlayers*7;i++){
            this.players.get(i/7).deck.add(this.deck.get(0));
            this.deck.remove(i);
        }

    }

    void receiveAmountOfPlayers(Scanner input) {
        this.amountOfPlayers = input.nextInt();
    }
}
