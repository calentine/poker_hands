/*
 * Class CardAsciiArt: utility class used to print cards in place of numbers followed by a character
 * or just a string of words separted by spaces or '|'.
 */
public class CardAsciiArt {

    public static String getCardAsciiArt(Card card) {
        String[] lines = new String[5];
        lines[0] = "+------+";
        lines[1] = String.format("|%s     |", getValueString(card.getValue()));
        lines[2] = "|  " + getSuitSymbol(card.getSuit()) + "   |";
        lines[3] = String.format("|     %s|", getValueString(card.getValue()));
        lines[4] = "+------+";

        return String.join("\n", lines);
    }

    public static String getValueString(Card.Value value) {
        switch (value) {
            case TWO: return "2";
            case THREE: return "3";
            case FOUR: return "4";
            case FIVE: return "5";
            case SIX: return "6";
            case SEVEN: return "7";
            case EIGHT: return "8";
            case NINE: return "9";
            case TEN: return "T";
            case JACK: return "J";
            case QUEEN: return "Q";
            case KING: return "K";
            case ACE: return "A";
            default: return "";
        }
    }

    public static String getSuitSymbol(Card.Suit suit) {
        switch (suit) {
            case CLUBS: return "\u0005"; 
            case DIAMONDS: return "\u0004";
            case HEARTS: return "\u0003"; 
            case SPADES: return "\u0006"; 
            default: return "";
        }
    }
}