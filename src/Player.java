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
    static int askPlayerAmount(Scanner input) { //참가자 수 묻기
        println("Plz type here how many players are going to play this game.");
        return input.nextInt();

    }
    static ArrayList makePlayer(int num, Scanner input) { //플레이어 리스트 생성
        ArrayList<Player> players = new ArrayList<>();
        for(int i = 0;i < num;i++){
            printf("What's p%d's name?\n",i+1); //이름 묻기
            players.add(new Player(input.nextLine(),i));
            printf("ok, hello %s.\n",players.get(i).name);
        }
        return players;
    }


}
