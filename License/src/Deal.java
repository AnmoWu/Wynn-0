//斗地主发牌

import java.util.ArrayList;
import java.util.Collections;

public class Deal {
    public static void main(String[] args) {
        ArrayList box=new ArrayList();
        ArrayList<String> colors=new ArrayList<String>();
        ArrayList<String> numbers = new ArrayList<String>();

        colors.add("♠");
        colors.add("♥");
        colors.add("♦");
        colors.add("♣");

        for(int i = 2;i<=10;i++)
            numbers.add(i+"");

        numbers.add("J");
        numbers.add("Q");
        numbers.add("K");
        numbers.add("A");

        for (Object color : colors) {
            for(String number : numbers){
                String card = color+number;
                box.add(card);
            }
        }

        box.add("joker");
        box.add("JOKER");

        Collections.shuffle(box);
        ArrayList<String> player1 = new ArrayList<String>();
        ArrayList<String> player2 = new ArrayList<String>();
        ArrayList<String> player3 = new ArrayList<String>();
        ArrayList<String> hand = new ArrayList<String>();

        for(int i = 0;i<box.size();i++){
            String card = (String) box.get(i);

            if(i<51) {
                if(i%3==0)
                    player1.add(card);
                else if(i%3==1)
                    player2.add(card);
                else
                    player3.add(card);
            }
            else
                hand.add(card);
        }
        System.out.println("吴："+player1);
        System.out.println("欣："+player2);
        System.out.println("怡："+player3);
        System.out.println("底牌："+hand);
    }
}
