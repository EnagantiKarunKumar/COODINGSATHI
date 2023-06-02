import java.util.Scanner;

public class guess {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int randomNumber = (int) (Math.random() * 995) + 1; // generate a random number between 1 and 100
        int userGuess;
        int numGuesses = 0;

        System.out.println("I'm thinking of a number between 1 and 995. Can you guess what it is?");
        do {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            numGuesses++;

            if (userGuess < randomNumber) {
                System.out.println("Your guess is too less. Try again....!");
            } else if (userGuess > randomNumber) {
                System.out.println("Your guess is too high. Try again....!");
            } else {
                System.out.println("Congratulations, you guessed the number in " + numGuesses + " guesses!");
            }
        } while (userGuess != randomNumber);

        scanner.close();
    }
}