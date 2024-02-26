package hackathon24;

import java.util.ArrayList;

public class BusManager {

    private static ArrayList<Bus> buses = new ArrayList<>();

    public static void addBus(Bus bus) {
        buses.add(bus);
    }

    public static ArrayList<Bus> getBuses() {
        return buses;
    }

    public static Bus getBusById(int busId) {
        for (Bus bus : buses) {
            if (bus.getId() == busId) {
                return bus;
            }
        }
        return null;
    }

    public static void initializeBuses() {
        buses.add(new Bus(1, "Route 1"));
        buses.add(new Bus(2, "Route 1"));
        buses.add(new Bus(3, "Route 1"));
        buses.add(new Bus(4, "Route 1"));
    }
}
