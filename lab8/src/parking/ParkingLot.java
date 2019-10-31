/*
 * Course: CS 1011
 * Term: Fall 2018
 * Assignment: Lab 8
 * Name: Daniel Kaehn
 * Date: 10/23/18
 */

package parking;

/**
 * @author [Daniel Kaehn]
 *         <p/>
 *         ParkingLot class used to simulate ParkingLot objects and interactions with their District
 */
public class ParkingLot {

    /** Percentage value of lot capacity that defines when a lot is marked as closed
     */
    public static final double CLOSED_THRESHOLD = 80.0;

    private String color;
    private int capacity;
    private int currentVehicles;
    private boolean closed;
    private int closingTime;
    private int openingTime;
    private int timeClosed;
    private int prevTime;

    /** Constructs a parking lot with defined color and capacity
     * @param color parking lot color
     * @param capacity max amount of vehicles a lot can hold
     */
    public ParkingLot(String color, int capacity){
        this.color = color;
        this.capacity = capacity;
        closed = false;
    }

    /** Constructs a parking lot with default color and defined capacity
     * @param capacity max amount of vehicles a lot can hold
     */
    public ParkingLot(int capacity){
        this("test", capacity);
    }

    public String getColor() {
        return color;
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

    /** Returns current amount of vehicles in lot
     * @return current amount of vehicles in lot
     */
    public int vehiclesInLot(){
        return currentVehicles;
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

    /** Prints status of lot, including lot color, whether it is closed, and capacity percentage
     * if not closed
     */
    public void displayStatus(){
        System.out.print(color +" parking lot status: ");
        if (this.isClosed()){
            System.out.println("CLOSED");
        } else{
            System.out.println(vehiclesInLot() * 100 / capacity + "% capacity");
        }
    }
}
