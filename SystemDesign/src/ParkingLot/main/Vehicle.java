package ParkingLot.main;

/**
 * @author: Akhilesh Maloo
 * @date: 2/6/23.
 */
public class Vehicle {
    String licensePlate;
    ParkingSpot spot;
    ParkingSpotType spotType;

    public Vehicle(String licensePlate, ParkingSpotType spotType) {
        this.licensePlate = licensePlate;
        this.spotType = spotType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public void setSpot(ParkingSpot spot) {
        this.spot = spot;
    }

    public ParkingSpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(ParkingSpotType spotType) {
        this.spotType = spotType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", spot=" + spot +
                ", spotType=" + spotType +
                '}';
    }
}
