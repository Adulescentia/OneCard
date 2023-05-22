import static  Util.Util.*;
import java.util.*;
import static java.lang.System.out;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        println("Plz type here how many players are going to play this game.");
        int numOfPlayer = input.nextInt();
        input = new Scanner(System.in);
        ArrayList<Card> field; //필드;
        ArrayList<Card> deck = Card.makeDeck();//덱 생성
        ArrayList<Player> players = Player.makePlayer(numOfPlayer,input); // 플레이어 생성
        for(int i = 0;i < numOfPlayer; i++) {
            for (int j = 0; j < 7; j++) {//플레이어에게 카드 지급(7장)
                players.get(i).deck.add(deck.get(0));
                deck.remove(0);
            }
        }

        do {//원카드 실행문
            for(int i = 0;i < numOfPlayer;i++){
                printf("\np%d's cards : ",i+1);
                for(Card j : players.get(i).deck) {Card.introduce(j);}
            }
            players.get(1).deck = new ArrayList<>();

        }while(Gamerule.breakGame(players,numOfPlayer));


    }
//


}

