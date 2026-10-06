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

            // ==========================================
            // DEAL INITIAL CARDS
            // ==========================================

            player.addCard(deck.draw());
            player.addCard(deck.draw());

            dealer.addCard(deck.draw());
            dealer.addCard(deck.draw());

            System.out.println();
            System.out.println("==============================");
            System.out.println("          BLACKJACK");
            System.out.println("==============================");

            // ==========================================
            // PLAYER'S INITIAL HAND
            // ==========================================

            System.out.println();
            System.out.println("Your cards:");

            player.displayCards();

            System.out.println();
            System.out.println("Your score: " + player.getPoints());

            // ==========================================
            // DEALER'S INITIAL HAND
            // ==========================================

            System.out.println();
            System.out.println("Dealer's cards:");

            dealer.displayDealerCardsHidden();

            System.out.println();
            System.out.println("Dealer's visible score: "
                    + dealer.getCard(0).getPoints());

            // ==========================================
            // CHECK INITIAL BLACKJACKS
            // ==========================================

            if (player.isBlackjack()) {

                System.out.println();
                System.out.println("BLACKJACK!");

                if (dealer.isBlackjack()) {
                    System.out.println("Dealer also has Blackjack.");
                    System.out.println("It's a draw!");
                } else {
                    System.out.println("You win!");
                    playerWins++;
                }

            } else {

                // ==========================================
                // PLAYER TURN
                // ==========================================

                boolean playerTurn = true;

                while (playerTurn) {

                    if (player.isBust()) {

                        System.out.println();
                        System.out.println("You busted!");
                        playerTurn = false;

                    } else if (player.size() == 5) {

                        System.out.println();
                        System.out.println("You have 5 cards.");
                        System.out.println("You must stand.");

                        playerTurn = false;

                    } else if (player.getPoints() < 16) {

                        // Player must draw below 16

                        System.out.println();
                        System.out.println(
                                "Your score is below 16, so you must draw."
                        );

                        Card drawnCard = deck.draw();

                        player.addCard(drawnCard);

                        System.out.println();
                        System.out.println("You drew:");

                        player.displayCards();

                        System.out.println();
                        System.out.println(
                                "Your score: " + player.getPoints()
                        );

                    } else {

                        // Player can choose to draw or hold

                        System.out.println();
                        System.out.println(
                                "Would you like to Draw or Hold?"
                        );
                        System.out.println("D = Draw");
                        System.out.println("H = Hold");

                        System.out.print("Choice: ");

                        String choice =
                                scanner.nextLine().trim().toUpperCase();

                        if (choice.equals("D")) {

                            Card drawnCard = deck.draw();

                            player.addCard(drawnCard);

                            System.out.println();
                            System.out.println("You drew:");

                            player.displayCards();

                            System.out.println();
                            System.out.println(
                                    "Your score: " + player.getPoints()
                            );

                        } else if (choice.equals("H")) {

                            System.out.println();
                            System.out.println("You hold.");

                            playerTurn = false;

                        } else {

                            System.out.println();
                            System.out.println(
                                    "Invalid choice. Please enter D or H."
                            );
                        }
                    }
                }

                // ==========================================
                // DEALER TURN
                // ==========================================

                if (!player.isBust()) {

                    System.out.println();
                    System.out.println("==============================");
                    System.out.println("        DEALER'S TURN");
                    System.out.println("==============================");

                    // Reveal the hole card

                    System.out.println();
                    System.out.println("Dealer reveals the hole card:");

                    dealer.displayCards();

                    System.out.println();
                    System.out.println(
                            "Dealer score: " + dealer.getPoints()
                    );

                    // Dealer draws until 17 or more

                    while (dealer.getPoints() < 17 &&
                           dealer.size() < 5) {

                        Card drawnCard = deck.draw();

                        dealer.addCard(drawnCard);

                        System.out.println();
                        System.out.println("Dealer draws:");

                        dealer.displayCards();

                        System.out.println();
                        System.out.println(
                                "Dealer score: " + dealer.getPoints()
                        );
                    }

                    if (dealer.getPoints() >= 17) {

                        System.out.println();
                        System.out.println("Dealer stands.");

                    } else if (dealer.size() == 5) {

                        System.out.println();
                        System.out.println(
                                "Dealer has reached 5 cards."
                        );
                    }
                }

                // ==========================================
                // FINAL RESULT
                // ==========================================

                System.out.println();
                System.out.println("==============================");
                System.out.println("         FINAL HANDS");
                System.out.println("==============================");

                System.out.println();
                System.out.println("Your cards:");

                player.displayCards();

                System.out.println();
                System.out.println(
                        "Your score: " + player.getPoints()
                );

                System.out.println();
                System.out.println("Dealer's cards:");

                dealer.displayCards();

                System.out.println();
                System.out.println(
                        "Dealer score: " + dealer.getPoints()
                );

                // ==========================================
                // DETERMINE WINNER
                // ==========================================

                if (player.isBust()) {

                    System.out.println();
                    System.out.println("You busted.");
                    System.out.println("Dealer wins!");

                    dealerWins++;

                } else if (dealer.isBust()) {

                    System.out.println();
                    System.out.println("Dealer busted.");
                    System.out.println("You win!");

                    playerWins++;

                } else if (player.isBlackjack()
                        && !dealer.isBlackjack()) {

                    System.out.println();
                    System.out.println("BLACKJACK!");
                    System.out.println("You win!");

                    playerWins++;

                } else if (dealer.isBlackjack()
                        && !player.isBlackjack()) {

                    System.out.println();
                    System.out.println("Dealer has Blackjack.");
                    System.out.println("Dealer wins!");

                    dealerWins++;

                } else if (player.getPoints() > dealer.getPoints()) {

                    System.out.println();
                    System.out.println("You win!");

                    playerWins++;

                } else if (dealer.getPoints() > player.getPoints()) {

                    System.out.println();
                    System.out.println("Dealer wins!");

                    dealerWins++;

                } else {

                    System.out.println();
                    System.out.println("It's a draw!");
                }
            }

            // ==========================================
            // SCOREBOARD
            // ==========================================

            System.out.println();
            System.out.println("==============================");
            System.out.println("         SCOREBOARD");
            System.out.println("==============================");

            System.out.println("Player wins: " + playerWins);
            System.out.println("Dealer wins: " + dealerWins);

            // ==========================================
            // PLAY AGAIN?
            // ==========================================

            System.out.println();
            System.out.print("Play again? (Y/N): ");

            String answer =
                    scanner.nextLine().trim().toUpperCase();

            if (!answer.equals("Y")) {
                playAgain = false;
            }
        }

        // ==========================================
        // FINAL SCORE
        // ==========================================

        System.out.println();
        System.out.println("==============================");
        System.out.println("        FINAL SCORE");
        System.out.println("==============================");

        System.out.println("Player wins: " + playerWins);
        System.out.println("Dealer wins: " + dealerWins);

        if (playerWins > dealerWins) {

            System.out.println("You won the most games!");

        } else if (dealerWins > playerWins) {

            System.out.println("The dealer won the most games!");

        } else {

            System.out.println("The overall score is tied!");
        }

        System.out.println();
        System.out.println("Thanks for playing!");

        scanner.close();
    }
}
