import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Exception.*;

class Sol {

    public static boolean arraySumPart(int[] nums) {
        int sum = 0;

        for(int num: nums)
            sum += num;


        if(sum % 2 != 0) return false;

        int by2 = sum/2;

        for(int num : nums) {
            sum -= num;
            if(sum == by2)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,1};

        System.out.println(arraySumPart(nums));




    }
}



