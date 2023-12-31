
public class Player 
{
    private int score = 0;
    private String team;
    private Hand hand;
    

    public Player(String team, Hand hand)
    {
        this.team = team;
        this.hand = hand;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public int getScore()
    {
        return this.score;
    }
    public String getTeam()
    {
        return this.team;
    }
    public Hand getHand()
    {
        return this.hand;
    }  
}
