package hackathon24;

import java.util.HashMap;
import java.util.Map;

public interface RequestInterface {
    Map<String, Boolean> busStops = new HashMap<>();

    default void stopRequest(String stopId, int busLocationNumber) {
        busStops.put(stopId, false);
        System.out.println("Stop request received for stop " + stopId + " at bus location number " + busLocationNumber);
        // Additional logic if needed
    }

    default void comeRequest(String stopId) {
        busStops.put(stopId, true);
        System.out.println("Come request received for stop " + stopId);
        // Additional logic if needed
    }

    default boolean getStatus(String stopId) {
        return busStops.getOrDefault(stopId, false);
    }

    default void undoRequest(String stopId) {
        busStops.remove(stopId);
        System.out.println("Undo request for stop " + stopId);
        // Additional logic
    }

    default void markStopRequested(int stopNumber) {
        busStops.put(String.valueOf(stopNumber), true);
    }

    default boolean isStopRequested(int stopNumber) {
        return busStops.getOrDefault(String.valueOf(stopNumber), false);
    }
}