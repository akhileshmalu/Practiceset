package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You brought a duffel bag that can hold limited weight, and you want to make off with the most valuable haul possible.
 * Write a method maxDuffelBagValue() that takes an array of cake type objects and a weight capacity,
 * and returns the maximum monetary value the duffel bag can hold
 *
 * @author: Akhilesh Maloo
 * @date: 2/6/18.
 */
public class CakeThiefDP {
    static class CakeType {

        int weight;
        int value;

        public CakeType(int weight, int value) {
            this.weight = weight;
            this.value  = value;
        }
    }

    /**
     * Dynamic Programming Solution
     *
     * @param cakes
     * @param bagCap
     * @return
     */
    public static int maxProfit(CakeType[] cakes, int bagCap) {
        if(bagCap == 0)
            return 0;

        Arrays.sort(cakes, new Comparator<CakeType>() {
            @Override
            public int compare(CakeType o1, CakeType o2) {
                return o1.weight - o2.weight;
            }
        });

        // for sake for simple calculation using  + 1 size
        int[][] dp = new int[cakes.length][bagCap+1];
        int maxProfit = 0;


        for (int i = 0; i < cakes.length; i++) {
            for(int j = 1; j <= bagCap; j++) {

                if(cakes[i].weight == 0 || cakes[i].value == 0)
                    throw new IllegalArgumentException("Zero weight is not allowed");
                int possibleUnits = j  / cakes[i].weight;

                // calculate by calculating current cake profit + maxprofit from remaining capacity
                int profit = (possibleUnits * cakes[i].value) + dp[i][bagCap - j];

                if(i == 0) {
                    dp[i][j] = profit;
                } else {
                    dp[i][j] = Math.max(profit, dp[i-1][j]);
                }
                maxProfit = Math.max(maxProfit, dp[i][j]);
            }
        }

        //        Arrays.stream(dp).forEach(t -> {Arrays.stream(t).forEach(p -> System.out.print(p + " "));
//            System.out.println();});

        return maxProfit;
    }


    public static long maxProfitKnapSack(CakeType[] cakeTypes, int weightCapacity) {
        // we make an array to hold the maximum possible value at every
        // duffel bag weight capacity from 0 to weightCapacity
        // starting each index with value 0
        long[] maxValuesAtCapacities = new long[weightCapacity + 1];

        for (int currentCapacity = 0; currentCapacity <= weightCapacity; currentCapacity++) {

            // set a variable to hold the max monetary value so far for currentCapacity
            long currentMaxValue = 0;

            for (CakeType cakeType : cakeTypes) {

                // if the current cake weighs as much or less than the current weight capacity
                // it's possible taking the cake would get a better value
                if (cakeType.weight <= currentCapacity) {

                    // so we check: should we use the cake or not?
                    // if we use the cake, the most kilograms we can include in addition to the cake
                    // we're adding is the current capacity minus the cake's weight. we find the max
                    // value at that integer capacity in our array maxValuesAtCapacities
                    long maxValueUsingCake = cakeType.value + maxValuesAtCapacities[currentCapacity - cakeType.weight];

                    // now we see if it's worth taking the cake. how does the
                    // value with the cake compare to the currentMaxValue?
                    currentMaxValue = Math.max(maxValueUsingCake, currentMaxValue);
                }
            }

            // add each capacity's max value to our array so we can use them
            // when calculating all the remaining capacities
            maxValuesAtCapacities[currentCapacity] = currentMaxValue;

//            Arrays.stream(maxValuesAtCapacities).forEach(p -> System.out.print(p + " "));
//            System.out.println();

        }
        return maxValuesAtCapacities[weightCapacity];
    }


    public static void main(String[] args) {
        CakeType[] cakes = new CakeType[] {
          new CakeType(7, 160),
                new CakeType(3,90),
                new CakeType(2,15),
        };

        System.out.println(maxProfitKnapSack(cakes, 20));
    }

}
