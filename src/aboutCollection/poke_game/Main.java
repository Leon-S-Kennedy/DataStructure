package aboutCollection.poke_game;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<PokeCard> deck=new ArrayList<>();
        String[] suit={"♥","♦","♠","♣"};
        for (String s : suit) {
            for (int i = 1; i <= 13; i++) {
                PokeCard pokeCard = new PokeCard(i, s);
                deck.add(pokeCard);
            }
        }

        Random random = new Random(2150);
        Collections.shuffle(deck,random);
        System.out.println(deck);

        PokeCard play1;
        PokeCard play2;
        PokeCard play3;
        PokeCard play4;

        play1=deck.remove(0);
        play2=deck.remove(0);
        play3=deck.remove(0);
        play4=deck.remove(0);

        System.out.println("玩家1的手牌："+play1);
        System.out.println("玩家2的手牌："+play2);
        System.out.println("玩家3的手牌："+play3);
        System.out.println("玩家4的手牌："+play4);

        int [] array=new int[]{play1.rank,play2.rank,play3.rank,play4.rank};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                if(array[j]>array[j+1]){
                    int t=array[j];
                    array[j]=array[j+1];
                    array[j+1]=t;
                }
            }
        }
        if(play1.rank==array[3]){
            System.out.println("play1赢了");
        }
        if(play2.rank==array[3]){
            System.out.println("play2赢了");
        }
        if(play3.rank==array[3]){
            System.out.println("play3赢了");
        }
        if(play4.rank==array[3]){
            System.out.println("play4赢了");
        }

    }
}
