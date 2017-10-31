import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author: Akhilesh Maloo
 * @date: 9/16/17.
 */
public class LevenshteinDistance {
    public static int ins = 1, del = 1, sub = 1, cp = 0;

    public int getEditDist(String first, String sec) {

        int[][] dist = new int[first.length() + 1][sec.length() + 1];

        for (int i = 0; i < dist[0].length; i++) {
            dist[0][i] = i * ins;
        }

        for (int i = 0; i < dist.length; i++) {
            dist[i][0] = i * del;
        }

        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= sec.length(); j++) {

                if (first.charAt(i - 1) == sec.charAt(j - 1)) {

                    dist[i][j] = dist[i - 1][j - 1] + cp;

                } else {

                    dist[i][j] = getMinimum(
                            dist[i][j - 1] + ins,    // insertion with cost
                            dist[i - 1][j - 1] + sub,  // substitution with cost
                            dist[i - 1][j] + del      // deletion with cost
                    );

                }

            }
        }

//        printActualEdits(dist, first, sec);
        return dist[first.length()][sec.length()];
    }


    /**
     * Back Tracking and printing all the paths;
     *
     * @param T
     * @param first
     * @param sec
     */
    public void printActualEdits(int T[][], String first, String sec) {
        char[] str1 = first.toCharArray();
        char[] str2 = sec.toCharArray();

        List<String> words = new ArrayList<>();

        int i = T.length - 1;
        int j = T[0].length - 1;

        StringBuffer iniWord = new StringBuffer(first);

        int index = str1.length - 1;

        while (true) {


            if (i == 0 || j == 0) {
                break;
            }

            if (str1[i - 1] == str2[j - 1]) {

                i = i - 1;
                j = j - 1;
            } else if (T[i][j] == T[i - 1][j - 1] + sub) {

                char s1[] = iniWord.toString().toCharArray();
                s1[index] = str2[j - 1];
                iniWord = new StringBuffer(toString(s1));
                words.add(iniWord.toString());

                i = i - 1;
                j = j - 1;


            } else if (T[i][j] == T[i - 1][j] + del) {
                iniWord = iniWord.deleteCharAt(index);
                words.add(iniWord.toString());
                i = i - 1;

            } else if (T[i][j] == T[i][j - 1] + ins) {
                iniWord = iniWord.insert(index, str2[j - 1]);
                words.add(iniWord.toString());

                j = j - 1;

            } else {
                System.out.println(T[i][j] + " i: " + i + " j:" + j);
                throw new IllegalArgumentException("Some wrong with given data");
            }
            index--;

        }

        for (String wd : words) {
            System.out.print(wd + " ");
        }

    }

    /**
     * Convert char array to String; std toString sends abnormal size;
     *
     * @param s1
     * @return
     */
    public String toString(char[] s1) {
        String str = "";

        for (int i = 0; i < s1.length; i++) {
            str += s1[i];
        }
        return str;
    }


    public int getMinimum(int a, int b, int c) {
        return (a < b)? (a < c)? a : c : b < c ? b : c;
    }

    public static void main(String[] args) {

        LevenshteinDistance lv = new LevenshteinDistance();

        System.out.println(lv.getEditDist("game", "Shame"));


    }

}
