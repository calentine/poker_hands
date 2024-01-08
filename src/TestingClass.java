/*
 * Testing Class utilized to run every test by passing 2 string arguments(playerOneInput & playerTwoInput)
 * This Class only contains 2 member variables which are initialized in the constructor.
 */
public class TestingClass {

    private String playerOneInput;
    private String playerTwoInput;

    // Constructor defines the input for each player and then calls the start test. 
    public TestingClass(String inputOne, String inputTwo)
    {
        this.playerOneInput = inputOne;
        this.playerTwoInput = inputTwo;
        startTest(this.playerOneInput, this.playerTwoInput);
    }

    /*
     * First is the assignment of the teams, since we know there is
     * only black and white there is no need to declare it in the 
     * player input parameters below. We then create the hands by
     * calling the HandAnalyzer utility class to convert the strings 
     * passed into actual hands that can be compared to declare a winner.
     * The hand analyzer utility class then returns an integer and based on 
     * the value we declare playerOne/playerTwo as the winner, or a tie using
     * the Game Class.
     */
    public void startTest(String playerOneInput, String playerTwoInput)
    {
        String teamOne = "Black";
        String teamTwo =  "White";
        
        System.out.println("\nInput: ");
        System.out.println(teamOne + ": " + playerOneInput + "  " + teamTwo + ": " +playerTwoInput);
        
        Hand handOne = HandAnalyzer.constructPlayerHand(playerOneInput);
        Hand handTwo = HandAnalyzer.constructPlayerHand(playerTwoInput);
       
        Player playerOne = new Player(teamOne, handOne);
        Player playerTwo = new Player(teamTwo, handTwo);

        int result = HandAnalyzer.compareHands(playerOne.getHand(), playerTwo.getHand());
        System.out.println();
        if(result > 0)
        {
            Game.announceRoundWinner(playerOne);        
        }
        else if(result < 0)
        {
            Game.announceRoundWinner(playerTwo);
        }
        else
        {
            System.out.println("It's a tie.");
        }
    }
    
}
