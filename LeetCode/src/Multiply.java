import java.util.Arrays;

/**
 * @author: Akhilesh Maloo
 * @date: 8/12/20.
 */
public class Multiply {

    public String multiplyFast(String num1, String num2) {
        StringBuilder res = new StringBuilder ();

        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return res.toString();
        }
        if ((num1.length() == 1 && num1.charAt(0) == '0') || (num2.length() == 1 && num2.charAt(0) == '0')) {
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();
        int[] products = new int[len1 + len2]; // ex. 99 * 99 cannot be five-digit num and at most four-digit num
        for (int i = len2 - 1; i >= 0; i--) {
            int digit2 = num2.charAt(i) - '0';
            if (digit2 == 0) {
                continue;
            }

            for (int j = len1 - 1; j >= 0; j--) {
                int digit1 = num1.charAt(j) - '0';
                if (digit1 == 0) {
                    continue;
                }

                products[i + j + 1] += digit2 * digit1;
            }
        }

        Arrays.stream(products).forEach(a -> System.out.print(a + " "));

        int carry = 0;
        for (int i = products.length - 1; i >= 0; i--) {
            int digit = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = digit;
        }

        for (int product : products) {
            res.append(product);
        }

        if (res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        return res.toString();
    }

    public String multiply(String num1, String num2) {
        char[] nums1, nums2;

        StringBuilder stringBuilder = new StringBuilder();

        if(num1.length() > num2.length()) {
            nums1 = num1.toCharArray();
            nums2 = num2.toCharArray();
        } else {
            nums1 = num2.toCharArray();
            nums2 = num1.toCharArray();
        }
        StringBuilder finalResult = new StringBuilder();

        for(int i = nums2.length-1; i>=0; i--) {
            int num2Val = nums2[i]-'0';
            int carry = 0;
            StringBuilder result = new StringBuilder("0");
            for(int j = nums1.length-1; j >=0 ; j--) {
                int num1Val = nums1[j]-'0';
                int interim = ((num2Val * num1Val) + carry);
                if(interim >= 10 && j > 0) {
                    carry = (interim / 10);
                    interim = interim % 10;
                } else {
                    carry = 0;
                }
                result = addStrings(result, new StringBuilder(String.valueOf(interim)) , nums1.length-1-j);
            }
            System.out.println(result);
            finalResult = addStrings(finalResult , result, nums2.length-1-i);
        }

        return finalResult.toString();


    }

    private StringBuilder addStrings(StringBuilder str1, StringBuilder str2, int shiftIndex) {

        while(shiftIndex > 0){
            str2.append("0");
            shiftIndex--;
        }

        StringBuilder result = new StringBuilder();

        int carry = 0;
        for (int i = str1.length()-1, j = str2.length()-1; i >= 0 || j >= 0; i--,j--) {
            int interim = 0, i1, i2;
            if(i >= 0 && j >= 0) {
                i1 = str1.charAt(i) - '0';
                i2 = str2.charAt(j) - '0';
            } else if(i >= 0) {
                i1 = str1.charAt(i) - '0';
                i2 = 0;
            } else {
                i1 = 0;
                i2 = str2.charAt(j) - '0';
            }
            interim = ((i1 + i2) + carry);
            if(interim >= 10 && j > 0) {
                carry = (interim / 10);
                interim = interim % 10;
            } else {
                carry = 0;
            }

            result.insert(0, interim);
        }

        return result;
    }

    public String multiply3(String num1, String num2) {
        if(num1 == null || num2 == null || num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] prods = new int[len1+len2];

        for(int i = len1-1; i>=0; i--) {
            int digit1 = num1.charAt(i) - '0';

            for(int j = len2-1; j >=0; j--) {
                int digit2 = num2.charAt(j) - '0';

                prods[i+j+1] += digit1 * digit2;
            }
        }

        int carry = 0;
        for(int i = prods.length-1; i >= 0; i--) {
            int remainder = (prods[i] + carry) % 10;
            carry = (prods[i] + carry) / 10;
            prods[i] = remainder;
        }
        StringBuilder str = new StringBuilder();
        for(int i = prods.length-1; i>= 0; i--) {
            str.insert(0,prods[i]);
        }

        if (str.charAt(0) == '0') {
            str.deleteCharAt(0);
        }

        return String.valueOf(str.toString());
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        System.out.println(multiply.multiply3("2","3"));
    }
}

/**
 *
 *          48
 *          15
 *       20,40
 *     4,8
 *     4,28,40
 *   7 ,  2,  0
 */