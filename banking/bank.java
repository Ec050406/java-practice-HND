
// Bank class for managing bank accounts
import java.util.ArrayList;
import java.util.Scanner;
// defines the bank class which contains the main method and methods for adding accounts and asking user input
public class bank {
    // Scanner for user input
    private static final Scanner input = new Scanner(System.in);
    // Main method to run the bank account management system
    public static void main(String[] args) {
        // Create an ArrayList to store accounts
        ArrayList<account> accounts = new ArrayList<>();
        //welcome message and prompt to add an account
        System.out.println("Welcome to the bank account management system.");
        // Prompt the user to add an account
        if (ask("Would you like to add an account? (yes/no)")
                .equalsIgnoreCase("yes")) {
            addAccount(accounts);
        }
        // Display the details of the accounts added
        for (account currentAccount : accounts) {
            currentAccount.displayAccountDetails();
        }
        // Prompt the user to deposit or withdraw from an account if there are any accounts
        if (!accounts.isEmpty()) {
            String choice = ask("Would you like to deposit or withdraw? (yes/no)");
            // Loop to allow multiple transactions until the user chooses to stop
            while (choice.equalsIgnoreCase("yes")) {
                double accountNumber = Double.parseDouble(
                        ask("Enter the account number to modify:"));
                boolean accountFound = false;
                // Loop through the accounts to find the one with the specified account number
                for (account currentAccount : accounts) {
                    if (currentAccount.getAccountNumber() == accountNumber) {
                        accountFound = true;
                        String action = ask("Deposit or withdraw? (deposit/withdraw)");
                        double amount = Double.parseDouble(ask("Enter the amount:"));
                        // Perform the deposit or withdrawal based on user input
                        if (action.equalsIgnoreCase("deposit")) {
                            currentAccount.deposit(amount);
                          // Display the updated account details after the transaction  
                        } else if (action.equalsIgnoreCase("withdraw")) {
                            currentAccount.withdraw(amount);
                            // Display the updated account details after the transaction
                        } else {
                            System.out.println("Invalid action.");
                        }
                        // Display the updated account details after the transaction
                        currentAccount.displayAccountDetails();
                        break;
                    }
                }
                // If the account was not found, inform the user
                if (!accountFound) {
                    System.out.println("Account not found.");
                }

                choice = ask("Would you like to make another transaction? (yes/no)");
            }
        }
    }

    private static void addAccount(ArrayList<account> accounts) {
        int accountCount = 0;
        // Loop to allow the user to add multiple accounts until they choose to stop
        while (true) {
            accounts.add(new account(
                    ask("Enter account name for account " + (accountCount + 1)),
                    Double.parseDouble(ask("Enter account number for account " + (accountCount + 1))),
                    Double.parseDouble(ask("Enter account balance for account " + (accountCount + 1)))));

            accountCount++;
            if (!ask("Do you want to add another account? (yes/no)")
                    .equalsIgnoreCase("yes")) {
                break;
            }
        }
    }
    // This method prompts the user with a question and returns their input as a string.
    private static String ask(String question) {
        System.out.println(question);
        return input.nextLine();
    }
}  