import java.util.Stack;

/*
 * Utility Class that is used to analyze/compare hands
 * and build test hands with hands passed in as strings as 
 * provided in Poker hands kata.
 */
public class HandAnalyzer {

    //Empty Constructor
    public HandAnalyzer()
    {

    }

    /*
    * Entry function which all other functions cascade for comparisions based on hand types.
    * This function is only ever called if the hands being compared are equal. If so a switch
    * Statement is executed based on the handtypes. The values returned are either > 0, < 0, or =.
    * If > player1 wins, < player2, = tie.
    */
    public static int compareHands(Hand handOne, Hand handTwo)
    {
        int value = (handOne.getHandType()).compareTo(handTwo.getHandType());
        if(value == 0)
        {
            switch (handOne.getHandType()) 
            {
                case Hand.HandTypes.PAIR:
                    value = getBestPairHand(handOne, handTwo,1);
                    break;
                case Hand.HandTypes.TWO_PAIR:
                    value = getBestPairHand(handOne, handTwo,2);
                    break;
                case Hand.HandTypes.THREE_OF_A_KIND:
                    value = getBestThreeOfKindHand(handOne, handTwo);
                    break;
                case Hand.HandTypes.STRAIGHT:
                    value = getBestStraightHand(handOne, handTwo);
                    break;
                case Hand.HandTypes.FLUSH:
                    value = getBestFlushHand(handOne, handTwo);
                    break;
                case Hand.HandTypes.FULL_HOUSE:
                    value = getBestFullHouseHand(handOne, handTwo);
                    break;
                case Hand.HandTypes.FOUR_OF_A_KIND:
                    value = getBestFourOfKindHand(handOne, handTwo);
                    break;
                case Hand.HandTypes.STRAIGHT_FLUSH:
                    value = getBestStraightFlushHand(handOne, handTwo);
                    break;
                default:
                    value = getBestHighCardHand(handOne, handTwo);
                    break;
            }
        }
            
        return value;
    }

    /*
     * compare & return value for the best high card by looping over the hand and sets the high card 
     * in the process to help with assigning a value to the high card when declaring the winner.
     */
    public static int getBestHighCardHand(Hand handOne, Hand handTwo)
    {
        int value = 0;
        Card.Value[] handOneValues = handOne.getHandValues();
        Card.Value[] handTwoValues = handTwo.getHandValues();
        int handSize = handOneValues.length - 1;
        for (int i = handSize; i >= 0; i--)
        {
            if(handOneValues[i].compareTo(handTwoValues[i]) > 0)
            {
                value++;
                handOne.setHighCard(handOneValues[i]);
                break;
            }
            else if(handOneValues[i].compareTo(handTwoValues[i]) < 0)
            {
                value--;
                handTwo.setHighCard(handTwoValues[i]);
               break;
            }
        } 
        return value;
    }
    /*
     * Compares the best pair(s) in the hands based on the amount of pairs. First compare
     * one pair value, then if 2 pair compare 2 pair value and 1 pair value. If equal we
     * compare the best high card hand to decide if there is a better rank(kicker).
     */
    public static int getBestPairHand(Hand handOne, Hand handTwo, int pairCount)
    {
        int value = 0;
        if(pairCount == 1)
        {
            if(handOne.getOnePairCard().compareTo(handTwo.getOnePairCard()) > 0)
            {
                value++;
            }
            else if(handOne.getOnePairCard().compareTo(handTwo.getOnePairCard()) < 0)
            {
                value--;
            }
        }
        else if(pairCount == 2)
        {
            if(handOne.getTwoPairCard().compareTo(handTwo.getTwoPairCard()) > 0)
            {
                value++;
            }
            else if(handOne.getTwoPairCard().compareTo(handTwo.getTwoPairCard()) < 0)
            {
                value--;
            }

            if(value == 0)
            {
                if(handOne.getOnePairCard().compareTo(handTwo.getOnePairCard()) > 0)
                {
                    value++;
                }
                else if(handOne.getOnePairCard().compareTo(handTwo.getOnePairCard()) < 0)
                {
                    value--;
                }
            }
        }

        if(value == 0)
        {
          value = getBestHighCardHand(handOne, handTwo); 
        }

        return value;
    }

    //compare & return value for best three of a kind hand
    public static int getBestThreeOfKindHand(Hand handOne, Hand handTwo)
    {
        int value = 0;
        if(handOne.getThreeKindCard().compareTo(handTwo.getThreeKindCard()) > 0)
        {
            value++;
        }
        else if(handOne.getThreeKindCard().compareTo(handTwo.getThreeKindCard()) < 0)
        {
            value--;
        }

        return value;
    }

