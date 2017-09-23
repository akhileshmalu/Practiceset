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
    public static int  ins = 1, del = 3,  sub = 1, cp = 0;

    public Set<String> dictionary = new HashSet<>();
    List<String> wd = new ArrayList<>();

    LevenshteinDistance() {
        // build disctionary words to check
        build(System.getProperty("user.dir") + "/JavaAdvanceAlgorithm/src/dictWords.txt");
    }

    public  int getMinCostToCovert(String first, String sec) {

        int[][] dist = new int[first.length()+1][sec.length()+1];

        for(int i = 0; i< dist[0].length; i++) {
            dist[0][i] = i * ins;
        }

        for(int i = 0; i< dist.length; i++) {
            dist[i][0] = i * del;
        }

        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= sec.length(); j++) {

                if (first.charAt(i - 1) == sec.charAt(j - 1)) {

                    dist[i][j] = dist[i-1][j-1] + cp;

                } else {

                    dist[i][j] = ( getMinimum(
                            dist[i][j-1] + ins ,    // insertion with cost
                            dist[i-1][j-1] + sub ,  // substitution with cost
                            dist[i-1][j] + del )    // deletion with cost
                    );

                }

            }


        }

        for (int[] nums :dist) {
            for( int num: nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        printActualEdits(dist, first, sec);
        return dist[first.length()][sec.length()];
    }


    public void printActualEdits(int T[][], String first, String sec ) {
        char[] str1 = first.toCharArray();
        char[] str2 = sec.toCharArray();

        List<String> words = new ArrayList<>();

        int i = T.length - 1;
        int j = T[0].length - 1;

        StringBuffer iniWord = new StringBuffer(first);

        int index = str1.length-1;

        while(true) {


            if (i == 0 || j == 0) {
                break;
            }

            if (str1[i-1] == str2[j-1]) {
                i = i-1;
                j = j-1;
            } else

            if(T[i][j] == T[i-1][j-1] + sub ) {

                char s1[] = iniWord.toString().toCharArray();
                s1[index] = str2[j-1];
                iniWord = new StringBuffer(buildStr(s1));
                words.add(iniWord.toString());

                i = i-1;
                j = j-1;


            } else

                if(T[i][j] == T[i-1][j] + del) {
                iniWord = iniWord.deleteCharAt(index);
                words.add(iniWord.toString());
                i = i-1;

            } else
            if(T[i][j] == T[i][j-1] + ins ) {
                iniWord = iniWord.insert(index,str2[j-1]);
                words.add(iniWord.toString());

                j = j -1;

            } else
            {
                System.out.println(T[i][j] + " i: " + i + " j:" + j);
                throw new IllegalArgumentException("Some wrong with given data");
            }
            index--;


//            if (str1[i-1] == str2[j-1]) {
//                i = i-1;
//                j = j-1;
//            } else if (T[i][j] == T[i-1][j-1] + sub) {
//                System.out.println("Substitute " + str2[j-1] + " in string2 with " + str1[i-1] + " in string1");
//                str1[i-1] = str2[j-1];
//
//
//                System.out.println(str1);
//                if(dictionary.contains(str1.toString().toUpperCase())) {
//                    i = i-1;
//                    j = j-1;
//                } else {
//                    T[i-1][j-1] = T[i-1][j-1] - sub + ins;
//                }
//
//            } else if (T[i][j] == T[i-1][j] + del) {
//                System.out.println("Delete in string1 " + str1[i-1]);
//
//                for(int k = i-1; k < str1.length-1; k++) {
//                    str1[k] = str1[k+1];
//                }
//                str1[str1.length-1] = ' ';
//                i = i-1;
//                System.out.println(str1);
//                System.out.println(dictionary.contains(str1.toString().toUpperCase()));
//
//            } else if (T[i][j] == T[i][j-1] + ins) {
//
//                System.out.println("Insert in string2 " + str2[j-1]);
//                j = j -1;
//                System.out.println(str1);
//            } else {
//                System.out.println(T[i][j] + " i: " + i + " j:" + j);
//                throw new IllegalArgumentException("Some wrong with given data");
//            }
//



        }

        for (String wd : words) {
            System.out.print(wd + " " );
        }


    }

   /* public  void minDis(String first, String sec){
        int i = 3;
        int result = 0;
        while(i < first.length()) {
            result = getMinCostToCovert(first.substring(0,i), sec);
            System.out.println("MinDist with "+first.substring(0,i)+" : " + result);
            i++;
        }

    }*/

   public String buildStr(char[] s1) {
       String str = "";

       for(int i=0 ; i<s1.length; i++) {
           str += s1[i];
       }
       return str;
   }

    public void build(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\t");
                dictionary.add(words[0].toLowerCase());
                wd.add(words[0].toLowerCase());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public  boolean checkAnagram(char[] first, char[] sec) {

        if(first.length != sec.length) return false;

        int[] ch1 = new int[26];
        int[] ch2 = new int[26];

        for(int i = 0; i< first.length || i< sec.length; i++) {
            if(i<first.length) ch1[(first[i] - 'a')] = ++ch1[(first[i] - 'a')];
            if(i<sec.length) ch2[(sec[i] - 'a')] = ++ch2[(sec[i] - 'a')];
        }

        return Arrays.equals(ch1,ch2);
    }

    public  int getMinimum(int a , int b, int c) {
        return (a < b)? (a < c)? a : c : b < c? b : c;
    }


    public int ladderLength(String start, String end, Set<String> dict) {
        // Use queue to help BFS
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        queue.add(null);

        // Mark visited word
        Set<String> visited = new HashSet<String>();
        visited.add(start);

        int level = 1;

        while (!queue.isEmpty()) {
            String str = queue.poll();

            if (str != null) {
                // Modify str's each character (so word distance is 1)
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;

                        String word = new String(chars);

                        // Found the end word
                        if (word.equals(end)) return level + 1;

                        // Put it to the queue
                        if (dict.contains(word) && !visited.contains(word)) {
                            queue.add(word);
                            visited.add(word);
                        }
                    }
                }
            } else {
                level++;

                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        LevenshteinDistance lv = new LevenshteinDistance();


        System.out.println("Minimum Distance is "+ lv.ladderLength("health","hands",lv.dictionary));

    }

}
