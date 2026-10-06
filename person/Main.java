import java.util.ArrayList;
import java.util.Scanner;
//   15-sept ewan coulter
public class Main{
    
  public static void main(String[] args) {
    ArrayList<Person> people;
      people = new ArrayList<Person>();
   boolean running = true;
   int i = 0;
   while(running){
    people.add(new Person(
    ask("Enter name for person " + (i + 1)),
    Integer.parseInt(ask("Enter age for person " + (i + 1)))));
    i++;
    String choice = ask("Do you want to add another person? (yes/no)");
    if (!choice.equalsIgnoreCase("yes")) {
        running = false;
    }
   }
   for ( i = 0; i < people.size(); i++) {
    people.get(i).intro();
   }
  } 

  // This method prompts the user with a question and returns their input as a string.
    private static String ask(String question) {
        Scanner input = new Scanner(System.in);
        System.out.println(question);
        return input.nextLine();
    }
}