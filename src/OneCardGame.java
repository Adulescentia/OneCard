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
        introduceSpecificPlayerCard(turn);
        if(canPlayerDrawCard(turn)) {
            print("\nYou can draw   ");
            showCardCanDraw(turn);
            println("\nPlz type here what number of card you'd like to draw.\nIf you want to get a new card, type 0.");
            drawCard(input.nextInt()-1,turn);
            Card.kingAbility(nowcard,this);
            if(Card.compareNumberEveryCard(canDrawCard,nowcard)){
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
        } else {
            println("You don't have card can draw. so, you need to take a card.");
            drawCard(input.nextInt()-1,turn);
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
        turn+=Card.queenAbility(nowCard,turnDirection);
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
            printf("Now, card on field is %s",players.get(turn).deck.get(cardNumber));
            field.add(0,players.get(turn).deck.get(cardNumber));
            players.get(turn).deck.remove(cardNumber);
            introduceSpecificPlayerCard(turn);
        } else {
            print("fuck you");
        }

    }
    void drawSameNumberCard (int cardNumber, int  turn) {

    }
    void pickNewCard (int playerNumber) {
        players.get(playerNumber).deck.add(deck.get(0));
        deck.remove(0);
        introduceSpecificPlayerCard(playerNumber);
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
