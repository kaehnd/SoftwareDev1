/*
 * Course: CS 1011
 * Term: Fall 2018
 * Assignment: Lab 10
 * Name: Daniel Kaehn
 * Date: 11/06/18
 */

package kaehnd;

import java.text.DecimalFormat;

/**
 * @author [Daniel Kaehn]
 *         <p/>
 *         ParkingLot class used to simulate ParkingLot objects and interactions with their District
 */
public class ParkingLot {

    /** Percentage value of lot capacity that defines when a lot is marked as closed
     */
    public static final double CLOSED_THRESHOLD = 80.0;

    private String name;
    private int capacity;
    private int currentVehicles;
    private boolean closed;
    private int closingTime;
    private int openingTime;
    private int timeClosed;
    private int prevTime;

    /** Constructs a parking lot with defined name and capacity
     * @param lotName parking lot name
     * @param capacity max amount of vehicles a lot can hold
     */
    public ParkingLot(String lotName, int capacity){
        this.name = lotName;
        this.capacity = capacity;
        closed = false;
    }

    /** Constructs a parking lot with default name and defined capacity
     * @param capacity max amount of vehicles a lot can hold
     */
    public ParkingLot(int capacity){
        this("test", capacity);
    }

    public String getName() {
        return name;
    }

    /** Marks entry of vehicle into lot if time is valid
     * Closes lot if entering vehicle increases capacity to closed threshold
     * @param time minute value of vehicle entry
     */
    public void markVehicleEntry(int time) {
        if (time >= prevTime) {
            currentVehicles++;
            if ((currentVehicles >= capacity * CLOSED_THRESHOLD / 100) && !closed) {
                closingTime = time;
                closed = true;
            }
            prevTime = time;
        }
    }

    /** Marks exit of vehicle out of lot if time is valid
     * Opens lot if exiting vehicle decreases capacity past closed threshold
     * @param time minute value of vehicle exit
     */
    public void markVehicleExit(int time) {
        if (time >= prevTime) {
            currentVehicles--;
            if ((currentVehicles < capacity * CLOSED_THRESHOLD / 100) && closed) {
                openingTime = time;
                closed = false;
                timeClosed += openingTime - closingTime;
            }
        }
    }



    /** Returns if lot is currently closed
     * @return if this lot is currently closed
     */
    public boolean isClosed(){
        return closed;
    }

    /** Returns amount of time lot was closed
     * @return amount of time this lot has been closed
     */
    public int closedMinutes(){
        return timeClosed;
    }

    /**Constructs string containing the status of the parking lot
     * @return status of lot, including lot name, whether it is closed, and capacity percentage
     * or CLOSED depending on if the lot is closed
     */
    public String toString(){
        String status = "";
        status += "Status for " + name + " parking lot: " + currentVehicles + " vehicles ";
        if (this.isClosed()){
            status += "(CLOSED)";
        } else{
            double percentage = (double) currentVehicles * 100 / capacity;
            DecimalFormat format = new DecimalFormat("##.#");
            status += "(" + format.format(percentage) + "%)";
        }
        return status;
    }

    /** Returns current amount of vehicles in lot
     * @return current amount of vehicles in lot
     */
    public int vehiclesInLot(){
        return currentVehicles;
    }
}


//double pi = Math.PI;
//DecimalFormat format - new DecimalFormat(##.#);
//System.out.println("DRUGS " + format.format(pi);