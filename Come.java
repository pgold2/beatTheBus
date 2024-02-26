package hackathon24;

public class Come implements RequestInterface {
    private String stopId;

    // Constructor
    public Come(String stopId) {
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

    // Additional methods specific to the Come class can be added here

    public static void main(String[] args) {
        // Example usage
        Come comeRequest = new Come("BusStop1");

        // Make a come request
        comeRequest.comeRequest(comeRequest.getStopId());

        // Check the status of the stop
        System.out.println("Status of " + comeRequest.getStopId() + ": " + comeRequest.getStatus(comeRequest.getStopId()));

        // Undo the come request
        comeRequest.undoRequest(comeRequest.getStopId());

        // Check the status again
        System.out.println("Status after undo: " + comeRequest.getStatus(comeRequest.getStopId()));

        // Get and set bus location number
        System.out.println("Bus location number: ");
        System.out.println("Updated bus location number: ");
    }
}
