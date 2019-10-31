package kaehnd;

/**
 * Tracks the number of incorrect guesses.  Maintains
 * an ascii-art hangman picture.
 */
public class Gallows {

    private static final int MAX_WRONG_GUESSES = 6;
    private static final String INITIAL_GALLOWS =
            "  +---+\n"
         +  "  |   |\n"
         +  "      |\n"
         +  "      |\n"
         +  "      |\n"
         +  " ____/|\n";
    private static final int ROW_WIDTH = 8;
    private static final int BODY_CENTER = 2;

    private int wrongGuesses;
    private String gallows;

    /**
     * Start at 0 wrong guesses
     */
    public Gallows(){
        wrongGuesses = 0;
        gallows = INITIAL_GALLOWS;
    }

    /**
     * Called when the user makes an incorrect guess
     */
    public void madeWrongGuess() {
        wrongGuesses++;
        updateArt();
    }

    /**
     * Tests if the user has made their last incorrect guess
     * @return true if they have no remaining wrong guesses to make
     */
     public boolean hasBeenHung(){
        return wrongGuesses >= MAX_WRONG_GUESSES;
    }

    /**
     * The gallows as a string
     * @return the gallows string
     */
    public String toString(){
        return gallows;
    }

    private void replace(int row, int col, char ch){
        int idx = row * ROW_WIDTH + col;
        gallows = gallows.substring(0,idx) + ch + gallows.substring(idx+1);
    }

    private void updateArt(){
        switch (wrongGuesses){
            case 6:
                replace(4,BODY_CENTER+1,'\\');
            case 5:
                replace(4,BODY_CENTER-1,'/');
                break;
            case 4:
                replace(2,BODY_CENTER+1, '/');
                break;
            case 3:
                replace(2,BODY_CENTER -1, '\\');
                break;
            case 2:
                replace(3,BODY_CENTER,'|');
                break;
            case 1:
                replace(2,BODY_CENTER,'O');
                break;
        }
    }
}
