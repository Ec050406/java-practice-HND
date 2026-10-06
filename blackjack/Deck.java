import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards;
    private int drawCounter;

    public Deck() {
        cards = new ArrayList<>();
        drawCounter = 0;

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {
                "2", "3", "4", "5", "6", "7", "8", "9",
                "10", "Jack", "Queen", "King", "Ace"
        };

        for (String suit : suits) {
            for (String rank : ranks) {

                int points;

                if (rank.equals("Jack") ||
                    rank.equals("Queen") ||
                    rank.equals("King")) {
                    points = 10;
                } else if (rank.equals("Ace")) {
                    points = 11;
                } else {
                    points = Integer.parseInt(rank);
                }

                cards.add(new Card(rank, suit, points));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        drawCounter = 0;
    }

    public Card draw() {

        if (drawCounter >= cards.size()) {
            return null;
        }

        Card card = cards.get(drawCounter);
        drawCounter++;

        return card;
    }

    public int cardsRemaining() {
        return cards.size() - drawCounter;
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
