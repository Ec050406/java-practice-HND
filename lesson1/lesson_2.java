import java.util.Scanner;
//19-sept ewan coulter
// This program collects and displays details for a specified number of people.
public class lesson_2 {
    // The main method where the program execution begins.
    public static void main(String[] args) {
        // Ask the user how many people's details they want to enter.
        int amount = Integer.parseInt(ask("How many people do you want to enter details for?"));
        // Create arrays to store the names, numbers, and companies of the specified number of people.
        String[] name = new String[amount];
        String[] number = new String[amount];
        String[] company = new String[amount];
       //
        for (int i = 0; i < amount; i++) {
            System.out.println("Enter details for person " + (i + 1) + ":");
            name[i] = ask("What is your name?");
            number[i] = ask("What is your number?");
            company[i] = ask("What is your company?");
        }
        // After collecting the details, allow the user to view the details of a specific person by entering their number.
        int choice = -1;
        // Continue to prompt the user until they choose to exit by entering 0.
        while(choice != 0){
        // Ask the user to enter the number of the person whose details they want to view.
        choice = Integer.parseInt(ask("Enter the number of the person whose details you want to view (1-" + amount + "):"));
        // Loop through the arrays to find and display the details of the selected person.
            for (int i = 0; i < amount; i++) {
                if (choice == (i + 1)) {
                    System.out.println("-------------------------------");
                    System.out.println("Details for person " + choice + ":");
                    System.out.println("Name--------------:" + name[i]);
                    System.out.println("Number------------:" + number[i]);
                    System.out.println("Company-----------:" + company[i]);
                    System.out.println("-------------------------------");
                }
            }
            // If the user enters a number outside the valid range, display an error message.
            if (choice < 1 || choice > amount) 
            {
                System.out.println("Invalid choice. Please enter a number between 1 and " + amount + ".");
            } 
            // If the user enters 0, exit the program.
            if (choice == 0) 
            {
                System.out.println("Exiting the program.");
                break;
            }
        }
        }
    // This method prompts the user with a question and returns their input as a string.
    private static String ask(String question) {
        Scanner input = new Scanner(System.in);
        System.out.println(question);
        return input.nextLine();
    }

}