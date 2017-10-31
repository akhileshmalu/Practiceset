package GooglePractice;

import org.junit.Test;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: Akhilesh Maloo
 * @date: 10/16/17.
 */
public class Solution {


    public static int FlowerBloom(int[] P, int K) {

        // write your code in Java SE 8

        TreeSet<Integer> bloomings = new TreeSet();
        int day = 0;

        for (int i = 0; i < P.length; i++) {
            day += 1;
            bloomings.add(P[i]);
            Integer left = bloomings.lower(P[i]);
            Integer right = bloomings.higher(P[i]);

            if (left == null) left = 0;

            if (P[i] - left - 1 == K ||
                    right != null && right - P[i] - 1 == K)
                return day;
        }
        return -1;
    }

    public static int kEmptySlots(int[] flowers, int k) {

        String blooms = new String((new char[flowers.length])).replaceAll("\0", "0");

        String match = new String(new char[k]).replaceAll("\0", "0");

        int day = 0;

        for (int flower : flowers) {
            day++;
            char flw[] = blooms.toCharArray();
            flw[flower - 1] = ' ';

            blooms = new String(flw);

            if (blooms.matches("(.*)" + " " + match + " " + "(.*)"))
                return day;

            /*String[] group = blooms.split(" ");
            int a = 1;
           for(String g: group) {
               if(g.length() == k && blooms.matches("(.*)"+" "+g+" "+"(.*)"))
                   return day;
           }*/

        }
        return -1;

    }


    public String solution(String S) {
        // write your code in Java SE 8

        String hours = S.substring(0, 2);
        String mins = S.substring(3);

        HashSet<Integer> t = new HashSet<>();

        int totalhours = Integer.parseInt(hours) * 60;
        int totalMins = Integer.parseInt(mins);
        int currTime = totalhours + totalMins;

        char[] timeArray = S.toCharArray();

        for (int i = 0; i < timeArray.length; i++) {
            if (timeArray[i] != ':')
                t.add(timeArray[i] - '0');
        }

        while (true) {
            currTime = (currTime + 1) % (24 * 60);
            //convert that into digits

            int[] digits = new int[]{currTime / 60 / 10, currTime / 60 % 10, currTime % 60 / 10, currTime % 60 % 10};

            check:
            {
                for (int digit : digits) {
                    if (!t.contains(digit))
                        break check;
                }
                return String.format("%02d:%02d", currTime / 60, currTime % 60);
            }
        }

    }

    /**
     * Helper Reading and writing STD IN/OUT
     *
     * @param filePath
     * @return
     */
    public void StdInStdOut(String filePath, String output) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output));

            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\t");

            }
            // to write something on file
            bufferedWriter.write("Write in output file");
            bufferedWriter.newLine();


            //close both the pointers
            bufferedWriter.close();
            reader.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    /**
     *
     */
    public void helperScannerStdInOut() {

        Scanner in = new Scanner(System.in);

        // readLine
        String line = in.nextLine();

        // convert words from separator
        String[] words = in.nextLine().split(" ");

        // read Int
        int num = Integer.parseInt(in.nextLine());

        //StdOut
        int i = 0; // testcase number
        System.out.println("Case #" + i + ": ");

        /*
        Mobile key pad Questions

        HashMap<Character, String> keyMap = new HashMap<Character, String>();

        int charIndex = 0;
        for(int index = 0; index <= 9; index++) {
            if(index == 0) {
                keyMap.put(' ',"0");
                index++;
                continue;
            }
            String str = String.valueOf(index);
            keyMap.put((char) (charIndex++ + 'a'),str);
            keyMap.put((char) (charIndex++ + 'a'),str+str);
            keyMap.put((char) (charIndex++ + 'a'),str+str+str);

            if(index == 7 || index == 9) {
                keyMap.put((char) (charIndex++ + 'a'),str+str+str+str);
            }

        }
         */
    }

    public static String reverseWords(String s) {
        s = s.replaceAll("^[\\s]+", "").replaceAll("[\\s]+$", "").replaceAll("[\\s]+", " ");

        if (s.equals(" ")) return "";

        if (s.length() > 0) {
            String[] words = s.split("\\s");
            s = "";
            for (int i = words.length - 1; i >= 0; i--) {
                if (i != words.length - 1) {
                    s += " ";
                }
                s += words[i];
            }
        }
        return s;
    }

    public static String revWords(String s) {
        //s = s.trim();
        char[] letters = s.toCharArray();

        String reversedWord = "";

        for (int i = 0; i < letters.length; i++) {

            while (i < letters.length && letters[i] == ' ') {
                i++;
            }

            if (i < letters.length) {
                String word = "";
                while (i < letters.length && letters[i] != ' ') {
                    word += letters[i];
                    i++;
                }
                reversedWord = " " + word + reversedWord;
            }

        }

        return reversedWord.trim();
    }

    /**
     * Standard Hacker Rank StdIn StdOut Functions.
     *
     * @param args
     */
    public static void main(String[] args) {

        String s = "   a   b ";


        HashMap<Character, Integer> map = new HashMap<>();

        map.put('a', 1);
        map.put('a', 5);

        int a  = -3;
        int b = (Integer.hashCode(a) & 0x7FFFFFFF);

        System.out.println(map.put('a',3));


//        System.out.println(revWords(s));


    }

}
