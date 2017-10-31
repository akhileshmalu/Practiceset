/**
 * @author: Akhilesh Maloo
 * @date: 10/30/17.
 */
public class BestStockPrices {

    public static int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = prices[1]-prices[0];

        for(int i=0; i< prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);

            int potentialProfit = prices[i] - minPrice;

            maxProfit = Math.max(maxProfit, potentialProfit);

        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{17,16,15,13,12,10};

        System.out.println(maxProfit(prices));

    }
}
