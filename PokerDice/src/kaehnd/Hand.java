package kaehnd;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A single "hand" of poker dice.  Each hand has five dice,
 * and is formed from the numbers rolled on those dice.
 */
public class Hand {
    /**
     * Number of dice in a hand
     */
    public static final int HAND_SIZE = 5;

    private Die dice[];

    /**
     * Initialize a hand of dice
     */
    public Hand(){
        dice = new Die[HAND_SIZE];
        for(int i = 0; i < dice.length; ++i){
            dice[i] = new Die();
        }
    }

    /**
     * Roll only the selected dice.
     *
     * Dice are specified with booleans at corresponding indices
     *
     * @precondition array parameter has HAND_SIZE booleans
     *
     * @param which Array of booleans with true in the places
     *              where dice should be rerolled
     */
    public void roll(boolean [] which){
        for(int i = 0; i < HAND_SIZE; ++i){
            if(which[i]){
                dice[i].roll();
            }
        }
    }

    /**
     * Roll all of the dice.
     */
    public void roll(){
        roll(new boolean[]{true,true,true,true,true});
    }

    /**
     * Detect if the hand is currently 3-of-a-kind
     *
     * A hand is three of a kind if three dice show the
     * same number and each other die shows a value
     * which is different from all other dice.
     * (e.g. 3 3 3 2 1)
     * @return true iff the roll is 3-of-a-kind
     */
    public boolean isThreeOfAKind(){
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < dice.length; i++){
            numbers.add(dice[i].getFaceValue());
        }
        int pairsOfThree = 0;
        int pairsOfTwo = 0;
        for(int i = 0; i < numbers.size(); i++){
            int numSame = 0;
            for(int j = 0; j < numbers.size(); j++){
                if(numbers.get(i).equals(numbers.get(j))){
                    numSame++;
                }
            }
            if (numSame == 2){
                pairsOfTwo++;
            }
            if (numSame == 3){
                pairsOfThree++;
            }
        }
        if (pairsOfTwo > 0){
            return false;
        }
        return (pairsOfThree == 3);
    }

    /**
     * Detect if the hand is currently 4-of-a-kind
     *
     * A hand is three of a kind if four dice show the
     * same number and the other die shows a value
     * which is different from all other dice.
     * (e.g. 4 4 4 4 1)
     * @return true iff the roll is 4-of-a-kind
     */
    public boolean isFourOfAKind(){
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < dice.length; i++){
            numbers.add(dice[i].getFaceValue());
        }

        for(int i = 0; i < numbers.size(); i++){
            int numSame = 0;
            for(int j = 0; j < numbers.size(); j++){
                if(numbers.get(i).equals(numbers.get(j))){
                    numSame++;
                }
            }
            if (numSame == 4){
                return true;
            }
        }
        return false;
    }

    /**
     * Detect if the hand is currently 5-of-a-kind
     *
     * A hand is three of a kind if all five dice show
     * the same number.
     * (e.g. 5 5 5 5 5)
     * @return true iff the roll is 5-of-a-kind
     */
    public boolean isFiveOfAKind(){
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < dice.length; i++){
            numbers.add(dice[i].getFaceValue());
        }

        for(int i = 0; i < numbers.size(); i++){
            int numSame = 0;
            for(int j = 0; j < numbers.size(); j++){
                if(numbers.get(i).equals(numbers.get(j))){
                    numSame++;
                }
            }
            if (numSame == 5){
                return true;
            }
        }
        return false;
    }

    /**
     * Detect if the hand is currently a full house
     *
     * A hand is a full house if three dice show the
     * same number and the other two show thea different
     * number which is the same as each other
     * (e.g. 3 3 3 2 2)
     * @return true iff the roll is a full house
     */

    public boolean isFullHouse(){
        // TODO
        return false;
    }

    /**
     * Detect if the hand is currently a "small" straight
     *
     * A hand is a small straight if 4 dice are in sequence
     * and the fifth is not
     * (e.g. 1 2 3 4 1)
     * @return true iff the roll is a small straight
     */
    public boolean isSmallStraight(){
        // TODO
        return false;
    }

    /**
     * Detect if the hand is currently a "large" straight
     *
     * A hand is a small straight if all 5dice are in sequence
     * (e.g. 1 2 3 4 5)
     * @return true iff the roll is a large straight
     */
    public boolean isLargeStraight(){
        // TODO
        return false;
    }

    /**
     * Detect if the hand is currently two pair
     *
     * A hand is two pair if two groups of two dice each
     * have the same value (but not the same between groups),
     * while the fifth die matches neither group
     *
     * (e.g. 1 1 2 2 3)
     * @return true iff the roll is a small straight
     */
    public boolean isTwoPair() {
        int numbersSame = 0;
        int pairs = 0;
        for (int i = 0; i < dice.length && numbersSame < 3; i++) {
            numbersSame = 0;
            for (int x = 0; x < dice.length; x++) {
                if (dice[i].getFaceValue() == dice[x].getFaceValue()) {
                    numbersSame++;
                }
            }
            if (numbersSame == 2) {
                pairs++;
            }
        }
        return (pairs == 4);
    }

    /**
     * Find the highest single die in a roll
     * @return the high die-roll value.
     */
    public int highDie(){
        int highest = this.dice[0].getFaceValue();
        for (int i = 1; i < dice.length; i++){
            highest = Math.max(highest, this.dice[i].getFaceValue());
        }
        return highest;
    }

    /**
     * String of the hand
     *
     * @return "d d d d d" where d is the face value of a die
     */
    public String toString(){
        String roll = "";
        for(int i = 0; i < dice.length; ++i){
            roll += " " + dice[i].getFaceValue();
        }
        return roll.substring(1);
    }

}
