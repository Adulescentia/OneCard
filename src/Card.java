import java.util.ArrayList;
import java.util.Collections;
import static  Util.Util.*;
public class Card {
    int shape;//문양
    int num;//숫자

    Card(int s,int n) {//생성자
        shape = s;
        num = n;
    }
    String getFace () {//카드 종류 확인용,문자열 반환
        return switch (this.num) {
            case 1  -> "A";
            case 11 -> "J";
            case 12 -> "Q";
            case 13 -> "K";
            case 14 -> "Joker";
            default -> String.valueOf(this.num);
        };
    }
    String getShape () {//카드 문양 확인용,문자열 반환
        return switch (this.shape) {
            case 0 -> "S";
            case 1 -> "D";
            case 2 -> "H";
            case 3 -> "C";
            case 4 -> "GJ";
            case 5 -> "CJ";
            default -> throw new IllegalStateException("Unexpected value: " + shape);
        };
    }
    int Ability () {//카드 능력,받는 카드 반환
        return switch (this.num) {
            case 1 -> 3;
            case 2 -> 2;
            case 14 -> 5;
            case 15 -> 7;
            default -> 0;
        };
    }
    @Override
    public String toString() {
        return this.getShape()+" "+this.getFace();
    }
    boolean compare (Card c1,Card c2) { return (c1.num == c2.num||c1.shape==c2.shape);}
    static ArrayList<Card> makeDeck() {//덱 생성
        ArrayList<Card> deck = new ArrayList<>();
        for (int i = 0; i < 52; i++) {deck.add(new Card(i / 13, i % 13 + 1));}//카드 생성
        deck.add(new Card(4, 13));//흑조커
        deck.add(new Card(5, 14));//컬러조커
        Collections.shuffle(deck);
        return deck;
    }

    static void introduce(Card card) {
        printf("[%s] ",card.toString());
    }

//    static void introducePlayerCard()


}
