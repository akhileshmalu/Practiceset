/**
 * @author: Akhilesh Maloo
 * @date: 10/1/17.
 */
public class EggDrop {

    public static int breakerFloor = 999, totalEggs = 2;

    /** Version where we have total 2 eggs and a helper function which will yield if egg breaks or not;
     * @analysis:  O(sqrt(2n-3))   =  (-1 +/- sqrt(2n-3))/2 ; Quadratic formula for above equations
     *
     * below code will run in total k+1 times where first (k)*(k+1) > N/2 ;e.g. 15 trials for 100 floor
     *
     * @param totalFloors total number of floors in building
     */
    public static void eggDrop(int totalFloors) {

        int intialFloor = 1;
        // calculate total number of trails required in worst case for puzzle to solve
        while ((intialFloor * (intialFloor + 1))/2 < totalFloors) {
            intialFloor++;
        }

        // execution for any floor break;
        int count = 1;  // count shows worst case runtime of algorithm
        int currFloorVisit = intialFloor;
        int lastFloorVisited = 0;

        while (totalEggs > 0) {
            if (eggBreakCheck(currFloorVisit)) {
                System.out.println("First Egg Broken at floor: " + currFloorVisit);
                break;
            }
            lastFloorVisited = currFloorVisit;
            currFloorVisit += intialFloor - count;       // next jump of floors
            count++;                                    // adjust waste trials
        }
        for(int i = lastFloorVisited; i<= currFloorVisit; i++) {
            if(eggBreakCheck(i)) { System.out.println("First Floor to break Egg was " + i + " Total Trails were " + count);
            break;
            }
            count++;
        }
    }

    /**
     * Helper function which has breakFloor real value ; disguised in puzzle
     * @param i
     * @return
     */
    public static boolean eggBreakCheck(int i) {
        if (i >= breakerFloor) {
            totalEggs--;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        eggDrop(1000);
    }
}
