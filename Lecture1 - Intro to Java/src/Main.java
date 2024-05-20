import com.sun.jdi.InvalidLineNumberException;

import java.util.Random;
import java.util.Scanner;

/*
    We are going to create a simple game in Java where we have to guess the number
    the computer has picked.

    1. We first determine how "hard" we want the game to be. We do this by allowing
    the user to determine what range of values the computer can pick from. For example,
    the user can specify the number has to be between 1 and N.

    2. Once the range is set, the computer picks a secret number between 1 and N.

    3. We try to guess the number. After each guess, the computer tells us whether we guessed
    it right, or if our guess was too high or low. We use the hints to narrow down the target.

    We configure how many guesses we are allowed as a command line argument to the program.
 */
public class Main {
    public static boolean isValidNumber(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public static int initializeGame(Scanner sc){
        boolean canStartGame = false;
        int upperBound = -1;
        while(!canStartGame){
            System.out.print("Enter a number between 1 and 50: ");
            String userInput = sc.next();
            if(isValidNumber(userInput)){
                upperBound = Integer.parseInt(userInput);
                if(upperBound >= 1 && upperBound <= 50) {
                    return upperBound;
                } else {
                    System.out.println("THe number has to be between 1 and 50");
                }
            } else {
                System.out.println("The input must ba an integer");
            }
        }
        return upperBound;
    }

    public static int pickNumber(int lowerBound, int upperBound){
        Random randomGen = new Random();
        System.out.println(String.format("I picked a number between %d and %d", lowerBound, upperBound));
        return randomGen.nextInt(upperBound) + lowerBound;
    }

    public static void guess(Scanner sc, int guessesLeft, int numberToGuess){
        // TODO
        boolean isGuessed = false;
        while(!isGuessed && guessesLeft > 0){
            System.out.print("Please enter your guess ");
            String nextGuess = sc.next();
            if(!isValidNumber(nextGuess)){
                guessesLeft -= 1;
                System.out.println(String.format("That was not a valid number. You have %d guesses left", guessesLeft));
            } else {
                int userGuess = Integer.parseInt(nextGuess);
                if(userGuess == numberToGuess){
                    isGuessed = true;
                    System.out.println("Congratulations! You guessed my number.");
                } else if(userGuess < numberToGuess){
                    guessesLeft -= 1;
                    String message = "My number is higher. You have %d guesses left";
                    System.out.println(String.format(message, guessesLeft));
                } else {
                    guessesLeft -= 1;
                    String message = "My number is lower. You have %d guesses left";
                    System.out.println(String.format(message, guessesLeft));
                }
            }
        }

        // Handle case where run out guesses
        if(!isGuessed){
            String gameOver = "Game over. My number was %d";
            System.out.println(String.format(gameOver, numberToGuess));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        int numGuessesAllowed = Integer.parseInt(args[0]);
        int upperBound = initializeGame(sc);
        int numberToGuess = pickNumber(1, upperBound);
        guess(sc, numGuessesAllowed, numberToGuess);
    }
}