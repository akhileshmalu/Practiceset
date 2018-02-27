package DynamicProgramming;

import java.util.*;

/**
 * @author: Akhilesh Maloo
 * @date: 1/16/18.
 */
public class RiverCrossing {

    // map which contains currentPosition & speed require to cross river; This is not required for operation but show answers
    HashMap<Integer, Integer> sp2 = new HashMap<>();

    public boolean canCrossRiver2(int[] r) {

        // edge cases : if first value is in accessible or empty array
        if(r.length == 0 || r[0] == 0)
            return false;

        // if only one value which has to be 1
        if(r.length == 1)
            return true;

        return dfs(1, 0, r);
    }

    public boolean dfs(int speed, int currPos, int[] r) {

        if(currPos >= r.length) {
            return true;
        }

        if(r[currPos] == 0)
            return false;

        // traverse for all 3 available speeds
        for (int newSpeed = speed-1; newSpeed <= speed+1 ; newSpeed++) {

            if(newSpeed <= 0)
                continue;

            if(((currPos+newSpeed) < r.length && r[currPos+newSpeed] == 1) || (currPos+newSpeed) >= r.length) {

                // storing our current possible moves with speed
                sp2.put(currPos,newSpeed);

                // traverse deep inside if current position can be achieved
                if(dfs(newSpeed,currPos+newSpeed,r))
                    return true;
                else {
                    //back track and remove invalid paths
                    sp2.remove(currPos);
                }
            }


        }
        return false;
    }

    public static void main(String[] args) {
        RiverCrossing rv = new RiverCrossing();

        int[] river = {1,0,1,1,1,0,0};

        System.out.println(rv.canCrossRiver2(river));
        System.out.println(rv.sp2);

    }
}
