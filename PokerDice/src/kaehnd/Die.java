package kaehnd;

import java.util.Random;

public class Die {
    private int numberOfSides;
    private int faceValue;
    private Random rng;


    public Die(int numberOfSides){
        this.numberOfSides = numberOfSides;
        rng = new Random();
        roll();
    }

    public Die(){
        this(6);
    }

    public int getFaceValue(){
        return faceValue;
    }

    public void roll(){
        faceValue = rng.nextInt(numberOfSides) + 1;
    }
}
