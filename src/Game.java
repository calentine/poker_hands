import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Game {

    private boolean startGame = false;
    private boolean quitgame = false;
    private int[] scores = {0, 0};
    
    //Default constructor, no need to pass values because defaults are already set
    public Game()
    {
        //If need modification create another constructor with parameters
    }

    //getters
    public boolean getIsGameStart()
    {
        return startGame;
    }
    public boolean getIsGameQuit()
    {
        return quitgame;
    }
    public int[] getScores()
    {
        return scores;
    }

    //setters
    public void setScores(int[] scores)
    {
        this.scores = scores;
    }

    public void setStartGame(boolean start)
    {
        this.startGame = start;
    }

    public void setQuitGame(boolean quit)
    {
        this.quitgame = quit;
    }

     /*
     * This constructs the deck by utilizing a Stack that stores the type Card
     * The outerloop is used to build the deck based on the number of cardSuits: 4
     * The inner loop is used to add all the possible cardValues: 13
     * After loops have completed I use the built in method for Stacks:(shuffle)
     * using Java Collections. This is to simulate an actual deck of Cards,
     * which is also why I chose the Stack as well to simulate picking up a card
     * from the top of the deck
     * The time complexity is O(n^2)
     */
    public static Stack<Card> constructDeck()
    {
        Card.Suit[] cardSuits = Card.Suit.values();
        Card.Value[] cardValues = Card.Value.values();
        
        Stack<Card> constructdeck = new Stack<>();


        for(int i = 0; i < cardSuits.length; i++)
        {
            for(int j = 0; j < cardValues.length; j++)
            {
                
                if(cardSuits[i] == Card.Suit.CLUBS)
                {
                    constructdeck.push(new Card(cardSuits[0], cardValues[j]));
                }
                else if(cardSuits[i] == Card.Suit.DIAMONDS)
                {
                    constructdeck.push(new Card(cardSuits[1],  cardValues[j]));
                }
                    
                else if(cardSuits[i] == Card.Suit.HEARTS)
                {
                    constructdeck.push(new Card(cardSuits[2],  cardValues[j]));
                }
                else
                {
                    constructdeck.push(new Card(cardSuits[i],  cardValues[j]));
                }
                
            }   
        }
        Collections.shuffle(constructdeck);
        // for(Card a : constructdeck){
        //     System.out.println(a.getValue() + " " + a.getSuit());
        // }

        System.out.println("\nThe Deck has been constructed and Shuffled.\n\n");
        return constructdeck;
    }

    public static Hand drawCards(Stack<Card> deck)
    {
        Stack<Card> cardsDrawn = new Stack<>();
        int numCardsToDraw = 5;
        for(int i= 0; i < numCardsToDraw; i++)
        {
            cardsDrawn.push(deck.pop());
        }
        Hand hand = new Hand(cardsDrawn);

        return hand;
    }

    public static void startGame()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("would you like to play a game of Poker? yes | no");
        String answer = scanner.nextLine();
        
        Game pokergame = new Game();
        pokergame.setStartGame(answer.charAt(0) == 'y');
        
        while(pokergame.getIsGameStart() && !pokergame.getIsGameQuit())
        { 
            Stack <Card> deck = constructDeck(); 
            
            Player plrOne = createPlayers("White", deck);
            Player plrTwo = createPlayers("Black", deck);
            Hand plrOneHand = plrOne.getHand();
            Hand plrTwoHand = plrTwo.getHand();

            System.out.println("Would you like to see who wins? yes | no");
            if(scanner.nextLine().charAt(0) == 'y')
            {
                System.out.println();
                System.out.println("Team "+plrOne.getTeam()+ " has " + plrOneHand.getHandType());
                 plrOneHand.displayHand();
                System.out.println();
                System.out.println("Team "+plrTwo.getTeam()+ " has " + plrTwoHand.getHandType());
                plrTwoHand.displayHand();
                System.out.println("\n");

                int result = HandComparator.compareHands(plrOneHand, plrTwoHand);
                if(result > 0)
                {
                    System.out.println(plrOne.getTeam() + " team wins with " + plrOneHand.getHandType() +": "+ plrOneHand.getHighCard());
                }
                else if(result < 0)
                {
                    System.out.println(plrTwo.getTeam() + " team wins with " + plrTwoHand.getHandType() +": "+  plrTwoHand.getHighCard());
                }
                else
                {
                    System.out.println("It's either a tie or one has a larger value than the other");
                }
            }
            else
            {
                pokergame.setQuitGame(true);
            } 
        }
       
        System.out.println("Thanks for playing.");
    
        scanner.close();
    }

    public static Player createPlayers(String team, Stack<Card> deck)
    {
        Player player  = new Player(team, drawCards(deck));
        System.out.println("Team: " + player.getTeam() + " drew the hand: " );
        player.getHand().displayHand();
        System.out.println();
        
        return player;
    }
}
