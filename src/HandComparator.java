
public class HandComparator {
    
    public HandComparator()
    {

    }

    public static int compareHands(Hand handOne, Hand handTwo)
    {

        int value = (handOne.getHandType()).compareTo(handTwo.getHandType());
        if(value == 0)
        {
            switch (handOne.getHandType()) {
                case Hand.HandTypes.HIGH_CARD:
                    value = getBestHighCardHand(handOne, handTwo);
                    
                    break;
            
                default:
                    break;
            }
            
        }


        return value;
    }

    public static int getBestHighCardHand(Hand handOne, Hand handTwo)
    {
        int value = 0;
        
        Card.Value[] handOneValues = handOne.getHandValues();
        Card.Value[] handTwoValues = handTwo.getHandValues();
        boolean foundHighCard = false;

        for (int i = handOneValues.length; i < 0 && !foundHighCard; i++)
        {
            if(handOneValues[i].compareTo(handTwoValues[i]) > 0)
            {
                value++;
                foundHighCard = true;
            }
            else if(handOneValues[i].compareTo(handTwoValues[i]) < 0)
            {
                value--;
                foundHighCard = true;
            }

        }
       
        // else if(!handOneValues.contains("A") && handTwoValues.contains("A"))
        // {
        //     value--;
        //     foundHighCard = true;
        // }
        // else if(handOneValues.contains("K") && !handTwoValues.contains("K") && !foundHighCard)
        // {
        //     value++;
        //     foundHighCard = true;
        // }
        // else if(!handOneValues.contains("K") && handTwoValues.contains("K") && !foundHighCard)
        // {
        //     value--;
        //     foundHighCard = true;
        // }
        // else if(handOneValues.contains("Q") && !handTwoValues.contains("Q") && !foundHighCard)
        // {
        //     value++;
        //     foundHighCard = true;
        // }
        // else if(!handOneValues.contains("Q") && handTwoValues.contains("Q") && !foundHighCard)
        // {
        //     value--;
        //     foundHighCard = true;
        // }
        // else if(handOneValues.contains("J") && !handTwoValues.contains("J") && !foundHighCard)
        // {
        //     value++;
        //     foundHighCard = true;
        // }
        // else if(!handOneValues.contains("J") && handTwoValues.contains("J") && !foundHighCard)
        // {
        //     value--;
        //     foundHighCard = true;
        // }
        // else if(handOneValues.contains("T") && !handTwoValues.contains("T") && !foundHighCard)
        // {
        //     value++;
        //     foundHighCard = true;
        // }
        // else if(!handOneValues.contains("T") && handTwoValues.contains("T") && !foundHighCard)
        // {
        //     value--;
        //     foundHighCard = true;
        // }
        

        
        return value;
    }

    
}
