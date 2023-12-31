import java.util.Arrays;
import java.util.Stack;

public class Hand 
{
    public enum HandTypes
    {
        HIGH_CARD, PAIR, TWO_PAIR, 
        THREE_OF_A_KIND, STRAIGHT, FLUSH,
        FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH
    };

    private Stack<Card> hand;
    private HandTypes handType;
    
    //Constructor
    public Hand(Stack<Card> hand)
    {
        this.hand = hand;
    }

    public void displayHand()
    {
        for(Card card: hand)
        {
            System.out.print(card.getValue() + "" + card.getSuit() + " "); 
        }
    }

    public char[] getHandValues()
    {
    
        char[] values = new char[hand.size()];
        for(int i = 0; i < hand.size(); i++)
        {
            values[i] = hand.get(i).getValue();
        }
        Arrays.sort(values);
        
        return values;
    }

    public char[] getHandSuits()
    {
    
        char[] suits = new char[hand.size()];
        for(int i = 0; i < hand.size(); i++)
        {
            suits[i] = hand.get(i).getSuit();
        }
        
        return suits;
    }

    public HandTypes getHandType()
    {
        
        char[] values = getHandValues();
        char[] suits = getHandSuits();
        
        int pairs = 0;
        boolean bFourOfAKind = isFourOfAKind(values);
        boolean bFullHouse = isFullHouse(values);
        boolean bThreeOfAKind = isThreeOfAKind(values);

        if(!bFourOfAKind && !bFullHouse && !bThreeOfAKind)
        {
            pairs = getNumPairs(values);
        }
        
        boolean bStraight = checkIfStraight(values);
        boolean bFlush = checkIfFlush(suits);
    
        if(bFourOfAKind)
        {
            
            handType = HandTypes.FOUR_OF_A_KIND;
           
        }
        else if(bFullHouse)
        {
           
            
            handType = HandTypes.FULL_HOUSE; 
            
        }
        else if(bThreeOfAKind)
        {
            
            handType = HandTypes.THREE_OF_A_KIND;
           
        }
        else if(pairs > 0)
        {
        
            handType = HandTypes.PAIR;
            if(pairs > 1)
            {
                handType = HandTypes.TWO_PAIR;
            }  
        }
        else if(bStraight && bFlush)
        {
           
           handType = HandTypes.STRAIGHT_FLUSH;
       
        }
        else if(bStraight)
        {
           
            handType = HandTypes.STRAIGHT;
           
        }
        else if(bFlush)
        {
            
            handType = HandTypes.FLUSH;
           
        }
        else{
            
            handType = HandTypes.HIGH_CARD;
            
        }
        
        return handType;
    }

    public boolean isFourOfAKind(char[] values)
    {
        return (values[0] == values[3] || values[1] == values[4]);
    }

    public boolean isFullHouse(char[] values)
    {
        return (values[0] == values[2] && values[3] == values[4]) || (values[0] == values[1] && values[2] == values[4]);
    }

    public boolean isThreeOfAKind(char[] values)
    {
        return (values[0] == values[2] || values[1] == values[3] || values[2] == values[4]);
    }

    public int getNumPairs(char[] values)
    {
        int pairs = 0;
       
        for(int i = 0; i < values.length - 1; i++)
        {
            if(values[i] == values[i+1])
            {
                pairs++;
            }
        }
       
        return pairs;
    }

    public boolean checkIfStraight(char[] values)
    {
        boolean onlyNums = Character.isDigit(values[values.length - 1]);
        boolean isAStraight = true;
        if(onlyNums)
        {
            for(int i = 0; i < values.length - 1 && isAStraight; i++)
            {
                isAStraight = (int) values[i] + 1 == (int) values[i+1];
            }
        }
        else
        {
            String otherStraightHands = new String(values);
            isAStraight = otherStraightHands.equals("2345A") 
                        || otherStraightHands.equals("789JT")
                        || otherStraightHands.equals("89JQT")
                        || otherStraightHands.equals("9JKQT")
                        || otherStraightHands.equals("AJKQT"); 
        }

        return isAStraight;
    }

    public boolean checkIfFlush(char[] suits)
    {
        boolean isAFlush = true;

        for(int i = 0; i < suits.length - 1 && isAFlush; i++)
        {
            isAFlush = suits[i] + 1 == suits[i+1];
        }

        return isAFlush;
    }

    public String getHighCard()
    {
        char[] values = getHandValues();
        boolean onlyNums = Character.isDigit(values[values.length - 1]);
        String highCard = "";
        highCard += values[0];
        if(onlyNums)
        {
            highCard += values[4];
        }
        else
        {
            String handToString = new String(values);
            if(handToString.contains("A"))
            {
                highCard = "ACE";
            }
            else if(handToString.contains("K"))
            {
                 highCard = "KING";
            }
            else if (handToString.contains("Q") )
            {
                 highCard = "QUEEN"; 
            }
            else if(handToString.contains("J"))
            {
                 highCard = "JACK";
            }
            else
            {
                 highCard = "TEN";
            }    
        }

        return highCard;
    }

   

    
    
}
