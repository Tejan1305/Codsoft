import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class NumberGuesser 
{
    public static void main(String[] args) 
    {
        int totalRounds = 0;
        int totalAttempts = 0;
        int totalCorrectGuesses = 0;

        while (true) 
        {
            int lower = 1;
            int upper = 100;
            //For fair amount of chances we used this method
            double chances = Math.log(upper - lower + 1) / Math.log(2);
            int maxAttempts = (int)chances;
            //Random generation of the number from the range
            int x = new Random().nextInt(upper - lower + 1) + lower;
            System.out.println("You have " + maxAttempts + " guesses with you.");

            int count = 0;
            boolean guessedCorrectly = false;
            while (count < maxAttempts) 
            {
                count++;
                System.out.print("Guess a number: ");
                Scanner scanner = new Scanner(System.in);
                int guess = scanner.nextInt();

                if (x == guess) 
                {
                    System.out.println("Congratulations! You guessed the right number.");
                    totalCorrectGuesses++;
                    guessedCorrectly = true;
                    break;
                } 
                else if (x > guess) 
                {
                    System.out.println("Try again, the number you guessed is small.");
                } 
                else 
                {
                    System.out.println("Try again, the number you guessed is high.");
                }
            }

            if (!guessedCorrectly) 
            {
                System.out.println("The number was " + x);
                System.out.println("You are out of guesses. Better luck next time.");
            }

            totalAttempts += count;
            totalRounds++;

            System.out.println("Do you want to play again? (y/n)");
            Scanner scanner = new Scanner(System.in);
            String playAgain = scanner.nextLine();
            if (!playAgain.equalsIgnoreCase("y")) 
            {
                break;
            }
        }

        System.out.println("Game over!");
        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Total attempts: " + totalAttempts);
        System.out.println("Total correct guesses: " + totalCorrectGuesses);
        System.out.println("Your score: " + totalCorrectGuesses + " / " + totalRounds);
    }
}
