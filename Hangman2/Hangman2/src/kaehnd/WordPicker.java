package kaehnd;

import java.util.Random;

/**
 * Choose a word to use as part of a Hangman game.
 */
public class WordPicker {

    private String [] words;
    private Random rng;

    /**
     * Construct a WordPicker which selects
     * from a scientifically-selected list
     * of possible words
     */
    public WordPicker(){
        this(new String[]{
                "ineffable",
                "rhythmical",
                "unending",
                "algebraic",
                "undefined",
                "kwijibo",
                "indelicate",
                "forensics",
                "salamander",
                "allegretto",
                "interminable",
                "impressive",
                "itemized",
                "unquestioned"
        });
    }

    /**
     * Construct a WordPicker which selects from a
     * user-provided list of words.
     * @param wordList array of words to pick from.
     */
    public WordPicker(String [] wordList){
        words = wordList;
        rng = new Random();
    }

    /**
     * Choose a secret word
     * @return the secret word
     */
    public String chooseWord(){
        return words[rng.nextInt(words.length)];
    }
}
