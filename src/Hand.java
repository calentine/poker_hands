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

    private Card.Value highCard = null;
    private Card.Value onePairCard = null;
    private Card.Value twoPairCard = null;
    private Card.Value threeOfKindCard = null;
    private Card.Value fourOfKindCard = null;
    
    
    //Constructor
    public Hand(Stack<Card> hand)
    {
        this.hand = hand;
        evaluateHand();
    }

    public void displayHand()
    {
        for(Card card: hand)
        {
            System.out.print(card.getValue() + " of " + card.getSuit() + " | "); 
        }
    }

    public Card.Value[] getHandValues()
    {
    
        Card.Value[] values = new Card.Value[hand.size()];
        for(int i = 0; i < hand.size(); i++)
        {
            values[i] = hand.get(i).getValue();
        }
        Arrays.sort(values);
       
        return values;
    }

    public Card.Suit[] getHandSuits()
    {
        Card.Suit[] suits = new Card.Suit[hand.size()];
        for(int i = 0; i < hand.size(); i++)
        {
            suits[i] = hand.get(i).getSuit();
        }
        
        return suits;
    }

    public HandTypes getHandType()
    {
        return this.handType;
    }

    public void evaluateHand()
    {
        
        Card.Value[] values = getHandValues();
        Card.Suit[] suits = getHandSuits();
        
        setHighCard(values[values.length - 1]);
        int pairs = getNumPairs(values);
        boolean bThreeOfAKind = isThreeOfAKind(values);
        boolean bStraight = checkIfStraight(values);
        boolean bFlush = checkIfFlush(suits);
        boolean bFullHouse = isFullHouse(values);
        boolean bFourOfAKind = isFourOfAKind(values);
       
        if(bStraight && bFlush)
        {
           this.handType = HandTypes.STRAIGHT_FLUSH;
        }
        else if(bFourOfAKind)
        {
            this.handType = HandTypes.FOUR_OF_A_KIND;
        }
        else if(bFullHouse)
        {
            this.handType = HandTypes.FULL_HOUSE;       
        }
        else if(bFlush)
        {
            this.handType = HandTypes.FLUSH;
        }
        else if(bStraight)
        {
            this.handType = HandTypes.STRAIGHT;
        }
        else if(bThreeOfAKind)
        {
            this.handType = HandTypes.THREE_OF_A_KIND;   
        }
        else if(pairs > 0)
        {
            this.handType = HandTypes.PAIR;
            if(pairs > 1)
            {
                this.handType = HandTypes.TWO_PAIR;
            }  
        }
        else{
            this.handType = HandTypes.HIGH_CARD;
        }
        
    }

    public boolean isFourOfAKind(Card.Value[] values)
    {
        boolean bIsFourOfAKind = (values[0] == values[3] || values[1] == values[4]);
        if(bIsFourOfAKind)
        {
            setFourKindCard(values[1]);
        }

        return bIsFourOfAKind;
    }

    public boolean isFullHouse(Card.Value[] values)
    {
        boolean bIsFullHouse = (values[0] == values[2] && values[3] == values[4]) || (values[0] == values[1] && values[2] == values[4]);
        if(bIsFullHouse)
        {
            setThreeKindCard(values[2]);

            if(values[0] == values[2] && values[3] == values[4])
            {
                setOnePairCard(values[3]);
            }
            else
            {
                setOnePairCard(values[0]);
            }
        }

        return bIsFullHouse;
    }

    public boolean isThreeOfAKind(Card.Value[] values)
    {
        boolean bIsThreeOfAKind = (values[0] == values[2] || values[1] == values[3] || values[2] == values[4]);
        if(bIsThreeOfAKind)
        {
            bIsThreeOfAKind = true;
            setThreeKindCard(values[2]);
        }
       
        return bIsThreeOfAKind;
    }

    public int getNumPairs(Card.Value[] values)
    {
        int pairs = 0;
       
        for(int i = 0; i < values.length - 1; i++)
        {
            if(values[i] == values[i+1])
            {
                pairs++;
                if(pairs == 1)
                {
                    setOnePairCard(values[i]);
                }else
                {
                    setTwoPairCard(values[i]);
                }
            }
        }
       
        return pairs;
    }

    public boolean checkIfStraight(Card.Value[] values)
    {
        
        boolean isAStraight = true;
        boolean specialCaseStraight = (values[0] == Card.Value.TWO && values[1] == Card.Value.THREE && values[2] == Card.Value.FOUR 
                                    && values[3] == Card.Value.FIVE && values[4] == Card.Value.ACE);

        for(int i = 0; i < values.length - 1 && isAStraight; i++)
        {
            isAStraight = values[i].getNumericalValue() + 1 == values[i+1].getNumericalValue();
        }
        if(specialCaseStraight)
        {
            setHighCard(values[3]);
        }
        
        return isAStraight || specialCaseStraight;
    }

    public boolean checkIfFlush(Card.Suit[] suits)
    {
        boolean isAFlush = true;

        for(int i = 0; i < suits.length - 1 && isAFlush; i++)
        {
            isAFlush = suits[i] == suits[i+1];
        }

        return isAFlush;
    }

    public Card.Value getHighCard()
    {
        return this.highCard;
    }

    public void setHighCard(Card.Value value)
    {
        this.highCard = value;
    }

    public Card.Value getOnePairCard()
    {
        return this.onePairCard;
    }

    public void setOnePairCard(Card.Value value)
    {
        this.onePairCard = value;
    }

    public Card.Value getTwoPairCard()
    {
        return this.twoPairCard;
    }

    public void setTwoPairCard(Card.Value value)
    {
        this.twoPairCard = value;
    }

    public Card.Value getThreeKindCard()
    {
        return this.threeOfKindCard;
    }

    public void setThreeKindCard(Card.Value value)
    {
        this.threeOfKindCard = value;
    }

    public Card.Value getFourKindCard()
    {
        return this.fourOfKindCard;
    }

    public void setFourKindCard(Card.Value value)
    {
        this.fourOfKindCard = value;
    } 
}
