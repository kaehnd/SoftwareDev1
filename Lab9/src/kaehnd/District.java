/*
 * Course: CS 1011
 * Term: Fall 2018
 * Assignment: Lab 10
 * Name: Daniel Kaehn
 * Date: 11/06/18
 */

package kaehnd;

import java.util.ArrayList;

/**
 * @author [Daniel Kaehn]
 *         <p/>
 *         Capture usage information for parking lots in a district.
 */
public class District {

    /**
     * Maximum amount of lots in a district
     */
    public static final int MAX_LOTS = 20;

    ArrayList<ParkingLot> lots = new ArrayList<>();
    private int numLots;
    private int closingTime;
    private int openingTime;
    private boolean closed;
    private int timeClosed;


    /**
     * Set up a district with up to twenty parking lots.
     */
    public District() {
        closed = false;
    }

    /**
     * Creates a new ParkingLot with specified name and capacity in the lots array
     * @param name name of parking lot
     * @param capacity int number of vehicles it can hold
     * @return the index of the lot created
     */

    public int addLot(String name, int capacity) {
        int newIndex = numLots;
        if (newIndex < MAX_LOTS) {
            lots.add(new ParkingLot(name, capacity));
            numLots++;

        }
        //returns the index of the new lot or -1 if the lot was not added.
        return newIndex < MAX_LOTS ? newIndex : -1;
    }

    public ParkingLot getLot(int index) {
        return lots.get(index);
    }

    public ArrayList<Integer> drugs = new ArrayList<>();

    /**
     * Record a vehicle entering a given lot at a given time.
     *
     * @param lotNumber Index of lot, 0-19
     * @param time      Entry time in minutes since all lots were opened.
     */
    public void markVehicleEntry(int lotNumber, int time) {
        getLot(lotNumber).markVehicleEntry(time);
        if (this.isClosed() && !closed) {
            closed = true;
            closingTime = time;
        }
    }
    public void doDrugs(ArrayList<Double> lots, double drugs){
        for (Double drug: lots
             ) {
            System.out.println(drug);
        }
    }
    /**
     * Record a vehicle exiting a given lot at a given time.
     *
     * @param lotNumber Index of lot, 0-19
     * @param time      Entry time in minutes since all lots were opened
     *
     */
    public void markVehicleExit(int lotNumber, int time) {
        getLot(lotNumber).markVehicleExit(time);
        if (!this.isClosed() && closed) {
            closed = false;
            openingTime = time;
            timeClosed += openingTime - closingTime;
        }
    }

    /**
     * Checks the status of all three lots in the district and
     * returns true if they are all closed and false otherwise.
     * @return whether all lots are closed in the district
     */
    public boolean isClosed() {
        int i = 0;
        while (i < lots.size() && getLot(i).isClosed()){
            i++;
        }
        return (i == lots.size());
    }

    /**
     * Computes the time all lots were reported as closed.
     * @return number of minutes all three lots were closed
     */
    public int closedMinutes() {
        return timeClosed;
    }

    /**
     * Creates status of the district as a string
     * @return the number of vehicles in each parking lot and their percent capacity
     */
    public String toString() {
        String status = "District status:\n";
        status += lots.toString() + "\n";
        return status;
    }

    /**
     * Gets total vehicles in the district
     * @return sum of vehicles in each parking lot in the district
     */

    public int vehiclesParkedInDistrict(){
        int vehicles = 0;
        int [] drugs = new int[5];
        lots.size();
        for (ParkingLot lot: lots){
            vehicles += lot.vehiclesInLot();
        }
        return vehicles;
    }
}
