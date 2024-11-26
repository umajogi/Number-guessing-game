import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalRounds = 0;
        int totalAttempts = 0;

        while (true) {
            System.out.println("Welcome to the Guess the Number game!");
            System.out.println("I will generate a random number between 1 and 100.");
            System.out.println("You have 7 attempts to guess the correct number.");

            Random random = new Random();
            int secretNumber = random.nextInt(100) + 1;

            int attempts = 7;
            int roundAttempts = 0;

            while (attempts > 0) {
                System.out.print("\nEnter your guess: ");
                int guess = scanner.nextInt();

                if (guess == secretNumber) {
                    System.out.println("Congratulations! You guessed the number correctly!");
                    roundAttempts = 7 - attempts + 1;
                    totalAttempts += roundAttempts;
                    totalRounds++;
                    System.out.println("Round Attempts: " + roundAttempts);
                    System.out.println("Total Attempts: " + totalAttempts);
                    System.out.println("Total Rounds: " + totalRounds);
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                attempts--;
            }

            if (attempts == 0) {
                System.out.println("Sorry, you ran out of attempts. The number was " + secretNumber + ".");
                totalRounds++;
                System.out.println("Round Attempts: 7");
                System.out.println("Total Attempts: " + totalAttempts);
                System.out.println("Total Rounds: " + totalRounds);
            }

            System.out.print("\nDo you want to play again? (y/n) ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("y")) {
                break;
            }
        }

        System.out.println("Thanks for playing! Goodbye.");
        scanner.close();
    }
}