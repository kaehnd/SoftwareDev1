/*
 * Course: CS 1011
 * Term: Fall 2018
 * Assignment: Lab 7
 * Name: Daniel Kaehn
 * Date: 10/16/18
 */

package kaehnd;

import java.util.Scanner;

/**
 * Driver for Die, Mugwump, and Warrior Classes, which holds the main for BattleSim3000 game
 */

public class BattleSim {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean play = true;
        String victor;
        play = playAgain(in);

        while (play) {
            Warrior warrior = new Warrior();
            Mugwump mugwump = new Mugwump();
            intro();
            victor = battle(warrior, mugwump, in);
            victory(victor);
            play = playAgain(in);
        }
        System.out.println("Thank you for playing Battle Simulator 3000!");
    }

    /**
     * Displays the introduction to the game and gives a description of the rules.
     */

    private static void intro() {
		System.out.println("\nWelcome to Battle Simulator 3000! \n\nYou are a mighty warrior in the Land of Fire, " +
                "and are known all around for your ability to defeat evil mugwumps.\nYou have your " +
                "Trusty Sword, which deals a lot of damage, but is likely to miss its target.\n" +
                "You also have your Shield of Light, which is easier to hit with, but doesn't hurt its " +
                "target as much as your Sword.\n(Enter to continue)");
        new Scanner(System.in).nextLine();
        System.out.println("\nAn evil mugwump approaches, and the citizens of your villiage are counting on you" +
                "to defend them!\nLet the epic battle begin!");
    }

    /**
     * This method handles the battle logic for the game.
     * @param warrior The Warrior of Light!
     * @param mugwump The Evil Mugwump!
     * @return The name of the victor, or "none", if the battle is still raging on
     */

    private static String battle(Warrior warrior, Mugwump mugwump, Scanner in) {
        while (warrior.getHitPoints() > 0 && mugwump.getHitPoints() > 0) {
            report(warrior, mugwump);
            int initiative = initiative();

            if (initiative == 1){
                mugwump.takeDamage(warrior.attack(attackChoice(in)));
                if (mugwump.getHitPoints() > 0) { //Ensures Mugwump does not attack if it is dead
                    System.out.println("\nNow the Mugwump attacks!");
                    warrior.takeDamage(mugwump.attack());
                }
            }
            else{
                warrior.takeDamage(mugwump.attack());
                if (warrior.getHitPoints() > 0){ //Ensures Warrior does not attack if it is dead
                    System.out.println("\nNow the Warrior attacks!");
                    mugwump.takeDamage(warrior.attack(attackChoice(in)));
                }
            }
        }
        if (warrior.getHitPoints() <= 0) {
            return "Mugwump";
    }
        else{
            return "Warrior";
        }
    }

    /**
     * This method reports the status of the combatants before each new round
     * @param warrior The Warrior of Light!
     * @param mugwump The Evil Mugwump!
     */

    private static void report(Warrior warrior, Mugwump mugwump) {
        System.out.println("\nWarrior HP: " + warrior.getHitPoints() + "\nMugwump HP: " + mugwump.getHitPoints());
        System.out.println();
    }

    /**
     * This method asks the user what attack type they want to use and returns the result
     * @return 1 for sword, 2 for shield
     */

    private static int attackChoice(Scanner in) {
        System.out.println("How would you like to attack?\n1.\tYour Trusty Sword\n2.\tYour Shield of Light");
        return in.nextInt();
    }

    /**
     * Determines which combatant attacks first, displays and returns the result.
     * @return 1 if the warrior goes first, 2 if the mugwump goes first
     */

    private static int initiative() {
        Die d10 = new Die(10); //Creates die object with ten sides
        d10.roll();
        int mugwumpInitiative = d10.getCurrentValue();
        d10.roll();
        int warriorInitiative = d10.getCurrentValue();
        if (warriorInitiative > mugwumpInitiative){
            System.out.println("The Warrior attacks first!");
            return 1;
        }
        else{
            System.out.println("The Mugwump attacks first!");
            return 2;
        }
    }

    /**
     * This method declares the winner of the epic battle
     * @param winner the name of the winner of the epic battle
     */

    private static void victory(String winner) {
        if (winner.equals("Warrior")) {
            System.out.println("\nAt last, the foul Mugwump is defeated!\nThe citizens of the Land of Fire " +
                    "praise you for your continued protection and hold a feast in your honor!");
        }
        else{
            System.out.println("\nHaving given your last breath, you fall to the prowess of the dreadful Mugwump.\n" +
                    "The citizens of the land of fire watch in terror as the Mugwump desolates their homes " +
                    "and devours all in its path.");
        }
        System.out.println();
    }

    /**
     * This method asks the user if they would like to play again
     * @param in Scanner
     * @return true if yes, false otherwise
     */

    private static boolean playAgain(Scanner in) {
        String playAgain;
        System.out.print("Would you like to battle? ");
        playAgain = in.next();
        if (playAgain.equalsIgnoreCase("Y") || playAgain.equalsIgnoreCase("YES")) {
            return true;
        }
        else {
            return false;
        }
    }
    public class Die {
        private int numSides;
        private int currentValue;
        private final int MIN_SIDES = 2;
        private final int MAX_SIDES = 100;
        private final int DEFAULT_SIDES = 6;

        /**
         * Constructs a die object of
         * @param numSides sides
         * Constructs a die of 6 sides if numsSides is less than 2 or greater than 100
         */

        public Die(int numSides){
            this.numSides = numSides;
            if (numSides < MIN_SIDES || numSides > MAX_SIDES){
                this.numSides = DEFAULT_SIDES;
            }
        }

        public int getNumSides() {
            return numSides;
        }

        public int getCurrentValue() {
            return currentValue;
        }



        /**
         * For a Die object with numberOfSides sides
         * @return random number between 1 and numSides
         */

        public void roll(){
            this.currentValue = Math.round(((float)Math.random() * (this.numSides - 1) + 1));
        }

    }
}
public class Die {
    private int numSides;
    private int currentValue;
    private final int MIN_SIDES = 2;
    private final int MAX_SIDES = 100;
    private final int DEFAULT_SIDES = 6;

    /**
     * Constructs a die object of
     * @param numSides sides
     * Constructs a die of 6 sides if numsSides is less than 2 or greater than 100
     */

    public Die(int numSides){
        this.numSides = numSides;
        if (numSides < MIN_SIDES || numSides > MAX_SIDES){
            this.numSides = DEFAULT_SIDES;
        }
    }

    public int getNumSides() {
        return numSides;
    }

    public int getCurrentValue() {
        return currentValue;
    }



    /**
     * For a Die object with numberOfSides sides
     * @return random number between 1 and numSides
     */

    public void roll(){
        this.currentValue = Math.round(((float)Math.random() * (this.numSides - 1) + 1));
    }

}
