package GooglePractice;

import javafx.util.Pair;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
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

    public void printCleanScript() {

        String k = "Hello Akhilesh <script> doc game doc  game </script> game You <script> game Not good </script> Great";
        String l = "doc </script> game";

        String[] words = {"Hello Akhilesh <script> doc game doc  game </script>maloo",
                "You <script> game",
                " Not good",
                "doc </script> Great"};

        Pattern full = Pattern.compile("<script.*/script>");
        Pattern open = Pattern.compile("<script.*>");
        Pattern close = Pattern.compile("</script.*>");

        boolean isOpen = false;

        // change this to buffered reader stream
        for (String w : words) {
            Matcher mFull = full.matcher(w);
            Matcher mOpen = open.matcher(w);
            Matcher mclose = close.matcher(w);

            if (mFull.find()) {
                /* if collect all lines in one string and run it though
                for(String wd : k.split("</script>") ) {
                    String ws[] = wd.split("<script.*>");
                    System.out.println(ws[0]);
                }
                */
                System.out.print(w.replaceAll(mFull.group(0), ""));
            } else if (mOpen.find()) {
                isOpen = !isOpen;
                System.out.print(w.substring(0, w.indexOf(mOpen.group(0))));
            } else if (mclose.find()) {
                isOpen = !isOpen;
                System.out.print(w.substring(w.indexOf(mclose.group(0)) + 9));
            } else {
                if (!isOpen)
                    System.out.println(k);
            }

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

        if (n < 2) return n;

        int last = 1;
        int slast = 0;
        int currPos = 2;

        while (currPos++ < n) {
            int sum = last + slast;
            slast = last;
            last = sum;

        }

        return last;
    }

    static void combine(String instr, StringBuffer outstr, int index) {
        for (int i = index; i < instr.length(); i++) {
            outstr.append(instr.charAt(i));
            System.out.println(outstr);
            combine(instr, outstr, i + 1);
            outstr.deleteCharAt(outstr.length() - 1);
        }
    }

    public static String reverseRecursion(String in, int i) {
        if (i < 0)
            return "";
        else
            return in.charAt(i) + reverseRecursion(in, i + 1);
    }

    public static int removeDuplicates(int[] nums) {
        int last = nums[0];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                len++;
            }
        }
        return len;
    }

    public int hashCode(String s, String s2) {
        int res = 0;
        int i = 0, j = 0;

        while (i < s.length() && j < s2.length()) {

            if (Character.isDigit(s.charAt(i)) && Character.isDigit(s2.charAt(j))) {

                int first[] = stoi(s, i);
                i = first[1] - 1;

                int sec[] = stoi(s2, j);
                j = sec[1] - 1;

                res = compareTo(first[0], sec[0]);
                if (res != 0)
                    return res;

            } else {
                res = compareTo(s.charAt(i), s.charAt(j));
                if (res != 0)
                    return res;
            }

            i++;
            j++;
        }

        return (i == s.length()) ? -1 : 1;
    }

    public int compareTo(int a, int b) {
        if (a < b)
            return -1;
        else if (a > b)
            return 1;
        else
            return 0;
    }

    public int[] stoi(String k, int i) {
        int out = 0;

        while (i < k.length() && Character.isDigit(k.charAt(i))) {
            out = (out * 10) + (k.charAt(i) - '0');
            i++;
        }

        return new int[]{out, i};
    }


    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0)
            return -1;

        if (matrix.length == 1)
            return matrix[0][k - 1];

        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low < high) {

            int mid = low + ((high - low) / 2);
            int count = 0;

            // check every array and find total number of items less than mid
            for (int i = 0; i < matrix.length; i++) {
                count += bst(matrix[i], mid) + 1;
            }
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int bst(int[] mat, int mid) {
        int tmp = 0;
        for (int i = mat.length - 1; i >= 0; i--) {
            if (mat[i] <= mid)
                return i;
        }
        return -1;
    }


    /**
     * Standard Hacker Rank StdIn StdOut Functions.
     *
     * @param args
     */
    public static void main(String[] args) {

        Solution sol = new Solution();


       StringBuilder str = new StringBuilder();



    }

}
