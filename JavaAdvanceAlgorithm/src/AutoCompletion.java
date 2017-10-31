import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @purpose: This class provides auto completion functionality.
 *
 * @author: Akhilesh Maloo
 * @date: 9/23/17.
 */
public class AutoCompletion {

    public static List<String> populatedWords;

    private class TrieNode {
        String prefix;
        Map<Character, TrieNode> childNodes;
        boolean endOfWord;

        TrieNode(String val) {
            prefix = val;
            childNodes = new HashMap<>();
            endOfWord = false;
        }
    }

    private final TrieNode root;

    AutoCompletion() {
        root = new TrieNode("");
        populatedWords = new ArrayList<>();
    }


    /** Insert a name into TRI list
     *
     * @param name
     */

    public void insert(String name) {

        TrieNode current = root;
        for(int i = 0; i < name.length(); i++) {
            TrieNode node = current.childNodes.get(name.charAt(i));

            if(node == null) {
                node = new TrieNode(name.substring(0,i+1));
                current.childNodes.put(name.charAt(i),node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    /**
     * Ascertain if word exist in tri or not
     * @param key
     */
    public boolean find(String key) {

        TrieNode current = root;
        for(int i=0; i<key.length(); i++) {
            TrieNode node = current.childNodes.get(key.charAt(i));

            if(node == null) {
                return false;
            }
            current = node;
        }
        return current.endOfWord;

    }

    /** filter function
     *
     * @param prefix
     * @return list basis prefix input
     */
    public List<String> populateList(String prefix) {

        List<String> names = new ArrayList<>();

        TrieNode current = root;
        for(int i=0; i<prefix.length(); i++) {

            TrieNode node = current.childNodes.get(prefix.charAt(i));

            if(node == null) {
                return names;
            }
            current = node;
        }

        printNames(current);

        return populatedWords;
    }

    /**
     *  Helper function for pupoulateWord which recursively print all words from tri
     * @param curr
     * @return
     */
    public String printNames(TrieNode curr) {

        if(curr.endOfWord){                             // find last node which has word;
            return curr.prefix;
        }
        for(char a: curr.childNodes.keySet()) {         // iterate with all childNodes

            String temp = printNames(curr.childNodes.get(a));
            if(temp != null) {
                populatedWords.add(temp);
            }

        }
        return null;
    }

    /**
     * wrapper of delete function
     * @param word
     */
    public void delete(String word) {
        delete(root,word,0);
    }

    /** Delete functionality from Tri
     *  (there are no child map)? delete the key :  change endOfword flag to false;
     *
     * @param current
     * @param word
     * @param index
     * @return
     */

    public boolean delete(TrieNode current, String word, int index) {

        if(index == word.length()) {

            if(!current.endOfWord) return false;

            current.endOfWord = false;

            return current.childNodes.size() == 0;
        }

        char ch = word.charAt(index);
        TrieNode node = current.childNodes.get(ch);
        if(node == null) return false;

        boolean shouldDelete = delete(node, word, index+1);

        if(shouldDelete) {
            current.childNodes.remove(ch);
            return current.childNodes.size() == 0;
        }
        return false;

    }

    public static void main(String[] args) {

        String names[] = {"akhilesh", "abhishek","priya","anjali"};

        AutoCompletion ac = new AutoCompletion();

        for(String name: names) {
            ac.insert(name);
        }

        System.out.println(ac.populateList("ak"));

    }

}
