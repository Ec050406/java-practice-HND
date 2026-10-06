import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        if (card != null && cards.size() < 5) {
            cards.add(card);
        }
    }

    public int getPoints() {

        int total = 0;
        int aces = 0;

        for (Card card : cards) {
            total += card.getPoints();

            if (card.getRank().equals("Ace")) {
                aces++;
            }
        }

        // Change an Ace from 11 to 1 if necessary
        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }

        return total;
    }

    public int size() {
        return cards.size();
    }

    public Card getCard(int index) {
        return cards.get(index);
    }

    public boolean isBust() {
        return getPoints() > 21;
    }

    public boolean isBlackjack() {
        return cards.size() == 2 && getPoints() == 21;
    }

    public boolean hasAceWithTenOrCourtCard() {

        boolean ace = false;
        boolean tenOrCourt = false;

        for (Card card : cards) {

            if (card.getRank().equals("Ace")) {
                ace = true;
            }

            if (card.getRank().equals("10") ||
                card.getRank().equals("Jack") ||
                card.getRank().equals("Queen") ||
                card.getRank().equals("King")) {

                tenOrCourt = true;
            }
        }

        return ace && tenOrCourt;
    }

    /*
     * Displays all cards side-by-side.
     */
    public void displayCards() {

        if (cards.isEmpty()) {
            return;
        }

        // Top of cards
        for (int i = 0; i < cards.size(); i++) {
            System.out.print("+---------+  ");
        }
        System.out.println();

        // Top rank
        for (Card card : cards) {
            String rank = getShortRank(card.getRank());
            System.out.printf("| %-2s      |  ", rank);
        }
        System.out.println();

        // Blank
        for (int i = 0; i < cards.size(); i++) {
            System.out.print("|         |  ");
        }
        System.out.println();

        // Suit
        for (Card card : cards) {
            String suit = getSuitSymbol(card.getSuit());
            System.out.print("|    " + suit + "    |  ");
        }
        System.out.println();

        // Blank
        for (int i = 0; i < cards.size(); i++) {
            System.out.print("|         |  ");
        }
        System.out.println();

        // Bottom rank
        for (Card card : cards) {
            String rank = getShortRank(card.getRank());
            System.out.printf("|      %-2s |  ", rank);
        }
        System.out.println();

        // Bottom of cards
        for (int i = 0; i < cards.size(); i++) {
            System.out.print("+---------+  ");
        }
        System.out.println();
    }

    /*
     * Displays the dealer's hand with the second card hidden.
     */
    public void displayDealerCardsHidden() {

        if (cards.isEmpty()) {
            return;
        }

        // Top
        for (int i = 0; i < cards.size(); i++) {
            System.out.print("+---------+  ");
        }
        System.out.println();

        // Top row
        System.out.print(String.format("| %-2s      |  ",
                getShortRank(cards.get(0).getRank())));

        for (int i = 1; i < cards.size(); i++) {
            System.out.print("|#########|  ");
        }
        System.out.println();

        // Blank
        System.out.print("|         |  ");

        for (int i = 1; i < cards.size(); i++) {
            System.out.print("|#########|  ");
        }
        System.out.println();

        // Suit
        System.out.print("|    " +
                getSuitSymbol(cards.get(0).getSuit()) +
                "    |  ");

        for (int i = 1; i < cards.size(); i++) {
            System.out.print("|#########|  ");
        }
        System.out.println();

        // Blank
        System.out.print("|         |  ");

        for (int i = 1; i < cards.size(); i++) {
            System.out.print("|#########|  ");
        }
        System.out.println();

        // Bottom
        System.out.print(String.format("|      %-2s |  ",
                getShortRank(cards.get(0).getRank())));

        for (int i = 1; i < cards.size(); i++) {
            System.out.print("|#########|  ");
        }
        System.out.println();

        // Bottom border
        for (int i = 0; i < cards.size(); i++) {
            System.out.print("+---------+  ");
        }
        System.out.println();
    }

    private String getShortRank(String rank) {

        switch (rank) {
            case "Ace":
                return "A";
            case "Jack":
                return "J";
            case "Queen":
                return "Q";
            case "King":
                return "K";
            default:
                return rank;
        }
    }

    private String getSuitSymbol(String suit) {

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

    @Override
    public String toString() {
        String result = "";

        for (Card card : cards) {
            result += card + "\n";
        }

        return result;
    }
}
