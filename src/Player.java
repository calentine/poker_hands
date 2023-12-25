
public class Player 
{
    private boolean won = false;
    private String team;
    private Hand hand;
    

    public Player(String team, Hand hand)
    {
        this.team = team;
        this.hand = hand;
    }

    public boolean getHasWon()
    {
        return this.won;
    }
    public String getTeam()
    {
        return this.team;
    }
    public Hand getHand()
    {
        return this.hand;
    }

    public void setHasWon(boolean didWin)
    {
        this.won = didWin;
    }
  
}
