package hangman;

import java.util.Scanner;

/**
 * Driver application for Hangman game
 */
public class HangmanDriver {

    /**
     * Read one letter from the user
     */
    public static char getGuess(Scanner stdIn){
        String guess;
        do {
            System.out.print("Guess a letter: ");
            guess = stdIn.next();
        } while(guess.length() != 1 || !Character.isLetter(guess.charAt(0)));
        return guess.charAt(0);
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        HangmanGame game = new HangmanGame();
        System.out.println(Math.round(Math.random()*6+1));
        char guess;
        do{
            System.out.println(game.currentState());
            guess = getGuess(input);
        } while(!game.guess(guess));

        System.out.println(game.currentState());

        if(game.guessedTheWord()){
            System.out.println("You win!!!");
        } else {
            System.out.println("You lose!!");
        }
    }
}
