import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int playerWins = 0;
        int dealerWins = 0;

        boolean playAgain = true;

        while (playAgain) {

            Deck deck = new Deck();
            deck.shuffle();

            Hand player = new Hand();
            Hand dealer = new Hand();

            // Deal two cards to the player
            player.addCard(deck.draw());
            player.addCard(deck.draw());

            // Deal two cards to the dealer
            dealer.addCard(deck.draw());
            dealer.addCard(deck.draw());

            System.out.println("\n==============================");
            System.out.println("        BLACKJACK");
            System.out.println("==============================");

            // Player's cards
            System.out.println("\nYour cards:");

            for (int i = 0; i < player.size(); i++) {
                System.out.println("- " + player.getCard(i));
            }

            System.out.println("Your score: " + player.getPoints());

            // Dealer's first card is visible
            System.out.println("\nDealer shows:");
            System.out.println("- " + dealer.getCard(0));
            System.out.println("- [HIDDEN]");

            // Player turn
            boolean playerTurn = true;

            while (playerTurn) {

                if (player.getPoints() > 21) {
                    System.out.println("\nYou have busted!");
                    playerTurn = false;
                }
                else if (player.size() == 5) {
                    System.out.println("\nYou have 5 cards.");
                    System.out.println("You must stand.");
                    playerTurn = false;
                }
                else if (player.getPoints() >= 16) {

                    System.out.println("\nYour score is " + player.getPoints());
                    System.out.print("Do you want to (D)raw or (H)old? ");

                    String choice = scanner.nextLine().toUpperCase();

                    if (choice.equals("D")) {

                        Card drawnCard = deck.draw();
                        player.addCard(drawnCard);

                        System.out.println("\nYou drew: " + drawnCard);
                        System.out.println("Your score: " + player.getPoints());

                    } else if (choice.equals("H")) {

                        playerTurn = false;

                    } else {
                        System.out.println("Please enter D or H.");
                    }

                }
                else {

                    // Player must draw when score is below 16
                    Card drawnCard = deck.draw();
                    player.addCard(drawnCard);

                    System.out.println("\nYou drew: " + drawnCard);
                    System.out.println("Your score: " + player.getPoints());
                }
            }

            // If player hasn't busted, dealer plays
            if (!player.isBust()) {

                System.out.println("\n------------------------------");
                System.out.println("Dealer's turn");
                System.out.println("------------------------------");

                System.out.println("\nDealer's cards:");

                for (int i = 0; i < dealer.size(); i++) {
                    System.out.println("- " + dealer.getCard(i));
                }

                System.out.println("Dealer score: " + dealer.getPoints());

                // Dealer draws while score is below 17
                while (dealer.getPoints() < 17 && dealer.size() < 5) {

                    Card drawnCard = deck.draw();
                    dealer.addCard(drawnCard);

                    System.out.println("\nDealer draws: " + drawnCard);
                    System.out.println("Dealer score: " + dealer.getPoints());
                }

                if (dealer.getPoints() >= 17) {
                    System.out.println("\nDealer stands.");
                }
            }

            // Reveal dealer's hole card
            System.out.println("\n==============================");
            System.out.println("        FINAL HANDS");
            System.out.println("==============================");

            System.out.println("\nYour cards:");

            for (int i = 0; i < player.size(); i++) {
                System.out.println("- " + player.getCard(i));
            }

            System.out.println("Your score: " + player.getPoints());

            System.out.println("\nDealer's cards:");

            for (int i = 0; i < dealer.size(); i++) {
                System.out.println("- " + dealer.getCard(i));
            }

            System.out.println("Dealer score: " + dealer.getPoints());

            // Determine winner
            if (player.isBust()) {

                System.out.println("\nYou busted. Dealer wins!");
                dealerWins++;

            } else if (dealer.isBust()) {

                System.out.println("\nDealer busted. You win!");
                playerWins++;

            } else if (player.isBlackjack() && !dealer.isBlackjack()) {

                System.out.println("\nBLACKJACK! You win!");
                playerWins++;

            } else if (dealer.isBlackjack() && !player.isBlackjack()) {

                System.out.println("\nDealer has Blackjack. Dealer wins!");
                dealerWins++;

            } else if (player.getPoints() > dealer.getPoints()) {

                System.out.println("\nYou win!");
                playerWins++;

            } else if (dealer.getPoints() > player.getPoints()) {

                System.out.println("\nDealer wins!");
                dealerWins++;

            } else {

                System.out.println("\nIt's a draw!");
            }

            // Display overall score
            System.out.println("\n==============================");
            System.out.println("         SCOREBOARD");
            System.out.println("==============================");

            System.out.println("Player wins: " + playerWins);
            System.out.println("Dealer wins: " + dealerWins);

            // Ask if the player wants another game
            System.out.print("\nPlay again? (Y/N): ");

            String answer = scanner.nextLine().toUpperCase();

            if (!answer.equals("Y")) {
                playAgain = false;
            }
        }

        System.out.println("\n==============================");
        System.out.println("       FINAL SCORE");
        System.out.println("==============================");

        System.out.println("Player wins: " + playerWins);
        System.out.println("Dealer wins: " + dealerWins);

        if (playerWins > dealerWins) {
            System.out.println("Congratulations! You won more games.");
        } else if (dealerWins > playerWins) {
            System.out.println("The dealer won more games.");
        } else {
            System.out.println("The overall score is tied.");
        }

        System.out.println("\nThanks for playing!");

        scanner.close();
    }
}
