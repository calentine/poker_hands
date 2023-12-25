import java.util.Stack;

public class Hand 
{
    private Stack<Card> hand;
    
    //Constructor
    public Hand(Stack<Card> hand)
    {
        this.hand = hand;
    }

    public void displayHand()
    {
        for(Card card: hand)
        {
            System.out.print(card.getSuit() + "" + card.getValue() + " "); 
        }
    }

    public void getHandType()
    {
         for(Card card: hand){
            




         }

    }
    
}
