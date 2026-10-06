import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        if (cards.size() < 5) {
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

        // Change Aces from 11 to 1 if the hand would bust
        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }

        return total;
    }

    public boolean hasAceWithTenOrCourtCard() {

        boolean hasAce = false;
        boolean hasTenOrCourt = false;

        for (Card card : cards) {

            if (card.getRank().equals("Ace")) {
                hasAce = true;
            }

            if (card.getRank().equals("10") ||
                card.getRank().equals("Jack") ||
                card.getRank().equals("Queen") ||
                card.getRank().equals("King")) {
                hasTenOrCourt = true;
            }
        }

        return hasAce && hasTenOrCourt;
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

    @Override
    public String toString() {

        String result = "";

        for (Card card : cards) {
            result += card + "\n";
        }

        return result;
    }
}
