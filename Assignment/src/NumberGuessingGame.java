import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    static class GameResult {
        boolean won;
        int attemptsUsed;

        GameResult (boolean won, int attemptsUsed) {
            this.won = won;
            this.attemptsUsed = attemptsUsed;
        }
    }
    public Object[] playNumberGuessingGame(int min, int max, int maxAttempts, Scanner scanner) {
        Random random = new Random();
        int exactNumber = random.nextInt(max - min + 1) + min;
        int attempts = 0;
        boolean correct = false;

        System.out.println("Guess a number between " + min + " and " + max + ".");
        System.out.println("You have " + maxAttempts + " attempts. ");

        while (attempts < maxAttempts) {


            System.out.println("Enter your guess: ");
            int guess = scanner.nextInt();
            if (guess < min || guess > max) {
                System.out.println("Error! Enter a number between " + min + " and " + max + ".");
                continue;
            }
            attempts++;

            if (guess == exactNumber) {
                correct = true;
                break;
            } else if (guess < exactNumber) {
                System.out.println("Too Low! Attempts left: " + (maxAttempts - attempts));
            } else {
                System.out.println("Too High! Attempts left: " + (maxAttempts - attempts));
            }
        }
        return new Object[] {new GameResult(correct, attempts), exactNumber};
    }

    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        NumberGuessingGame game = new NumberGuessingGame();

        Object[] result = game.playNumberGuessingGame(1, 50, 5, scanner);
        GameResult gameResult = (GameResult) result[0];
        int exactNumber = (Integer) result[1];

        if (gameResult.won) {
            System.out.println("Congratulations! You guessed the Number correctly in " + gameResult.attemptsUsed + " attempts!");
        } else {
            System.out.println("Game Over! You've run out of attempts.");
            System.out.println("The Exact Number is " + exactNumber);
        }
        scanner.close();
    }
}