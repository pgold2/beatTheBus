package hackathon24;

import java.util.HashMap;
import java.util.Map;

public interface RequestInterface {
    // Declare the busStops map
    public static final Map<String, Boolean> busStops = new HashMap<>();

    // Default constructor not allowed in interface, so removed
    // Removed static keyword from methods as interfaces don't have static methods

    default void stopRequest(String stopId) {
        busStops.put(stopId, false); // Mark the stop as not needing the bus
        System.out.println("Stop request received for stop " + stopId);
        // Here you can include logic to send a notification to the bus system
    }

    default void comeRequest(String stopId) {
        busStops.put(stopId, true); // Mark the stop as needing the bus
        System.out.println("Come request received for stop " + stopId);
        // Here you can include logic to notify the bus to come to this stop
    }

    default boolean getStatus(String stopId) {
        return busStops.getOrDefault(stopId, false); // Default to false if the stop is not in the map
    }

    public static void main(String[] args) {
        RequestInterface requestInterface = new RequestInterface() {}; // Anonymous implementation of interface
        requestInterface.stopRequest("A");
        requestInterface.comeRequest("B");
        System.out.println("Status of stop A: " + requestInterface.getStatus("A")); // Should print false
        System.out.println("Status of stop B: " + requestInterface.getStatus("B")); // Should print true
    }
}
