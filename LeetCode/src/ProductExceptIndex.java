import java.util.Arrays;

/**
 * @author: Akhilesh Maloo
 * @date: 10/30/17.
 */
public class ProductExceptIndex {

    public static void getProductsOfAllIntsExceptAtIndex(int[] intArray) {

        if (intArray.length < 2) {
            throw new IllegalArgumentException("Getting the product of numbers at other indices requires at least 2 numbers");
        }

        // we make an array with the length of the input array to
        // hold our products
        int[] productsOfAllIntsExceptAtIndex = new int[intArray.length];

        // for each integer, we find the product of all the integers
        // before it, storing the total product so far each time
        int productSoFar = 1;
        for (int i = 0; i < intArray.length; i++) {
            productsOfAllIntsExceptAtIndex[i] = productSoFar;
            productSoFar *= intArray[i];
        }

        // for each integer, we find the product of all the integers
        // after it. since each index in products already has the
        // product of all the integers before it, now we're storing
        // the total product of all other integers
        productSoFar = 1;
        for (int i = intArray.length - 1; i >= 0; i--) {
            productsOfAllIntsExceptAtIndex[i] *= productSoFar;
            productSoFar *= intArray[i];
        }

        Arrays.stream(productsOfAllIntsExceptAtIndex).forEach(System.out::println);
        //return productsOfAllIntsExceptAtIndex;
    }

    public static void productExceptIndex(int[] nums) {

        int[] productAfterind = new int[nums.length];

        int prod = 1;

        for(int i = 0; i< nums.length; i++) {
            productAfterind[i] = prod;
            prod = prod * nums[i];
        }
        Arrays.stream(productAfterind).forEach( t -> {System.out.print(t + " ");});
        System.out.println(" before index prod");

        prod = 1;
        for(int i = nums.length-1; i >= 0; i--) {
            productAfterind[i] *= prod;
            prod = prod * nums[i];

        }
        Arrays.stream(productAfterind).forEach( t -> {System.out.print(t + " ");});
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,5,3,6};

        productExceptIndex(nums);

        /**
         * 1=1  1=1   1*5=5  1*5*3=15
         *  90*1=90    1*18     5*6=30    15*1 = 15
         */

        //getProductsOfAllIntsExceptAtIndex(nums);

    }
}
