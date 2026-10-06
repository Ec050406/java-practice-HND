public class Card {

    private String rank;
    private String suit;
    private int points;

    public Card(String rank, String suit, int points) {
        this.rank = rank;
        this.suit = suit;
        this.points = points;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {

        String r = getShortRank();
        String s = getSuitSymbol();

        return
            "+---------+\n" +
            String.format("| %-2s      |\n", r) +
            "|         |\n" +
            "|    " + s + "    |\n" +
            "|         |\n" +
            String.format("|      %-2s |\n", r) +
            "+---------+";
    }

    private String getShortRank() {

        switch (rank) {
            case "Jack":
                return "J";
            case "Queen":
                return "Q";
            case "King":
                return "K";
            case "Ace":
                return "A";
            default:
                return rank;
        }
    }

    private String getSuitSymbol() {

        switch (suit) {
            case "Hearts":
                return "H";
            case "Diamonds":
                return "D";
            case "Clubs":
                return "C";
            case "Spades":
                return "S";
            default:
                return "?";
        }
    }
}
