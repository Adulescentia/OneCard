import Util.Util;

import java.util.*;

import static Util.Util.*;

public class OneCardGame {

    /*This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear.*/
    int amountOfPlayers;
    static int turn = -1;
    int turnDirection = 1;
    Card nowCard = new Card(0,0);
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
        nowCard = field.get(0);
        deck.remove(0);
    }

    void progressTurn(Scanner input) {
        nowCard = field.get(0);
        turn = getTurn();
        println("\n ------------------------------------------------------ \n");
        printf("%s's turn.\n",players.get(turn).name);
        printf("Now, card on field is %s",nowCard);
        introduceSpecificPlayerCard(turn);
        if(canPlayerDrawCard(turn)) {
            print("\nYou can draw   ");
            showCardCanDraw(turn);
            println("\nPlz type here what number of card you'd like to draw.\nIf you want to get a new card, type 0.");
            drawCard(input.nextInt()-1,turn);
            activeAbility();
            if(Card.compareNumberEveryCard(players.get(turn).deck,nowCard)){
                while (true) {
                    printf("You have more %s, so You can draw more.\nIf you draw one more, type 0. Else, type 1\n",nowCard.getFace());
                    if(input.nextInt() == 0){
                        print("You can draw   ");
                        showSameNumberCardCanDraw(turn);
                        println("Plz type here what number of card you'd like to draw.");
                        drawSameNumberCard(input.nextInt()-1,turn);
                    } else {
                        break;
                    }
                }
            }
        } else {
            println("You don't have card to draw. so, you need to take a card.");
            pickNewCard(turn);
        }
        progressTurn(input);
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
    void introduceSpecificPlayerCard(int playerNumber) {
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
        turn+=turnDirection;
        return (turn%amountOfPlayers);
    }
    boolean canPlayerDrawCard (int playerNumber) {
        for (Card card : players.get(playerNumber).deck) {
            if (Objects.equals(card.getShape(), nowCard.getShape()) || Objects.equals(card.getFace(), nowCard.getFace())) { return true; }
        }
        return false;
    }
    void showCardCanDraw (int playerNumber) {

        for (Card card : players.get(playerNumber).deck) {
            if (Objects.equals(card.getShape(), nowCard.getShape()) || Objects.equals(card.getFace(), nowCard.getFace())) {
                printf("%s ",card.toString());
                canDrawCard.add(card);
            }
        }
    }
    void drawCard (int cardNumber, int turn){
        if (cardNumber == -1) {
            pickNewCard(turn);
        } else if (cardNumber >= 0) {

            field.add(0,canDrawCard.get(cardNumber));
            players.get(turn).deck.remove(field.get(0));
            printf("Now, card on field is %s",field.get(0));
            introduceSpecificPlayerCard(turn);
        } else {
            print("fuck you");
        }
        nowCard = field.get(0);
    }
    void drawSameNumberCard (int cardNumber, int  turn) {
        if (cardNumber == -1) {
            pickNewCard(turn);
        } else if (cardNumber >= 0) {

            field.add(0,canDrawSameNumberCard.get(cardNumber));
            players.get(turn).deck.remove(field.get(0));
            printf("Now, card on field is %s",field.get(0));
            introduceSpecificPlayerCard(turn);
        } else {
            print("fuck you");
        }
        nowCard = field.get(0);
    }
    void pickNewCard (int playerNumber) {
        players.get(playerNumber).deck.add(deck.get(0));
        deck.remove(0);
        introduceSpecificPlayerCard(playerNumber);
    }
    void showSameNumberCardCanDraw (int playerNumber) {
        canDrawCard = new ArrayList<>();
        for (Card card : players.get(playerNumber).deck) {
            if (Objects.equals(card.getFace(), nowCard.getFace())) {
                print(card);
                canDrawSameNumberCard.add(card);
            }
        }
    }
    void activeAbility() {
        switch (nowCard.shape) {
            case 11:
                break;
            case 12:
                queenAbility();
                break;
            case 13:
                kingAbility();
            default:
                break;
        }
    }
    void queenAbility() {
        if (nowCard.num == 12) { turnDirection --; }
    }
    void kingAbility() {
        if (nowCard.num == 13) {turn --;}
    }
}
