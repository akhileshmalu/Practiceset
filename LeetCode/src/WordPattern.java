import java.util.HashMap;

/**
 * @author: Akhilesh Maloo
 * @date: 10/21/17.
 */
public class WordPattern {

    public static boolean wordPattern2(String pattern, String str) {
        String[] strs = str.split(" ");
        if(strs.length!=pattern.length())
            return false;
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(Integer i = 0; i < pattern.length() ; i++){
            char c = pattern.charAt(i);
            if(map.put(c + " ",i) != map.put(strs[i],i)){
                return false;
            }
        }
        return true;
    }

    public static boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> pat2Word = new HashMap<>();
        HashMap<String, Character> word2Pat = new HashMap<>();
        char i = 0;
        String[] words = str.split("\\s");
        if(pattern.length() != words.length) return false;
        String match = "";
        for(char p: pattern.toCharArray()) {
            if(!pat2Word.containsKey(p)) {
                pat2Word.put(p, words[i]);
                word2Pat.put(words[i],p);
            }
            i++;
        }
        for(String word : words) {
            match += word2Pat.get(word);
        }

        return match.equals(pattern);
    }

    public static void main(String[] args) {
        System.out.println(wordPattern2("abba","dog dog dog dog"));
    }
}
