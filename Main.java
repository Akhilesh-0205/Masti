import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("================================");
        System.out.println("       MASTI - GUESS IT!");
        System.out.println("================================");
        System.out.println("I'm thinking of a number from 1 to 100.");

        boolean playAgain = true;

        while (playAgain) {
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nTake a guess!");

            while (!guessedCorrectly) {
                System.out.print("Your guess (1-100): ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a whole number.");
                    scanner.next();
                    continue;
                }

                int guess = scanner.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Your number must be between 1 and 100.");
                    continue;
                }

                attempts++;

                if (guess < secretNumber) {
                    System.out.println("Too low! Try a bigger number.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Try a smaller number.");
                } else {
                    guessedCorrectly = true;
                    System.out.println("\n🎉 Correct! You guessed it in " + attempts
                            + (attempts == 1 ? " attempt." : " attempts."));
                }
            }

            System.out.print("\nWant to play again? (y/n): ");
            playAgain = scanner.next().trim().equalsIgnoreCase("y");
        }

        System.out.println("\nThanks for playing Masti. See you next time! 👋");
        scanner.close();
    }
}
