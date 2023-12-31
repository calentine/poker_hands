/*
 * Card Class
 * contains the suit: {C:club, D:diamond, H:heart, S:spade}
 * and the value: {2,3,4,5,6,7,8,9,T,J,Q,K,A}
 */
public class Card {
    
    private char suit;
    private char value;

    //Constructor 
    public Card(char suit, char value){
        this.suit = suit;
        this.value = value;
    }

    public char getSuit(){

        return this.suit;
    }

    public char getValue(){

        return this.value;
    }
}
