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
     * The outerloop is used to build the deck based on the number of suits: 4
     * The inner loop is used to add all the possible values: 13
     * After loops have completed I use the built in method for Stacks:(shuffle)
     * using Java Collections. This is to simulate an actual deck of Cards,
     * which is also why I chose the Stack as well to simulate picking up a card
     * from the top of the deck
     * The time complexity is O(n^2)
     */
    public static Stack<Card> constructDeck()
    {
        String suits = "CDHS";
        String values = "23456789TJQKA";
        Stack <Card> constructdeck = new Stack<>();


        for(int i = 0; i < suits.length(); i++)
        {
            for(int j = 0; j < values.length(); j++)
            {
                
                if(suits.charAt(i) == 'C')
                {
                        constructdeck.push(new Card(suits.charAt(0), values.charAt(j)));
                }
                else if(suits.charAt(i) == 'D')
                {
                    constructdeck.push(new Card(suits.charAt(1), values.charAt(j)));
                }
                    
                else if(suits.charAt(i) == 'H')
                {
                    constructdeck.push(new Card(suits.charAt(2), values.charAt(j)));
                }
                else
                {
                    constructdeck.push(new Card(suits.charAt(3), values.charAt(j)));
                }
                
            }   
        }
        Collections.shuffle(constructdeck);

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

        System.out.println("would you like to play a game of Poker? y(yes) | n(no)");
        String answer = scanner.nextLine();

        Game pokergame = new Game();
        pokergame.setStartGame(answer.charAt(0) == 'y');
        
        while(pokergame.getIsGameStart() && !pokergame.getIsGameQuit())
        { 
            Stack <Card> deck = constructDeck(); 
            System.out.println("\nThe Deck has been constructed and Shuffled.");
            
            Player one = createPlayers("White", deck);
            Player two = createPlayers("Black", deck);

            System.out.println("Would you like to see who wins? y(yes) | n(no)");
            if(scanner.nextLine().charAt(0) == 'y')
            {
                
                
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
        System.out.println("\n");
        
        return player;
    }
}
