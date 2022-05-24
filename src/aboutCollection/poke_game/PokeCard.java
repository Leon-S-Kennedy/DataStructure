package aboutCollection.poke_game;

import java.util.Comparator;

public class PokeCard implements Comparable<PokeCard> {
    public int rank;
    public String suit;

    public PokeCard(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString(){
        String rankS;
        switch (rank){
            case 1:rankS="A";break;
            case 11:rankS="J";break;
            case 12:rankS="Q";break;
            case 13:rankS="K";break;
            default:rankS=String.valueOf(rank);
        }
        return String.format("[ %s %s ]",suit,rankS);
    }

    public static void main(String[] args) {
        PokeCard p1 = new PokeCard(12, "♥");
        System.out.println(p1.toString());
    }

    @Override
    public int compareTo(PokeCard o) {
        return o.rank-this.rank;
    }
}
