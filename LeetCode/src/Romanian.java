import com.sun.java.swing.plaf.windows.WindowsTreeUI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Created by akhi on 6/4/17.
 */
public class Romanian {

    public Map<Integer, Character> decimalCodes = new HashMap<Integer, Character>() {{
        put(1, 'I');
        put(4, 'F');
        put(5, 'V');
        put(9, 'N');
        put(10, 'X');
        put(50, 'L');
        put(100, 'C');
        put(500, 'D');
        put(1000, 'M');
    }};

//    public Map<Integer, String> decimalCodes2 = new HashMap<Integer, String>() {{
//        put(1, "I");
//        put(4, "IV");
//        put(5, "V");
//        put(9, "IX");
//        put(10, "X");
//        put(40, "XL");
//        put(50, "L");
//        put(90, "XC");
//        put(100, "C");
//        put(400, "CD");
//        put(500, "D");
//        put(900, "DM");
//        put(1000, "M");
//    }};

    public Map<Character, Integer> romanLiterals = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};
    public StringBuilder subStr = new StringBuilder();

    public int RomanToInt(String s) {

        char[] romanChars = s.toCharArray();
        int len = s.length() - 1;
        int[] decNum = new int[len + 1];

        int number = 0;

        for (int i = 0; i <= len; i++) {
            decNum[i] = romanLiterals.get(romanChars[i]);
        }
        for (int i = 0; i <= len; i++) {
            if (i < len && decNum[i] < decNum[i + 1]) {
                number -= decNum[i];
                continue;
            }
            number += decNum[i];
        }
        System.out.println(number);

        return number;
    }

    public String IntToRoman(int num) {

        // D combines with X
        Map<Integer, Character> decimalCodes = new HashMap<Integer, Character>() {{
            put(1, 'I');
            put(4, 'F');
            put(5, 'V');
            put(9, 'N');
            put(10, 'X');
            put(50, 'L');
            put(100, 'C');
            put(500, 'D');
            put(1000, 'M');
        }};
        StringBuilder str = new StringBuilder();
        int[] romanKeys = {1000, 500, 100, 50, 10, 5, 1};
        int i = 0;
        while (num > 0) {
            if (num == 4) {
                str.append("IV");
                num -= 4;
            }
            if (num == 9) {
                str.append("IX");
                num -= 9;
            }
            if (num >= 40 && num < 50) {
                str.append("XL");
                num -= 40;
            }
            if (num >= 90 && num < 100) {
                str.append("XC");
                num -= 90;
            }
            if (num >= 400 && num < 500) {
                str.append("CD");
                num -= 400;
            }
            if (num >= 900 && num < 1000) {
                str.append("CM");
                num -= 900;
            }

            if (num - romanKeys[i] >= 0) {

                str.append(decimalCodes.get(romanKeys[i]));
                num -= romanKeys[i];

                if (num < romanKeys[i]) {
                    i++;
                }
            } else {
                i++;
            }
        }

        return str.toString();
    }

    public String IntToRomAlt(int num) {

        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Romanian roman = new Romanian();
        System.out.println(roman.IntToRomAlt(roman.RomanToInt("IV")));
        roman.IntToRomAlt(49);


    }
}
