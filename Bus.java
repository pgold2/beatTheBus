package hackathon24;

import java.util.Random;

public class Bus {

    private int id;
    private String routeNumber;
    private int driverId;
    private int occupancy;
    private int currentStop;

    // Default constructor
    public Bus() {
    }

    // Parameterized constructor
    public Bus(int id, String routeNumber) {
        this.id = id;
        this.routeNumber = routeNumber;
        this.driverId = driverId;
        this.occupancy = getRandomNumber();
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Setter for ID
    public void setId(int id) {
        this.id = id;
    }

    // Getter for route number
    public String getRouteNumber() {
        return routeNumber;
    }

    // Setter for route number
    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    // Getter for occupancy
    public int getOccupancy() {
        return occupancy;
    }

    // Setter for occupancy
    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

    private int getRandomNumber() {
        Random randomGenerator = new Random();
        // Generate random integers in the range 0 to 60
        //automatically greater than 55 to simulate the scenario
        return randomGenerator.nextInt(5) + 55;
    }

    // Getter for current stop
    public int getCurrentStop() {
        return currentStop;
    }

    // Setter for current stop
    public void setCurrentStop(int currentStop) {
        this.currentStop = currentStop;
    }

    // Method to simulate if the bus should stop at the current stop based on occupancy
    public boolean shouldStop() {
        return occupancy < 60;
    }

    public void stopAtCurrentStop() {
        System.out.println("Bus " + id + " is stopping at " + currentStop);
        // Additional logic if needed
    }

    // Method to simulate the bus passing by a stop without stopping
    public void passCurrentStop() {
        System.out.println("Bus " + id + " is passing by " + currentStop);
        // Additional logic if needed
    }

    // Method to simulate the bus stopping at a specific stop
    public void stopAt(int stopNumber) {
        // Update internal state of the bus, such as recording the stop
        currentStop = stopNumber;

        // Add any additional logic related to stopping at a particular stop
        System.out.println("Bus stopped at Stop " + stopNumber);
    }

    public int getCurrentLocation() {
        return currentStop;
    }

}
