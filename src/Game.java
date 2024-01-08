import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/*
 * Game Class: handles printing, scanning user input, keeping score, announcing winners,
 * quiting, and starting the game.
 */
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
    public void updateGameScores(int playerOneScore, int playerTwoScore)
    {
        this.scores[0] = playerOneScore;
        this.scores[1] = playerTwoScore;
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
     * The time complexity is O(n^2).
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
                constructdeck.push(new Card(cardSuits[i], cardValues[j]));
            }   
        }
        Collections.shuffle(constructdeck);
        System.out.println("\nThe Deck has been constructed and Shuffled.\n\n");

        return constructdeck;
    }

    /*
     * As stated above I chose the Stack data structure for its resemblance to deck of cards.
     * Draw 5 cards by popping of the top of the deck pushing into the players hand.
    */
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

    /*
     * This is a function that is called if the player wants to manually pick there 
     * cards (very time consuming... but an option). Provides text to explain how to pick the cards.
     * The prompt will continue to ask for cards until both teams (black & white) have drawn 5 cards each.
     * I chose to use a string containing numbers and a single character in which I parse through below based
     * on string length 2 or 3. Cards are removed from the deck as its drawn to avoid duplicate hands.
     */
    public static Hand pickCards(Stack<Card> deck)
    {
        Scanner scanner = new Scanner(System.in);
        Stack<Card> cardsDrawn = new Stack<>();
        int numCardsToDraw = 5;
        int count = 0;
        while(count < numCardsToDraw)
        {
            System.out.println( "Pick your card value: 2: TWO 3: THREE, 4: FOUR, 5: FIVE, 6: SIX, 7: SEVEN, 8: EIGHT, 9: NINE, " +
                "10: TEN, 11: JACK, 12: QUEEN, 13: KING, 14: ACE");
            System.out.println("Followed by your Suit: c: clubs, d: diamonds, h: hearts, s: spades");
            System.out.println("\nexample: 2c = TWO of CLUBS, 14d = ACE of DIAMONDS");
            System.out.println("Pick card #" + (1 + count));
            Card.Value cardValue = null;
            String card = scanner.nextLine();
            //error check
            while(card.length() < 2) 
            {
                if((card.length() < 2))
                {
                    System.out.println("Please enter a valid card.");
                    card = scanner.nextLine();
                }
            }
            int value = 0;
            char suit =' ';
            if(card.length() == 3)
            {
                value = Integer.parseInt(card.substring(0, 2));
                suit = card.charAt(card.length() - 1);
            }
            else if(card.length() == 2)
            {
                value = Character.getNumericValue(card.charAt(0));
                suit = card.charAt(1);
            }
         
            switch (value) 
            {
                case 2:
                    cardValue = Card.Value.TWO;
                    break;
                case 3:
                    cardValue = Card.Value.THREE;
                    break;
                case 4:
                    cardValue = Card.Value.FOUR;
                    break;
                case 5:
                    cardValue = Card.Value.FIVE;
                    break;
                case 6:
                    cardValue = Card.Value.SIX;
                    break;
                case 7:
                    cardValue = Card.Value.SEVEN;
                    break;
                case 8:
                    cardValue = Card.Value.EIGHT;
                    break;
                case 9:
                    cardValue = Card.Value.NINE;
                    break;
                case 10:
                    cardValue = Card.Value.TEN;
                    break;
                case 11:
                    cardValue = Card.Value.JACK;
                    break;
                case 12:
                    cardValue = Card.Value.QUEEN;
                    break;
                case 13:
                    cardValue = Card.Value.KING;
                    break;
                case 14:
                    cardValue = Card.Value.ACE;
                    break;
                default:
                    cardValue = null;
                     break;   
            }
            Card.Suit cardSuit = null;
            switch (suit) 
            {
                case 'c':
                    cardSuit = Card.Suit.CLUBS;
                    break;
                case 'd':
                    cardSuit = Card.Suit.DIAMONDS;
                    break;
                case 'h':
                    cardSuit = Card.Suit.HEARTS;
                    break;
                case 's':
                    cardSuit = Card.Suit.SPADES;
                    break;
                default:
                    break;
            }
            Card temp = new Card(cardSuit, cardValue);
            boolean foundCard = false;
            int indexToRemove = 0;
            for(int j = 0; j < deck.size() - 1 && !foundCard; j++)
            {
                if(deck.get(j).getValue() == temp.getValue() && deck.get(j).getSuit() == temp.getSuit())
                {
                    indexToRemove = j;
                    foundCard = true;  
                }      
            }
            if(foundCard)
            {
                System.out.println("\nyour chosen card is: " + temp.getValue() + "|" + temp.getSuit());
                cardsDrawn.push(deck.remove(indexToRemove));
                count++; 
            }
            else
            {
                System.out.println("Card already drawn! Pick again.");
            }
        }
        Hand hand = new Hand(cardsDrawn);
        
        return hand;
    }

    /*
     * Starts the game and prompts the user to see if they would like to play the game or not.
     * If the user enters y then the game loop begins. The user can then choose to draw randomly (suggested),
     * or by manual entry. The players are then created and assigned their team names and hands. The game
     * will then ask the user if they would like to see who wins (continue playing), and if so the winner
     * will be announced each round or until the user enters 'n' when asked to continue playing then the 
     * game loop ends. After that the initial loop will start to see if you want to either run test cases
     * or play again.
    */
    public static void startGame(Scanner scanner)
    {
    
        System.out.println("would you like to play a game of Poker? enter: 'y' for yes | 'n' for no");
        String answer = scanner.nextLine();
        Game pokerGame = new Game();
        pokerGame.setStartGame(answer.charAt(0) == 'y');
        
        while(pokerGame.getIsGameStart() && !pokerGame.getIsGameQuit())
        { 
            Stack <Card> deck = constructDeck(); 
            System.out.println("To pick or randomize your hands enter: 'r' (random entry) | 'm' (manual entry).");
            String drawType = scanner.nextLine();
            boolean isRandom = true;
            if(drawType.charAt(0) == 'm')
            {
                isRandom = false;
            }

            Player playerOne = createPlayers("Black", deck, isRandom);
            Player playerTwo = createPlayers("White", deck, isRandom);
            
            System.out.println("Would you like to see who wins? yes | no");
            boolean continuePlaying = scanner.nextLine().charAt(0) == 'y';

            pokerGame.playRound(pokerGame, playerOne, playerTwo, continuePlaying);

        }
        
    }

    /*
     * This starts the round for each hand played. See details above (StartGame function).
     */
    public void playRound(Game pokerGame, Player playerOne, Player playerTwo, boolean continuePlaying)
    {

        Hand playerOneHand = playerOne.getHand();
        Hand playerTwoHand = playerTwo.getHand();

        if(continuePlaying)
        {
            System.out.println();
            System.out.println(playerOne.getTeam()+ " has " + playerOneHand.getHandType());
            playerOneHand.displayHand();
            System.out.println();
            System.out.println(playerTwo.getTeam()+ " has " + playerTwoHand.getHandType());
            playerTwoHand.displayHand();
            System.out.println("\n");

            int result = HandAnalyzer.compareHands(playerOneHand, playerTwoHand);
            if(result > 0)
            {
                announceRoundWinner(playerOne);
                announceAndSetGameScores(playerOne, playerTwo, pokerGame);
            }
            else if(result < 0)
            {
                announceRoundWinner(playerTwo);
                announceAndSetGameScores(playerOne, playerTwo, pokerGame);
            }
            else
            {
                System.out.println("It's a tie.");
            }
        }
        else
        {
            announceAndSetGameScores(playerOne, playerTwo, pokerGame);
            pokerGame.setQuitGame(true);
            announceWinner(playerOne, playerTwo, pokerGame);
        }     
    }

    //Creates players by assigning the team, choosing hand type (random/manual), then returns player.
    public static Player createPlayers(String team, Stack<Card> deck, boolean isRandom)
    {
        Hand hand = null;
        if(isRandom)
        {
            hand = drawCards(deck);
        }
        else
        {
            System.out.println("\n" + team + ". Please choose your hand.");
            hand = pickCards(deck);
        }

        Player player  = new Player(team, hand);
        System.out.println(player.getTeam() + " drew the hand: " );
        player.getHand().displayHand();
        System.out.println();
        
        return player;
    }

    //Announces Round winner: (message is based on Hand Type). Lists team winner, hand type, and hand values.
    public static void announceRoundWinner(Player player)
    {
        Hand playerHand = player.getHand();
        switch (playerHand.getHandType()) 
        {
            case Hand.HandTypes.PAIR:
                System.out.println(player.getTeam() + " wins with " + playerHand.getHandType() +": "+ playerHand.getOnePairCard() + "(s)"
                + " with a " + playerHand.getHighCard() + " kicker.");
                break;
            case Hand.HandTypes.TWO_PAIR:
                System.out.println(player.getTeam() + " wins with " + playerHand.getHandType() +": "+ playerHand.getOnePairCard() + "(s) & "
                + playerHand.getTwoPairCard() + "(s) with a " + playerHand.getHighCard() + " kicker.");
                break;
            case Hand.HandTypes.THREE_OF_A_KIND:
                System.out.println(player.getTeam() + " wins with " + playerHand.getHandType() +": triple "+ playerHand.getThreeKindCard() + "(s).");
                break;
            case Hand.HandTypes.STRAIGHT:
                System.out.println(player.getTeam() + " wins with " + playerHand.getHandType() + " " + playerHand.getHighCard() + " high.");
                break;
            case Hand.HandTypes.FLUSH:
                System.out.println(player.getTeam() + " wins with " + playerHand.getHandType() + " " + playerHand.getHighCard() + " high.");
                break;
            case Hand.HandTypes.FULL_HOUSE:
                System.out.println(player.getTeam() + " wins with " + playerHand.getHandType() + " " + playerHand.getThreeKindCard() + " over "
                + playerHand.getOnePairCard());
                break;
            case Hand.HandTypes.FOUR_OF_A_KIND:
                System.out.println(player.getTeam() + " wins with " + playerHand.getHandType() +": quad "+ playerHand.getFourKindCard() + "(s).");
                break;
            case Hand.HandTypes.STRAIGHT_FLUSH:
                System.out.println(player.getTeam() + " wins with " + playerHand.getHandType() +" " + playerHand.getHighCard() + " high.");
                break;
            default:
                System.out.println(player.getTeam() + " wins with " + playerHand.getHandType() +": "+ playerHand.getHighCard());
                break;
        }
        player.setPlayerWon(true);

    }

    //Just announces the actual winner if the game is quit/thanks for playing
    public static void announceWinner(Player playerOne, Player playerTwo, Game game)
    {
        System.out.println();
        if(game.getScores()[0] > game.getScores()[1])
        {
            System.out.println(playerOne.getTeam() + " Wins!!");
        }
        else if(game.getScores()[0] < game.getScores()[1])
        {
            System.out.println(playerTwo.getTeam() + " Wins!!");
        }
        else
        {
             System.out.println("Nobody wins its a Tie!!");
        }

        System.out.println("Thanks for playing.");
    }

    //Updates the current score and prints the message to the user after each round won/lost.
    public static void announceAndSetGameScores(Player playerOne, Player playerTwo, Game game)
    {
        int playerOneScore = game.getScores()[0];
        int playerTwoScore = game.getScores()[1];
        if(playerOne.getPlayerWon())
        {
            playerOneScore++;
            game.updateGameScores(playerOneScore, playerTwoScore);
        }
        else if(playerTwo.getPlayerWon())
        {   
            playerTwoScore++;
            game.updateGameScores(playerOneScore, playerTwoScore);
        }

        System.out.println("\nThe current score is: " + playerOne.getTeam() + ": " + game.getScores()[0]
        + "    |    " + playerTwo.getTeam() + ": " + game.getScores()[1]);
    }
}
