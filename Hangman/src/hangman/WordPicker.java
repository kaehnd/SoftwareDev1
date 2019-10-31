package hangman;

/**
 * Choose a word to use as part of a Hangman game.
 */
public class WordPicker {

    /**
     * Choose a secret word
     * @return the secret word
     */
    public String chooseWord(){
        return Math.random() > 0.5?"ineffable":"rhythmical";
    }
}
