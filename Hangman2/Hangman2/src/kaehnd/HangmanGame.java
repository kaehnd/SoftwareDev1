package kaehnd;

/**
 * A game of hangman.
 *
 * The game chooses a secret word, and the
 * user must guess its letters before the
 * gallows is completed.
 */
public class HangmanGame {

    private WordPicker wordSelector;
    private Gallows gallows;
    private SecretWord theWord;

    /**
     * initialize the word and the gallows
     */
    public HangmanGame(){
        wordSelector = new WordPicker();
        gallows = new Gallows();
        theWord = new SecretWord(wordSelector.chooseWord());

    }

    /**
     * The user makes one guess
     * @param letter the letter guessed
     * @return true if this guess ended the game (right or wrong)
     */
    public boolean guess(char letter){
        if(!theWord.guess(letter)){
            gallows.madeWrongGuess();
        }
        return theWord.hasGuessedWord() || gallows.hasBeenHung();
    }

    /**
     * Returns true if the user ended the game by guessing the word
     * Precondition: the game has ended
     * @return
     */
    public boolean guessedTheWord(){
        return theWord.hasGuessedWord();
    }

    /**
     * Show the game in its current state
     * @return A string representation of the gallows and the word
     */
    public String currentState(){
        return gallows.toString() + "\n\n" + theWord.toString() + "\n";
    }

}
