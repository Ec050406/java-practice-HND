// This is a simple number guessing game where the user has to guess a randomly generated number between 1 and 100. The program will give feedback on whether the guess is too high or too low, and it will keep track of the number of wrong guesses made by the user. 
import java.util.Random;
import java.util.Scanner;
// The main class of the program

    public static void main(String[] args){
        // create a random number generator
        Random rand = new Random();
        // generate a random number between 1 and 100
        int answer = rand.nextInt(100) + 1;
        // initialize the number of guesses to 0
        int guesses = 0;
        // create a scanner object to read input from the user
        Scanner reader = new Scanner(System.in);
        // loops untill the user guesses the correct number
    while(true) {
        // prompt the user to enter a number
        System.out.print("Enter a number: ");
        int n = reader.nextInt(); // Scans the next token of the input as an int
        // check if the number is correct, too high, or too low
        if(n == answer) {
            // if the number is correct, print a message and break the loop
            System.out.println("You guessed it right!");
            // break the loop
            break;
        
        } 
        // check if the number is too high or too low
        else if(n > answer) {
            // if the number is too high, print a message and increment the guesses counter
            System.out.println("Your guess is too high!");
            // increment the guesses counter
            guesses++;
        }
        // check if the number is too low
        else if(n < answer) {
            // if the number is too low, print a message and increment the guesses counter
            System.out.println("Your guess is too low!");
            // increment the guesses counter
            guesses++;
        }    
        
        

        }
    // print the number of wrong guesses
     System.out.println("You made " + guesses + " wrong guesses.");
} 

