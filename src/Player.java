import Util.Util;

import java.util.ArrayList;
import java.util.Scanner;

import static Util.Util.*;
import static java.lang.System.out;
public class Player {
    String name; //플레이어 이름
    int num; //플레이어 번호
    ArrayList<Card> deck = new ArrayList<>(); //플레이어덱
    Player(String n,int N){ //생성자
        name = n;
        num = N;
    }
}
