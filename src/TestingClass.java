public class TestingClass {

    private String playerOneInput;
    private String playerTwoInput;

    public TestingClass(String inputOne, String inputTwo)
    {
        this.playerOneInput = inputOne;
        this.playerTwoInput = inputTwo;
        startTest(this.playerOneInput, this.playerTwoInput);
    }

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
