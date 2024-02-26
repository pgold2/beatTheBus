package hackathon24;


import java.util.ArrayList;

public class Dispatcher {

    public static Bus findClosestBus(int stopNumber) {
        // Your logic to find the closest bus based on stopNumber
        // This is just a placeholder, you should implement your own logic
        ArrayList<Bus> buses = BusManager.getBuses();
        Bus closestBus = null;
        int minDifference = Integer.MAX_VALUE;

        for (Bus bus : buses) {
            int difference = Math.abs(bus.getCurrentLocation() - stopNumber);
            if (difference < minDifference) {
                minDifference = difference;
                closestBus = bus;
            }
        }

        // Simulate adding a person to the closest bus's occupancy
        if (closestBus != null) {
            int currentOccupancy = closestBus.getOccupancy();
            if (currentOccupancy + 1 <= 60) {
                closestBus.setOccupancy(currentOccupancy + 1);
            } else {
                System.out.println("Closest bus " + closestBus.getId() + " is full, cannot add more passengers.");
                closestBus = null; // No available bus
            }
        }

        return closestBus;
    }

    // Accept the bus arrival at the come location
    public static void accept(Bus bus, Come come) {
        System.out.println("Bus " + bus.getId() + " accepted the request at Stop " + come.getStopId());
    }

    // Find the distance between the bus and the come location
    public static void findDistance(Bus bus, Come come) {
        int distance = Math.abs(bus.getCurrentStop() - Integer.parseInt(come.getStopId()));
        System.out.println("Distance between Bus " + bus.getId() + " and Stop " + come.getStopId() + ": " + distance);
    }
}
