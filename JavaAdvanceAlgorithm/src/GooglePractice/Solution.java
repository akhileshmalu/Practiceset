package GooglePractice;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: Akhilesh Maloo
 * @date: 10/16/17.
 */
public class Solution {

    public String solution(String S) {

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
     * Helper Reading and writing STD IN/OUT
     *
     * @param filePath
     * @return
     */
    public void StdInStdOutFilePath(String filePath, String output) {

        Path src = Paths.get(filePath);
        Path target = Paths.get(output);

        Charset charSet = Charset.forName("US-ASCII");


        try (BufferedReader reader = Files.newBufferedReader(src, charSet);
             BufferedWriter writer = Files.newBufferedWriter(target);
            ) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\t");

            }
            // to write something on file
            writer.write("Write in output file");
            writer.newLine();

            //close both the pointers
            writer.close();
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


    public int fibonaci(int n) {

        // 0 1 1 2 3 5 8 13 21      => 4th pos number is 2

        if(n < 2) return n;

        int last = 1;
        int slast = 0;
        int currPos = 2;

        while(currPos < n) {
            int sum = last + slast;
            slast = last;
            last = sum;

            currPos++;
        }

        return last;
    }

    public int fib(int n) {
        int[] f = new int[n];
        fibIterative(n-1, f);
        return f[n-1];
    }

    public int fibIterative(int n, int[] f) {
        if(n < 2) {
            f[n] = n;
            return n;
        }

        if(f[n] == 0) {
            f[n] = fibIterative(n-1, f) + fibIterative(n-2, f);
        }

        return f[n];
    }

    /**
     * Standard Hacker Rank StdIn StdOut Functions.
     *
     * @param args
     */
    public static void main(String[] args) {

        Solution sol = new Solution();
        //90f6cd7d-4d59-41a5-b7d0-693bb49a3bbc


        //Potassium - MY -Z-  trimer


        //uranium


    }

}
