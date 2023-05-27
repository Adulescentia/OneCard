import static  Util.Util.*;
import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;
public class Main {
    public static void main(String[] args) {

        /*This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear.*/
        /*vars*/
        String name;
        ArrayList<String> playersName = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        OneCardGame onecard = new OneCardGame();

        /*This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear.*/
        /*inputs*/

        println("Plz type here how many players are going to play this game.");
        int amountOfPlayers = input.nextInt();
        input = new Scanner(System.in);
        for(int i = 0; i < amountOfPlayers; i++) {
            printf("What's p%d's name?\n",i+1); //이름 묻기
            name = input.nextLine();
            playersName.add(name);
            printf("ok, hello %s.\n\n",name);
        }

        /*This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear. This is just a banner,dear.*/
        /*methods*/
        onecard.prepare(amountOfPlayers, playersName);
        onecard.progressTurn();


    }
}

