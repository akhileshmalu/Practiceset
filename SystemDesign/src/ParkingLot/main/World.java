package ParkingLot.main;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Akhilesh Maloo
 * @date: 2/6/23.
 */
public class World {
    ParkingLot lot;
    List<Vehicle> vehicles;

    public World() {
        this.lot = new ParkingLot(1, 95136, 40);
        vehicles = Arrays.asList(
                new Vehicle("ABC101", ParkingSpotType.Small),
                new Vehicle("ABC102", ParkingSpotType.Small),
                new Vehicle("ABC103", ParkingSpotType.Small),
                new Vehicle("ABC104", ParkingSpotType.Medium),
                new Vehicle("ABC105", ParkingSpotType.Medium),
                new Vehicle("ABC106", ParkingSpotType.Medium),
                new Vehicle("ABC107", ParkingSpotType.Large),
                new Vehicle("ABC108", ParkingSpotType.Large),
                new Vehicle("ABC109", ParkingSpotType.Large)
        );
    }

    public ParkingLot getLot() {
        return lot;
    }

    public void setLot(ParkingLot lot) {
        this.lot = lot;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public static void main(String[] args) {
        World helloWorld = new World();
        ParkingLot lot = helloWorld.getLot();
        for (Vehicle vehicle: helloWorld.vehicles) {
            lot.displayAvailability();
            System.out.println("Parking " + vehicle);
            vehicle.setSpot(lot.parkVehicle(vehicle));
        }

        for (Vehicle vehicle: helloWorld.vehicles) {
            lot.displayAvailability();
            System.out.println("Removing " + vehicle);
            lot.removeVehicle(vehicle);
            vehicle.setSpot(null);
        }


    }
}
