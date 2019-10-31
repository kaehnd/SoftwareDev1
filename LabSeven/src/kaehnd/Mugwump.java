/*
 * Course: CS 1011
 * Term: Fall 2018
 * Assignment: Lab 7
 * Name: Daniel Kaehn
 * Date: 10/16/18
 */
package kaehnd;

/**
 * Represents a Mugwump creature with hitPoints and various actions it performs during attack rounds
 */

public class Mugwump {
    private int hitPoints;
    private int maxHitPoints;
    private Die d100 = new Die(100);
    private Die d20 = new Die (20);
    private Die d10 = new Die(10);
    private Die d6 = new Die(6);

    /**
     * Constructor for Mugwump object with starting hitPoints using rollHitPoints method
     */

    public Mugwump(){
        maxHitPoints = rollHitPoints();
        hitPoints = maxHitPoints;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    /**
     *Decreases Mugwump hitPoints by defined hp
     * @param hp Damage dealt to the Mugwump
     */

    public void takeDamage(int hp){
        hitPoints -= hp;
    }

    /**
     *Decides what the Mugwump does during attack round and calculates damage or restored hp
     * @return Damage dealt to Warrior
     */

    public int attack(){
        //Minimum values for d20 roll where the Mugwump will hit the Warrior
        final int MIN_ROLL_CLAWS = 12;
        final int MIN_ROLL_FANGS = 16;

        int damage = 0;
        d20.roll();
        int type = ai();
        switch (type){
            case 1:{
                if (d20.getCurrentValue() >= MIN_ROLL_CLAWS){
                    for (int count = 0; count < 2; count++) {
                        d6.roll();
                        damage += d6.getCurrentValue();
                    }
                    System.out.println("The Mugwump slices at you with its claws for " +
                            damage + " points of damage!");
                }
                else{
                    System.out.println("The Mugwump swipes at you and misses.");
                }
                return damage;
            }
            case 2:{
                if (d20.getCurrentValue() >= MIN_ROLL_FANGS){
                    for (int count = 0; count < 3; count++){
                        d6.roll();
                        damage += d6.getCurrentValue();
                    }
                    System.out.println("The foul creature snaps at you with its fangs for " + damage +
                            " points of damge!");
                }
                else{
                    System.out.println("The Mugwump snaps at you and misses.");
                }
                return damage;
            }
            case 3:
                d6.roll();
                this.hitPoints += d6.getCurrentValue();
                if (this.hitPoints > maxHitPoints){
                    this.hitPoints = maxHitPoints;
                    System.out.println("The Mugwump licks its wounds and heals back to its max hp");
                }
                else {
                    System.out.println("The Mugwump licks its wounds and heals " +
                            d6.getCurrentValue() + " hit points.");
                    return damage;
                }
        }
        return 0;
    }

    /**
     * Rolls starting hitpoins for Mugwump objects by rolling a d10 ten times and adding the results
     * @return Starting hitPoints
     */

    private int rollHitPoints(){
        int hitPoints = 0;
        for (int count = 0; count < 10; count++) {//Rolls a d10 10 times and adds the value to starting hitPoints
            d10.roll();
            hitPoints += d10.getCurrentValue();
        }
        return hitPoints;
    }

    /**
     *AI method for Mugwump attack, randomizing with probability between three attack events
     * @return 1 for Claws, 2 for Fangs of Death, 3 for Lick Wounds
     */

    private int ai(){
        //Values determining the probability of the Mugwump performing each action during the attack round
        final int ROLL_RANGE_MIN_HEAL = 91; //100 is max
        final int ROLL_RANGE_MIN_FANGS = 76; //90 is max
       d100.roll();
       int roll = d100.getCurrentValue();
        if (roll >= ROLL_RANGE_MIN_HEAL){
            return 3;
        }
        else if (roll >= ROLL_RANGE_MIN_FANGS){
            return 2;
        }
        else{
            return 1;
        }
    }
}
