package hackathon24;

public class Bus {

    private int id;
    private int routeNumber;
    private int driverId;
    private String driverName;
    private int occupancy;

    // Default constructor
    public Bus() {
    }

    // Parameterized constructor
    public Bus(int id, int routeNumber, int driverId, String driverName, int occupancy) {
        this.id = id;
        this.routeNumber = routeNumber;
        this.driverId = driverId;
        this.driverName = driverName;
        this.occupancy = occupancy;
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
    public int getRouteNumber() {
        return routeNumber;
    }

    // Setter for route number
    public void setRouteNumber(int routeNumber) {
        this.routeNumber = routeNumber;
    }

    // Getter for driver ID
    public int getDriverId() {
        return driverId;
    }

    // Setter for driver ID
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    // Getter for driver name
    public String getDriverName() {
        return driverName;
    }

    // Setter for driver name
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    // Getter for occupancy
    public int getOccupancy() {
        return occupancy;
    }

    // Setter for occupancy
    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }
}
