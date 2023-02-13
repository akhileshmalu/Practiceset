package ParkingLot.main;

/**
 * @author: Akhilesh Maloo
 * @date: 2/6/23.
 */
public class ParkingSpot {
    int spotId;
    int floorId;
    Vehicle vehicle;
    ParkingSpotType spotType;
    boolean isOccupied;

    public ParkingSpot(int spotId, ParkingSpotType spotType, int floorId) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.floorId = floorId;
    }

    public ParkingSpot bookSpot(Vehicle vehicle) {
        vehicle.setSpot(this);
        this.setOccupied(true);
        return this;
    }

    public void freeSpot() {
        this.setVehicle(null);
        this.setOccupied(false);
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public ParkingSpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(ParkingSpotType spotType) {
        this.spotType = spotType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotId=" + spotId +
                ", floorId=" + floorId +
                ", spotType=" + spotType +
                '}';
    }
}
