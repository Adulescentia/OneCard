import java.util.ArrayList;

import static Util.Util.printf;

public class Gamerule {
    static boolean breakGame (ArrayList<Player> p, int num){
        for(int i = 0;i < num;i++){
            if (p.get(i).deck.size() == 0) {
                printf("\n%s LOSE!",p.get(i).name);
                return (false);
            }
        }
        return (true);
    }
}
