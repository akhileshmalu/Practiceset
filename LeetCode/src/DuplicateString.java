import java.util.*;

/**
 * @author: Akhilesh Maloo
 * @date: 9/2/17.
 *
 */
public class DuplicateString {

    /**
     *
     * @param m String Whole text
     * @return word String most repeated word in text
     */
    public String duplicateStr(String m) {
        // to store unique words in string; Used LinkedHashMap to store order as key entry
        HashMap<String, Integer> uniqWords = new LinkedHashMap<>();

        // to store words with higher frequency
        List<String> dupWords = new ArrayList<>();

        // split words
        String[] words = m.split("\\W+");

        int maxCount = 0;

        for (String word : words) {

            // if already exist in Hash
            if(uniqWords.containsKey(word)) {
                maxCount = uniqWords.get(word);
                uniqWords.put(word, ++maxCount);

                // store word for scanning ; efficiency measure
                dupWords.add(word);

            } else {
                // Else create a new entry
                uniqWords.put(word, 1);
            }
        }

        for(String word: dupWords) {
            if(uniqWords.get(word) == maxCount) {
                return word;
            }
        }
        return words[0]; // worst case for no duplication; first word should be returned.
    }

    public static void main(String[] args) {
        DuplicateString dup  = new DuplicateString();
        String m = "VC3 is firmly committed to the development of applications using Microsoft's .NET framework ";
        m += "to develop cutting-edge solutions that take advantage of modern design paradigms.";

        System.out.println(dup.duplicateStr(m));
    }
}



