/*
 * Card Class
 * contains the suit: {C:club, D:diamond, H:heart, S:spade}
 * and the value: {2,3,4,5,6,7,8,9,T,J,Q,K,A}
 */
public class Card {
    
    public enum Value {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, 
                        TEN, JACK, QUEEN, KING, ACE};
    public enum Suit {CLUBS, DIAMONDS, HEARTS, SPADES};

    private Suit suit;
    private Value value;

    //Constructor 
    public Card(Suit suit, Value value){
        this.suit = suit;
        this.value = value;
       
    }

    public Suit getSuit(){

        return this.suit;
    }

    public Value getValue(){

        return this.value;
    }

}
