/**
 * @author: Akhilesh Maloo
 * @date: 2/19/18.
 */
public class IntegerToEnglish {

    /*
    static string array need to add space

    */
    static String[] TWENTIES = new String[] {"", " One", " Two", " Three", " Four", " Five", " Six",
            " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve",
            " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen",
            " Eighteen", " Nineteen"};
    static String[] TENS = new String[] {"", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty",
            " Seventy", " Eighty", " Ninety", " Hundred"};
    static String[] THOUSANDS = new String[] {"", " Thousand", " Million", " Billion"};

    /**
     *  2ms solution Iterative
     * @param num
     * @return
     */
    public String numberToWords2(int num) {
        if (num == 0) {
            return "Zero";
        }
        int BASE = 1000;
        String res = "";
        int i = 0;
        while (num != 0) {
            int cur = num % BASE;
            res = helper(cur) + (cur == 0? "": THOUSANDS[i]) + res;
            num = num / BASE;
            i++;
        }
        return res.substring(1, res.length());
    }
    public String helper(int num) {
        if (num < 20) {
            return TWENTIES[num];
        }
        if (num < 100) {
            return TENS[num / 10] + TWENTIES[num % 10];
        }
        return TWENTIES[num / 100] + " Hundred" + helper(num % 100);
    }


     static String[] unitDigit = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten","Eleven",
            "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
//    String[] lessThanTwenty = {};
    static String[] tensDigit = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    // String[] quant = {"Hundred", "Thousand", "Million", "Billion"};

    /**
     * 4 ms solution recursive : Easy to explain
     * @param num
     * @return
     */
    public static String numberToWords(int num) {
        // if(num == 0)
        //     return "Zero";
//        if(num < 10) {
//            return unitDigit[num%10];
//        } else
        if(num < 20) {
            return  unitDigit[num%20];
        } else if(num < 100) {
            return tensDigit[num/10] + ((num%10 == 0)?"":" " + numberToWords(num%10));
        } else if(num < 1000) {
            return  unitDigit[num/100]+ " Hundred" + ((num%100 == 0)?"":" " +numberToWords(num % 100));
        } else if(num < 1000000) {
            return  numberToWords(num/1000)+ " Thousand" + ((num%1000 == 0)?"":" " + numberToWords(num % 1000));
        } else if(num < 1000000000) {
            return  numberToWords(num/1000000)+ " Million" + ((num%1000000 == 0)?"":" " + numberToWords(num % 1000000));
        } else {
            return numberToWords(num/1000000000) + " Billion" + ((num%1000000000 == 0)?"":" " + numberToWords(num % 1000000000));
        }
    }

    public static void main(String[] args) {


        HashClass hclass = new HashClass();

        hclass.insert(1,5);
        hclass.insert(2, 8);
        hclass.insert(1,7);
        hclass.insert(18, 2);


        System.out.println(hclass.getVal(18));

//        System.out.println(numberToWords(1012023));
    }
}
