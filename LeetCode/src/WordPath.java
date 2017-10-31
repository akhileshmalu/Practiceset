import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Word Transform puzzle
 *
 * @author: Akhilesh Maloo
 * @date: 9/27/17.
 */
public class WordPath {

    /**
     * Helper function to load all dictionary words to check from file path
     *
     * @param filePath
     */
    public Set<String> buildDictionary(String filePath) {
        Set<String> dictionary = new HashSet<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\t");
                dictionary.add(words[0].toUpperCase());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return dictionary;

    }

    /**
     * Shortest distance from a begin string to end String considering possible operations
     * 1. Insertion of character
     * 2. Substitution of Character
     * 3. Deletion of Character
     * 4. Anagram of existing word
     *
     * @param beginWord Source word to translate
     * @param endWord   Destination word
     * @param wordDict  Set of valid words
     * @return (word can be translated)? shortest distance : -1;
     */
    public int ladderLength(int opsCost[], String beginWord, String endWord, Set<String> wordDict) {

        // setting operation cost;
        int ins = opsCost[0];
        int del = opsCost[1];
        int sub = opsCost[2];
        int anagram = opsCost[3];

        //setting input string to upper case as our dictionary contains only capital words
        beginWord = beginWord.toUpperCase();
        endWord = endWord.toUpperCase();

        Set<String> reached = new HashSet<>();
        Set<String> existAnagram = new HashSet<>();

        boolean isAnagram = false;                                  // check if there exist a anagram
        int anagramDistance = Integer.MAX_VALUE;                   // if there are no anagrams and comparison happens

        reached.add(beginWord);

        wordDict.remove(beginWord);     // do not want to recreate begin word;
        wordDict.add(endWord);          // ensuring end word is available in dictionary

        // records all the operations on map <current word , WordNode(source word, cost of ops) >
        Map<String, WordNode> ops = new HashMap<>();                 // in order to calculate cost by back tracking


        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<>();
            for (String each : reached) {

                // operations ; Restricts any word less than 3 character
                if (each.length() >= 3 && each.length() <= Math.max(beginWord.length(), endWord.length()))
                    for (int i = 0; i < each.length(); i++) {

                        for (char ch : endWord.toCharArray()) {

                            // substitute possible?
                            StringBuilder sbSub = new StringBuilder(each);
                            sbSub.setCharAt(i, ch);

                            if (wordDict.contains(sbSub.toString())) {

                                toAdd.add(sbSub.toString());   // if there exist a valid word; loop it in.
                                wordDict.remove(sbSub.toString());  // to avoid any duplicates

                                WordNode trans = new WordNode(each, sub);    // to calculate substitute cost
                                ops.put(sbSub.toString(), trans);       //capture all the operation history to backtrack
                            }

                            //Insertion possible ?
                            StringBuilder sbIns = new StringBuilder(each);
                            sbIns.insert(i, ch);
                            if (wordDict.contains(sbIns.toString())) {
                                toAdd.add(sbIns.toString());
                                wordDict.remove(sbIns.toString());

                                WordNode trans = new WordNode(each, ins);    // to calculate insertion cost
                                ops.put(sbIns.toString(), trans);
                            }

                        }

                        //deletion possible ? if word is composed of more than 3 characters
                        if (each.length() > 3) {
                            StringBuilder sbDel = new StringBuilder(each);
                            sbDel.deleteCharAt(i);
                            if (wordDict.contains(sbDel.toString())) {
                                toAdd.add(sbDel.toString());
                                wordDict.remove(sbDel.toString());

                                WordNode trans = new WordNode(each, del);  // to calculate deletion cost
                                ops.put(sbDel.toString(), trans);
                            }
                        }
                    }
                //anagram
                isAnagram = checkAnagram(each.toCharArray(), endWord.toCharArray());

                if (isAnagram && !existAnagram.contains(endWord)) {    // avoid duplicate run of anagram check

                    //Below step is commented to allow traversing all possible choices to compare cost later;
                    //toAdd.add(endWord);
                    WordNode trans = new WordNode(each, anagram);    // to calculate anagram cost
                    ops.put(endWord, trans);
                    existAnagram.add(endWord);      // record any anagram match;

                    /* calculate distance from anagram to begin word by passing available operation history ;
                    * This allows to test anagram at any interim step and calculate total cost from begin;
                    * */
                    anagramDistance = calculateDistance(beginWord, endWord, ops);

                }

            }

            if (toAdd.size() == 0)  // if there are no new words available to check;
                return (isAnagram) ? anagramDistance : -1; // return anagram distance if it exists;

            reached = toAdd;            // add above valid dictionary words for next round checking
        }

        return Math.min(calculateDistance(beginWord, endWord, ops), anagramDistance);
    }

    /**
     * Helper function to calculate cost by back tracking from available operation map
     *
     * @param beginWord
     * @param endWord
     * @param ops       Available operations from call
     * @return distance
     */
    public int calculateDistance(String beginWord, String endWord, Map<String, WordNode> ops) {
        int distance = 0;
        while (!beginWord.equals(endWord)) {
            WordNode test = ops.get(endWord);
            distance += test.cost;
            endWord = test.word;
//            System.out.println(endWord);              uncomment it to display the path of back tracking;
        }
        return distance;
    }

    /**
     * Helper function to check if two words are anagram to each other;
     *
     * @param first
     * @param sec
     * @return boolean
     */
    public boolean checkAnagram(char[] first, char[] sec) {

        if (first.length != sec.length) return false;

        int[] chMap = new int[26];

        // arrange all characters lexographically
        for (int i = 0; i < first.length; i++) {
            chMap[(first[i] - 'A')] = ++chMap[(first[i] - 'A')];
            chMap[(sec[i] - 'A')] = --chMap[(sec[i] - 'A')];
        }

        // if there is any difference ; it is not an anagram
        for (int c : chMap) if (c != 0) return false;
        return true;
    }

    public static void main(String[] args) {

        WordPath wd = new WordPath();

        //set your cost per operation;
        int cost[] = {1, 3, 1, 5};

        String startingWord = "health";
        String endingWord = "hands";

        // dictionary settings; Set file path of dictionary words.
        Set<String> wordDict = wd.buildDictionary(System.getProperty("user.dir") + "/LeetCode/src/dictWords.txt");
        // If you want to set your own word list use below statement;
        wordDict.addAll(Arrays.asList(new String[]{"HEALTH", "HEATH", "HEATS", "HENTS", "HENDS", "HANDS"}));

        System.out.println("Distance between " + startingWord + " & " + endingWord + " is " +
                wd.ladderLength(cost, startingWord, endingWord, wordDict));

    }
}

/**
 * Helper class to record transmitting word and its implementation cost
 */
class WordNode {
    String word;
    int cost;

    WordNode(String transWord, int val) {
        word = transWord;
        cost = val;
    }
}