    //compare & return value for best four of a kind hand
    public static int getBestFourOfKindHand(Hand handOne, Hand handTwo)
    {
        int value = 0;
        if(handOne.getFourKindCard().compareTo(handTwo.getFourKindCard()) > 0)
        {
            value++;
        }
        else if(handOne.getFourKindCard().compareTo(handTwo.getFourKindCard()) < 0)
        {
            value--;
        }
        return value;
    }

    //compare & return value for best Straight hand
    public static int getBestStraightHand(Hand handOne, Hand handTwo)
    {
        int value = 0;
        if(handOne.getHighCard().compareTo(handTwo.getHighCard()) > 0)
        {
            value++;
        }
        else if(handOne.getHighCard().compareTo(handTwo.getHighCard()) < 0)
        {
            value--;
        }

        return value;
    }
    //compare & return value for best flush card hand
    public static int getBestFlushHand(Hand handOne, Hand handTwo)
    {
        int value = getBestHighCardHand(handOne, handTwo);
    
        return value;
    }
    //compare & return value for bestFull house hand
    public static int getBestFullHouseHand(Hand handOne, Hand handTwo)
    {
        int value = 0;
        if(handOne.getThreeKindCard().compareTo(handTwo.getThreeKindCard()) > 0)
        {
            value++;
        }
        else if(handOne.getThreeKindCard().compareTo(handTwo.getThreeKindCard()) < 0)
        {
            value--;
        }

        return value;
    }
    //compare & return value for best straight flush hand
    public static int getBestStraightFlushHand(Hand handOne, Hand handTwo)
    {
        int value = 0;
        if(handOne.getHighCard().compareTo(handTwo.getHighCard()) > 0)
        {
            value++;
        }
        else if(handOne.getHighCard().compareTo(handTwo.getHighCard()) < 0)
        {
            value--;
        }

        return value;
    }
    /*
     * This is a function that provides construction of the players 
     * hands for test cases. Instead of relying user input you just 
     * pass in string arguments that are later evaluated. Since we know
     * the pattern is as follows: "CardValue, CardSuit, whitespace" we can
     * parse the string using isWhitespace and storing the index to use 
     * to rebuild the substring each time until we have extracted all the 
     * values and suits from the passed in string.
     */
    public static Hand constructPlayerHand(String stringToParse)
    {
        char value = ' ';
        char suit = ' ';
        Stack<Card> cardsToAdd = new Stack<>();
        for(int i = 0; i < 5; i++)
        {
            int length = stringToParse.length();
            for(int j = 0; j < length; j++)
            {   
                if(Character.isWhitespace(stringToParse.charAt(j)))
                {
                    String temp = stringToParse.substring(0, j);
                    stringToParse = stringToParse.substring(j+1);
                    
                    value = temp.charAt(0);
                    suit = temp.charAt(1);
                    
                    break;
                }
                if(length == 2)
                {
                    value = stringToParse.charAt(0);
                    suit = stringToParse.charAt(1);
                }
            }
            Card.Value cardValue = null;
            switch (value) 
            {
                case '2':
                    cardValue = Card.Value.TWO;
                    break;
                case '3':
                    cardValue = Card.Value.THREE;
                    break;
                case '4':
                    cardValue = Card.Value.FOUR;
                    break;
                case '5':
                    cardValue = Card.Value.FIVE;
                    break;
                case '6':
                    cardValue = Card.Value.SIX;
                    break;
                case '7':
                    cardValue = Card.Value.SEVEN;
                    break;
                case '8':
                    cardValue = Card.Value.EIGHT;
                    break;
                case '9':
                    cardValue = Card.Value.NINE;
                    break;
                case 'T':
                    cardValue = Card.Value.TEN;
                    break;
                case 'J':
                    cardValue = Card.Value.JACK;
                    break;
                case 'Q':
                    cardValue = Card.Value.QUEEN;
                    break;
                case 'K':
                    cardValue = Card.Value.KING;
                    break;
                case 'A':
                    cardValue = Card.Value.ACE;
                    break;
                default:
                    break;   
            }
            Card.Suit cardSuit = null;
            switch (suit) 
            {
                case 'C':
                    cardSuit = Card.Suit.CLUBS;
                    break;
                case 'D':
                    cardSuit = Card.Suit.DIAMONDS;
                    break;
                case 'H':
                    cardSuit = Card.Suit.HEARTS;
                    break;
                case 'S':
                    cardSuit = Card.Suit.SPADES;
                    break;
                default:
                    break;
            }
            cardsToAdd.push(new Card(cardSuit, cardValue));
        }
        Hand hand = new Hand(cardsToAdd);

        return hand;
    }
}
