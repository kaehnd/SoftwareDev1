package hangman;

/**
 * Holds and manages the "secret word" for a game of Hangman
 * Maintains a "visible" form of the word with asterisks in
 * place of un-guessed letters, and the letters in place when
 * they have been guessed.
 *
 * Ensures that letters are always upper-case.
 */
public class SecretWord {

    private static final String SECRET_CHAR = "*";

    private String secretWord;
    private String visibleWord;

    /**
     * Constructs both words
     */
    public SecretWord(String word){
        secretWord = word.toUpperCase();
        visibleWord = "";
        for(int i = 0; i < word.length(); ++i){
            visibleWord += SECRET_CHAR;
        }
    }

    /**
     * Guess that a letter is part of the word.  If it is,
     * the appropriate blanks (asterisks) in the visible word
     * will be replaced by the (capital) letter.
     * @param letter the letter guessed
     * @return true if the guess is in the word, false otherwise
     */
    public boolean guess(char letter){
        letter = Character.toUpperCase(letter);
        boolean correct = false;
        for (int count = 0; count < secretWord.length(); count++){

            if (letter == secretWord.charAt(count)){
                correct = true;
                if (count == 0){
                    visibleWord = letter + visibleWord.substring(1);
                }
                else if (count == secretWord.length()-1){
                    visibleWord = visibleWord.substring(0, count) + letter;
                }
                else
                visibleWord = visibleWord.substring(0, count) + letter + visibleWord.substring(count + 1);
            }
        }
        return correct;
    }

    /**
     * Determine if the secret word has been entirely guessed.
     * @return true iff every letter in the word has been guessed.
     */
    public boolean hasGuessedWord(){
        if (visibleWord.equalsIgnoreCase(secretWord)){
            return true;
        }
        return false;
    }

    /**
     * Return the visible word
     * @return the word (visible)
     */
    public String toString(){
        return visibleWord;
    }
}
