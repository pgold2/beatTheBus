package hackathon24;

import java.util.Scanner;

public class Bunching {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. On the bus \n2. At the bus stop");
        int choice = scan.nextInt();

        if (choice == 1) {
            StopStatus state = StopStatus.PRESSED;
            System.out.println("Enter information below: ");
            System.out.println("Enter the bus stop ID");
            String stopID = scan.next();
            Stop stopObj = new Stop(stopID);
            System.out.println("Stop ID: " + stopObj.getStopId());
            // Notify the bus to stop at this stop
            notifyBus(BusManager.getBuses().get(0), stopObj); // Assuming the first bus, update it accordingly
        } else if (choice == 2) {
            ComeStatus state = ComeStatus.PRESSED;
            System.out.println("Enter information below: ");
            System.out.println("Enter the bus stop ID you are at");
            String comeID = scan.next();
            Come comeObj = new Come(comeID);
            System.out.println("Stop ID: " + comeObj.getStopId());
            // Request a bus to come
            requestBusCome(BusManager.getBuses().get(0), comeObj); // Assuming the first bus, update it accordingly
        } else {
            System.out.println("Sorry, wrong choice...");
        }
    }

    // Notify the bus to stop at the requested stop
    private static void notifyBus(Bus bus, Stop stop) {
        if (bus.getCurrentStop() == Integer.parseInt(stop.getStopId())) {
            if (bus.shouldStop()) {
                bus.stopAtCurrentStop();
            } else {
                bus.passCurrentStop();
            }
        }
    }

    // Request a bus to come to the requested stop
    private static void requestBusCome(Bus bus, Come come) {
        Dispatcher.accept(bus, come);
        Dispatcher.findDistance(bus, come);
    }
}
