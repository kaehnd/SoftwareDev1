/*
 * Course: CS-1011-021
 * Term: Fall 2018
 * Assignment: Lab 6
 * Name: Daniel Kaehn
 * Date: 10/09/18
 */

package kaehnd;

/**
 * Class containing methods and variables for the House driver class
 */

public class BuildingCostEstimator {

    private int squareFeet;
    private int numFullBaths;
    private int numHalfBaths;
    private int numBedrooms;
    private int numWindows;
    private double numGarages;

    /**
     * Constructor to set default values of zero for all instance variables in
     * class BuildingClassEstimator
     */

    public BuildingCostEstimator(){
        squareFeet = 0;
        numFullBaths = 0;
        numHalfBaths = 0;
        numBedrooms = 0;
        numWindows = 0;
        numGarages = 0;
    }

   /*
    *Setters for all instance variables
    */

    public void setSquareFeet(int squareFeet){
        this.squareFeet = squareFeet;
    }

    public void setNumFullBaths(int numFullBaths) {
        this.numFullBaths = numFullBaths;
    }

    public void setNumHalfBaths(int numHalfBaths) {
        this.numHalfBaths = numHalfBaths;
    }

    public void setNumBedrooms(int numBedrooms) {
        this.numBedrooms = numBedrooms;
    }

    public void setNumWindows(int numWindows) {
        this.numWindows = numWindows;
    }

    public void setNumGarages(double numGarages) {
        this.numGarages = numGarages;
    }

    /*
     *Getters for all instance variables
     */

    public int getSquareFeet() {
        return squareFeet;
    }

    public int getNumFullBaths() {
        return numFullBaths;
    }

    public int getNumHalfBaths() {
        return numHalfBaths;
    }

    public int getNumBedrooms() {
        return numBedrooms;
    }

    public int getNumWindows() {
        return numWindows;
    }

    public double getNumGarages() {
        return numGarages;
    }

    /**
     *Returns a double value equal to the cost of a house to the specifications
     *as inputted by user into each instance of the BuildingCostEstimator Class
     */

    public double costToBuild(){
        final int PRICE_PER_SQUARE_FOOT = 135;
        final int PRICE_PER_FULL_BATHROOM = 15000;
        final int PRICE_PER_HALF_BATHROOM = 7000;
        final int PRICE_PER_BEDROOM = 3000;
        final int PRICE_PER_WINDOW = 800;
        final int PRICE_PER_GARAGE = 8000;

        return PRICE_PER_SQUARE_FOOT * squareFeet + PRICE_PER_FULL_BATHROOM * numFullBaths +
                PRICE_PER_HALF_BATHROOM * numHalfBaths + PRICE_PER_BEDROOM * numBedrooms +
                PRICE_PER_WINDOW * numWindows + PRICE_PER_GARAGE * numGarages;
    }
}