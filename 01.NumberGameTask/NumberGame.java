import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain;

        System.out.println("🎯 Welcome to the Number Guessing Game!");

        do {
            int lowerBound = 1;
            int upperBound = 100;
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI've picked a number between " + lowerBound + " and " + upperBound + ". Can you guess it?");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess → ");
                int guess;

                // Input validation
                if (scanner.hasNextInt()) {
                    guess = scanner.nextInt();
                    if (guess < lowerBound || guess > upperBound) {
                        System.out.println("❌ Your guess must be between " + lowerBound + " and " + upperBound + ".");
                        continue;
                    }
                } else {
                    System.out.println("⚠️ Please enter a valid number.");
                    scanner.next(); // consume invalid input
                    continue;
                }

                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("✅ Correct! You've guessed the number in " + attempts + " attempts.");
                    score += (maxAttempts - attempts + 1) * 10;
                    guessedCorrectly = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("📉 Too low!");
                } else {
                    System.out.println("📈 Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all attempts! The number was: " + numberToGuess);
            }

            System.out.println("🏆 Current Score: " + score);

            // Ask user to play again
            System.out.print("🔁 Do you want to play again? (yes/no): ");
            scanner.nextLine(); // consume newline
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");

        } while (playAgain);

        System.out.println("🎉 Thanks for playing! Your final score: " + score);
        scanner.close();
    }
}