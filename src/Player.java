
public class Player 
{
    private boolean playerWon = false;
    private String team;
    private Hand hand;
    
    public Player(String team, Hand hand)
    {
        this.team = team;
        this.hand = hand;
    }

    public void setPlayerWon(boolean won)
    {
        this.playerWon = won;
    }

    public boolean getPlayerWon()
    {
        return this.playerWon;
    }
    public String getTeam()
    {
        return this.team;
    }
    public Hand getHand()
    {
        return this.hand;
    } 
    
    public void updateHand(Hand hand)
    {
        this.hand = hand;
    }
}
