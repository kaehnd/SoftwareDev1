package kaehnd;

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

    private boolean [] correctGuesses;

    /**
     * Constructs both words
     */
    public SecretWord(String word){
        secretWord = word.toUpperCase();
        correctGuesses = new boolean[word.length()];
        for(int i = 0; i < word.length(); ++i){
            correctGuesses[i] = false;
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
        boolean inWord = false;
        for (int i = 0; i < secretWord.length(); i++){
            if (Character.toUpperCase(letter) == secretWord.charAt(i)){
                correctGuesses[i] = true;
                inWord = true;
            }
        }
        return inWord;
    }

    /**
     * Determine if the secret word has been entirely guessed.
     * @return true iff every letter in the word has been guessed.
     */
    public boolean hasGuessedWord(){
        int alreadyGuessed = 0;
        for (int i = 0; i < correctGuesses.length; i++) {
            if(correctGuesses[i]){
                alreadyGuessed++;
            }
        }
        return (alreadyGuessed == correctGuesses.length);
    }

    /**
     * Return the visible word
     * @return the word (visible)
     */
    public String toString(){
        String visibleWord = "";
        for (int i = 0; i < correctGuesses.length; i++){
            if (correctGuesses[i]){
                visibleWord += secretWord.charAt(i);
            }
            else{
                visibleWord += SECRET_CHAR;
            }
        }
        return visibleWord;
    }
}
