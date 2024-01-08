/*
 * Player Class is defined by name, hand, and if they have won.
 * By design I believe that every player has a team name, hand, and
 * a boolean to declare a winner during a round (if playing game mode version).
 */
public class Player 
{
    private boolean playerWon = false;
    private String team;
    private Hand hand;
    
    //Constructor defines the players team name and hand (stack (data structure) of cards)
    public Player(String team, Hand hand)
    {
        this.team = team;
        this.hand = hand;
    }

    //setter
    public void setPlayerWon(boolean won)
    {
        this.playerWon = won;
    }

    //getters
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

}
