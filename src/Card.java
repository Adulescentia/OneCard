import Util.Util;

import java.util.ArrayList;
import java.util.Arrays;
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
            case 15 -> "G";
            case 16 -> "C";
            default -> String.valueOf(this.num);
        };
    }
    String getShape () {//카드 문양 확인용,문자열 반환
        return switch (this.shape) {
            case 0 -> "S";
            case 1 -> "D";
            case 2 -> "H";
            case 3 -> "C";
            case 4 -> "J";
            default -> throw new IllegalStateException("Unexpected value: " + shape);
        };
    }
    @Override
    public String toString() {
        return this.getShape()+" "+this.getFace();
    }

    boolean compare (Card c1,Card c2) { return (c1.num == c2.num||c1.shape==c2.shape);}
    static boolean compareNumberEveryCard (ArrayList<Card> cards,Card field) {
        for (Card card : cards) {
            if(card.num == field.num){
                return true;
            }
        }
        return false;
    }

}
