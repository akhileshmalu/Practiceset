package ParkingLot.main;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Akhilesh Maloo
 * @date: 2/6/23.
 */
public class ParkingLot {
    Floor[] floors;
    int zipCode;

    public ParkingLot(int numberOfFloors, int zipCode, int totalCap) {
        this.floors = new Floor[numberOfFloors];
        for (int i = 0; i < numberOfFloors; i++) {
            this.floors[i] = new Floor(i, totalCap/numberOfFloors);
        }
        this.zipCode = zipCode;
    }

    public Map<Integer, Integer> displayAvailability() {
        Map<Integer, Integer> availableSpots = new HashMap<>();
        for (int i = 0; i < floors.length; i++) {
            availableSpots.put(i, floors[i].availableSpots);
        }
        System.out.println(availableSpots);
        return availableSpots;
    }

    public ParkingSpot parkVehicle(Vehicle v) {
        for(Floor f: floors) {
            if(f.getAvailableSpotsForSize(v.spotType) > 0) {
                return f.park(v);
            }
        }
        return null;
    }
    public void removeVehicle(Vehicle v) {
        floors[v.getSpot().getFloorId()].unpark(v);
    }

    public Floor[] getFloors() {
        return floors;
    }

    public void setFloors(Floor[] floors) {
        this.floors = floors;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
