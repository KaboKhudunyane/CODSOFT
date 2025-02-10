import java.util.Random;
import java.util.Scanner;
public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        while (playAgain) {
            int lowerBound = 1;
            int upperBound = 10;
            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int maxAttempts = 10;
            int attempts = 0;
            boolean correctGuess = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("You have " + maxAttempts + " attempts to guess the secret number between "
                    + lowerBound + " and " + upperBound + ". Good luck!");

            while (!correctGuess && attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.next();
                    continue;
                }
                int userGuess = scanner.nextInt();
                attempts++;
                if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("Out of range! Please guess a number between " + lowerBound + " and " + upperBound + ".");
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    correctGuess = true;
                    int score = maxAttempts - attempts + 1;
                    System.out.println("🎉 Congratulations! You guessed the number in " + attempts + " attempts.");
                    System.out.println("Your score: " + score);
                }
            }
            if (!correctGuess) {
                System.out.println("Game over! You've used all " + maxAttempts + " attempts. The correct number was " + secretNumber + ".");
            }
            System.out.print("Would you like to play again? (yes/no): ");
            scanner.nextLine();
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
                System.out.println("Thanks for playing! Goodbye. 👋");
            }
        }
        scanner.close();
    }
}