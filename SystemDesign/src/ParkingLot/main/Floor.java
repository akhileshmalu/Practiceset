package ParkingLot.main;

/**
 * @author: Akhilesh Maloo
 * @date: 2/6/23.
 */
public class Floor {
    int floorNo;
    ParkingSpot[] parkingSpots;
    int availableSpots;

    public Floor(int floorNo, int cap) {
        this.floorNo = floorNo;
        this.parkingSpots = new ParkingSpot[cap];
        int large = cap / 4;
        int med = cap / 4;
        int small = cap - large - med;
        availableSpots = cap;
        for (int i = 0; i < parkingSpots.length; i++) {
            ParkingSpot spot = null;
            if(i < small) {
                spot = new ParkingSpot(i, ParkingSpotType.Small, floorNo);
            } else if(i < small + med) {
                spot = new ParkingSpot(i, ParkingSpotType.Medium, floorNo);
            } else {
                spot = new ParkingSpot(i, ParkingSpotType.Large, floorNo);
            }
            parkingSpots[i] = spot;
        }
    }

    public ParkingSpot park(Vehicle vehicle) {
        for(ParkingSpot spot: parkingSpots) {
            if(vehicle.getSpotType().equals(spot.getSpotType()) && !spot.isOccupied) {
//                vehicle.setSpot(spot);
                this.availableSpots--;
                return spot.bookSpot(vehicle);
            }
        }
        return null;
    }

    public int getAvailableSpotsForSize(ParkingSpotType type) {
        int availableSpot = 0;
        for(ParkingSpot spot: parkingSpots) {
            if(type.equals(spot.getSpotType()) && !spot.isOccupied) {
                availableSpot++;
            }
        }
        return availableSpot;
    }

    public void unpark(Vehicle vehicle) {
        if(vehicle != null) {
            ParkingSpot spot = vehicle.getSpot();
            spot.freeSpot();
            this.availableSpots++;
        }
    }
}
