/*
 * Card Class
 * contains the suit: {C:club, D:diamond, H:heart, S:spade}
 * and the value: {2,3,4,5,6,7,8,9,T,J,Q,K,A}
 */
public class Card {
    
    public enum Value 
    {   TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), 
        TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);

        private final int numericalValue;

        Value(int cardNumericalValue)
        {
            this.numericalValue = cardNumericalValue;
        }

        public int getNumericalValue()
        {
            return this.numericalValue;
        }
    
    };
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
