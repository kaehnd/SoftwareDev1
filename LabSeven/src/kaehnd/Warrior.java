/*
 * Course: CS 1011
 * Term: Fall 2018
 * Assignment: Lab 7
 * Name: Daniel Kaehn
 * Date: 10/16/18
 */
package kaehnd;

/**
 * Represents a Warrior controlled by the user and the actions it performs during attack rounds
 */

public class Warrior {
    private int hitPoints;
    private Die d20 = new Die(20);
    private Die d10 = new Die(10);
    private Die d8 = new Die(8);
    private Die d4 = new Die(4);

    /**
     * Constructs warrior with starting hitpoints using rollHitPoints method
     */

    public Warrior() {
        hitPoints = rollHitPoints();
    }

    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * Decreases Warrior hitpoints by defined hp
     * @param hp Damage dealt to the Warrior
     */

    public void takeDamage(int hp) {
        this.hitPoints -= hp;
    }

    /**
     * Simulates attack sequence for Warrior object during attack round
     * @param type Integer 1 or 2 that determines if Warrior attacks with sword or shield
     * @return Damage dealt to Mugwump
     */

    public int attack(int type) {
        //Minimum values for d20 rolls where the Warrior will hit the Mugwump
        final int MIN_ROLL_SWORD = 12;
        final int MIN_ROLL_SHIELD = 8;
        d20.roll();
        if (type == 1) {
            if (d20.getCurrentValue() >= MIN_ROLL_SWORD) {
                d8.roll();
                System.out.println("You swing your Trusty Sword and deal " + d8.getCurrentValue() +
                        " points of damage!");
                return d8.getCurrentValue();
            } else {
                System.out.println("You miss the Mugwump with your Trusty Sword!");
                return 0;

            }
        } else {
            if (d20.getCurrentValue() >= MIN_ROLL_SHIELD) {
                d4.roll();
                System.out.println("You bash the Mugwump with your Shield of Light and deal " +
                        d4.getCurrentValue() + " points of damage!");
                return d4.getCurrentValue();
            } else {
                System.out.println("You bash at the Mugwump with your Shield of Light, but miss!");
                return 0;
            }
        }
    }

    /**
     * Rolls starting hitPoints for Warrior object rolling d10 six times
     * @return Starting hitPoints
     */

    private int rollHitPoints() {
        int hitPoints = 0;
        for (int count = 0; count < 6; count++) { //Rolls d10 six times and adds each result to starting hitPoints
            d10.roll();
            hitPoints += d10.getCurrentValue();
        }
        return hitPoints;
    }
}
