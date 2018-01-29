package DynamicPragramming;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author: Akhilesh Maloo
 * @date: 1/16/18.
 */
public class RiverCrossing {


    public boolean crossingUtil(int[] r, int pos, int speed) {


        if(pos >= r.length) {
            return true;
        }
        if(r[pos] == 0)
            return false;

        if(!(crossingUtil(r, pos + speed + 1, speed+1 )
                && crossingUtil(r, pos  + speed, speed )
                && crossingUtil(r, pos + speed - 1, speed-1)))
            return false;

        return true;
    }

    public boolean canCrossRiver(int[] r) {

//        return crossingUtil(r, 0, 1);


        //HashMap<Integer, Integer> dp = new HashMap<>();

        boolean[][] dp = new boolean[r.length][r.length];

        dp[0][0] = true;
        for (int i = 1; i < r.length; i++) {
            if(r[i] == 0)
                continue;

            for(int speed = 1; speed < i+1; speed++) {
                if(dp[i-speed][speed] || dp[i-speed][speed-1] || dp[i-speed][speed+1])
                    dp[i][speed] = true;

                if(i == r.length-1)
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        RiverCrossing rv = new RiverCrossing();

        int[] river = {1, 0, 1, 0, 1, 0};




        System.out.println(rv.canCrossRiver(river));

    }
}
