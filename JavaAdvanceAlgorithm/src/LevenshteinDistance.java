import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

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
    public static int  ins = 1, del = 1,  sub = 1, cp = 0;

    public Set<String> dictionary = new HashSet<>();
    List<String> wd = new ArrayList<>();

    LevenshteinDistance() {
        // build disctionary words to check
        build(System.getProperty("user.dir") + "/JavaAdvanceAlgorithm/src/dictWords.txt");
    }

    public  int getEditDist(String first, String sec) {

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
                            dist[i-1][j] + del      // deletion with cost
                                                        // anagram with cost #yet to implement
                        )
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
                iniWord = new StringBuffer(toString(s1));
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

   public String toString(char[] s1) {
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

        for(int i = 0; i< first.length ; i++) {
            ch1[(first[i] - 'a')] = ++ch1[(first[i] - 'a')];
            ch1[(sec[i] - 'a')] = --ch1[(sec[i] - 'a')];
        }

        for (int c: ch1) if(c != 0) return false;
        return true;
    }

    public  int getMinimum(int a , int b, int c) {
        return (a < b)? (a < c)? a : c : b < c? b : c;
    }


//    public int ladderLength(String start, String end, Set<String> dict) {
//        // Use queue to help BFS
//        Queue<String> queue = new LinkedList<String>();
//        queue.add(start);
//        queue.add(null);
//
//        // Mark visited word
//        Set<String> visited = new HashSet<String>();
//        visited.add(start);
//
//        int level = 1;
//
//        while (!queue.isEmpty()) {
//            String str = queue.poll();
//
//            if (str != null) {
//                // Modify str's each character (so word distance is 1)
//                for (int i = 0; i < str.length(); i++) {
//                    char[] chars = str.toCharArray();
//
//                    for (char c = 'a'; c <= 'z'; c++) {
//                        chars[i] = c;
//
//                        String word = new String(chars);
//
//                        // Found the end word
//                        if (word.equals(end)) return level + 1;
//
//                        // Put it to the queue
//                        if (dict.contains(word) && !visited.contains(word)) {
//                            queue.add(word);
//                            visited.add(word);
//                        }
//                    }
//                }
//            } else {
//                level++;
//
//                if (!queue.isEmpty()) {
//                    queue.add(null);
//                }
//            }
//        }
//
//        return 0;
//    }

//    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
//        Set<String> set1 = new HashSet<String>();
//        set1.add(beginWord);
//
//        Set<String> set2 = new HashSet<String>();
//        set2.add(endWord);
//
//        wordList.remove(beginWord);
//        wordList.remove(endWord);
//
//        return minLengthBidirectionalSearch(set1, set2, wordList, 2);
//    }

    public int minLengthBidirectionalSearch(Set<String> set1, Set<String> set2, Set<String> wordList, int length) {
        if(set1.size() == 0) return 0;

        Set<String> newSet = new HashSet<String>();

        for(String s : set1) {
            char[] str = s.toCharArray();
            for(int j = 0; j < str.length; j++) {
                char og = str[j];
                for(char c = 'a'; c <= 'z'; c++) {
                    str[j] = c;
                    String newStr = String.valueOf(str);
                    if(set2.contains(newStr)) return length;
                    if(wordList.contains(newStr)) {
                        newSet.add(newStr);
                        wordList.remove(newStr);
                    }
                }
                str[j] = og;
            }
        }

        // This part is KEY to bringing your run-time down. Otherwise sets with more neighbours
        // will skew the benefit that can be obtained from searching outward from two nodes.
        if(newSet.size() < set2.size()) {
            return minLengthBidirectionalSearch(newSet, set2, wordList, length+1);
        } else {
            return minLengthBidirectionalSearch(set2, newSet, wordList, length+1);
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int[] visited = new int[wordList.size()];
        HashMap<String, Integer> map = new HashMap<>();
        int res = ladderHelper( beginWord,endWord, wordList,visited,map);
        return res;
    }

    private int ladderHelper(String beginWord, String endWord, List<String> wordList, int[] visited, HashMap<String, Integer> map) {
        if (beginWord.equals(endWord)) return 1;
        int bestSeen = 0;
        for (int i = 0; i < wordList.size(); i++) {
            if (visited[i] == 1) continue;
            if (!validJump(beginWord, wordList.get(i))) continue;
            if (map.containsKey(wordList.get(i))) {
                int val = map.get(wordList.get(i));
                if (val != 0 && (bestSeen==0 || val+ 1 < bestSeen)) bestSeen = map.get(wordList.get(i))+1;
            }else {
                visited[i] = 1;
                int distance = ladderHelper(wordList.get(i), endWord, wordList, visited, map);
                visited[i] = 0;
                if (distance != 0 && (bestSeen == 0 || distance + 1 < bestSeen)) bestSeen = distance+1;
            }
        }
        map.put(beginWord, bestSeen);
        return bestSeen;
    }

    private boolean validJump(String a, String b) {
        int mistakes = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i) && ++mistakes > 1) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        LevenshteinDistance lv = new LevenshteinDistance();
        Set<String> dict = new HashSet<String>();
        List<String> list = new ArrayList<>();

        String arr[] = {"heath","heats", "hents", "hends","hands"};
//        String arr[] = {"hot","dot","dog","lot","log","cog"};
//
        for(String val: arr) {
            dict.add(val.toLowerCase());
            list.add(val.toLowerCase());
        }

        System.out.println(lv.ladderLength("healths","hands",list));
//        System.out.println(lv.checkAnagram("act".toCharArray(),"tac".toCharArray()));
//         System.out.println("Minimum Distance is "+ lv.getEditDist("hit","cog"));

    }

}
