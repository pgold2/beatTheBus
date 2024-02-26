package hackathon24;

public class Stop implements RequestInterface {
    private String stopId;

    // Constructor
    public Stop(String stopId) {
        this.stopId = stopId;
    }

    // Getter for stopId
    public String getStopId() {
        return stopId;
    }

    // Setter for stopId
    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public static void main(String[] args) {
        // Example usage
        Stop busStop = new Stop("BusStop1");

        // Make a stop request
        busStop.stopRequest(busStop.getStopId(), 1); // Assuming bus location number is 1, update it accordingly

        // Check the status of the stop
        System.out.println("Status of " + busStop.getStopId() + ": " + busStop.getStatus(busStop.getStopId()));

        // Undo the stop request
        busStop.undoRequest(busStop.getStopId());

        // Check the status again
        System.out.println("Status after undo: " + busStop.getStatus(busStop.getStopId()));

        // Get and set bus location number
        System.out.println("Bus location number: ");
        System.out.println("Updated bus location number: ");
    }
}
