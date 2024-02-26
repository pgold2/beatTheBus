package hackathon24;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bus Route 1");

        BusManager.initializeBuses();  // Initialize buses using BusManager

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Request Bus Stop");
            System.out.println("2. Stop the Bus");
            System.out.println("3. Undo a Stop");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                requestBusStop();
            } else if (choice == 2) {
                stopTheBus();
            } else if (choice ==3) {
                System.out.println("Undoing your request to alight. \nBus will not stop");
            } else if (choice == 4) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void requestBusStop() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Ticket ID ");
        String ticketId = scanner.nextLine();

        System.out.print("Enter Bus ID for stop request: ");
        int busId = scanner.nextInt();

        System.out.print("Enter Stop Number to request: ");
        int stopNumber = scanner.nextInt();

        Bus requestedBus = BusManager.getBusById(busId);

        if (requestedBus != null) {
            System.out.println("Bus " + requestedBus.getId() + " requested to stop at Stop " + stopNumber);

            //Simulate adding a person to the bus's occupancy
            int currentOccupancy = requestedBus.getOccupancy();

            if (currentOccupancy < 60) {
                requestedBus.stopAt(stopNumber);

                if (currentOccupancy + 1 <= 60) {
                    requestedBus.setOccupancy(currentOccupancy + 1);
                } else {
                    System.out.println("Bus is full, cannot add more passengers.");
                    System.out.println("Sending request to the closest available bus.");
                    Bus closestBus = Dispatcher.findClosestBus(stopNumber);
                    if (closestBus != null) {
                        System.out.println("Request sent to Bus " + closestBus.getId());
                    }
                }

                printCurrentOccupancy(requestedBus);
            } else {
                System.out.println("Bus is already full. Sending request to the closest available bus.");
                Bus closestBus = Dispatcher.findClosestBus(stopNumber);
                if (closestBus != null) {
                    System.out.println("Request sent to Bus " + closestBus.getId());
                }
            }
        } else {
            System.out.println("Bus not found. Please enter a valid Bus ID.");
        }
    }

    private static void stopTheBus() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Bus ID to stop: ");
        int busId = scanner.nextInt();

        Bus busToStop = BusManager.getBusById(busId);

        if (busToStop != null) {
            busToStop.stopAtCurrentStop();

            // Simulate removing a person from the bus's occupancy
            int currentOccupancy = busToStop.getOccupancy();
            if (currentOccupancy > 0) {
                busToStop.setOccupancy(currentOccupancy - 1);
            }

            printCurrentOccupancy(busToStop);
        } else {
            System.out.println("Bus not found. Please enter a valid Bus ID.");
        }
    }


    private static void printCurrentOccupancy(Bus bus) {
        System.out.println("Current Occupancy of Bus " + bus.getId() + ": " + bus.getOccupancy());
    }
}
