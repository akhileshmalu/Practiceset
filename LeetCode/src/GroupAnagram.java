import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: Akhilesh Maloo
 * @date: 10/26/17.
 */
public class GroupAnagram {


    /**
     * Time analysis : n
     * @param strs
     */
    public void groupAnagram(String[] strs) {

        HashMap<String, List<String>> val = new HashMap<>();

        for(String word : strs) {

            String tmp = lexograph(word);
            if(!val.containsKey(tmp)) {
                List<String> a = new ArrayList<>();
                a.add(word);
                val.put(tmp, a);
            } else {
                List<String> a = val.get(tmp);
                a.add(word);
                val.put(tmp, a);
            }
        }
        List<List<String>> a = new ArrayList<>();
        a.addAll(val.values());
        System.out.println(a);
    }

    /** sort array lexographically
     *
     * @param str
     * @return
     */
    public String lexograph(String str) {

        int[] letters = new int[26];
        for(int i = 0; i< str.length(); i++) {
            letters[str.charAt(i) - 'a']++;
        }
        int i = 0;
        str = "";
        while(i < letters.length) {
            if(letters[i] != 0) {
                str += (char) (i + 'a');
                letters[i]--;
            } else {
                i++;
            }
        }
        return str;
    }

    /**
     * n^3 time analysis
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {


        List<List<String>> finalList = new ArrayList<>();
        LinkedList<String> q = new LinkedList<>();

        for(String word: strs) {
            q.add(word);

        }

        while(!q.isEmpty()) {

            String wd = q.poll();
            List<String> anagram = new ArrayList<>();
            anagram.add(wd);

            int t = 0;
            while(t < q.size()) {

                String wd2 = q.get(t++);

                if(anagram(wd, wd2)) {
                    anagram.add(wd2);
                }
            }
            finalList.add(anagram);
            q.removeAll(anagram);
        }

        return finalList;

    }

    /**
     * checks if two string s are anagram to each other
     * @param a
     * @param b
     * @return
     */
    public boolean anagram(String a, String b) {
        if(a.equals(b)) return true;
        if(a.length() != b.length()) return false;

        int[] letters = new int[26];

        /*
        a = a.toLowerCase();
        b = b.toLowerCase();
        */

        for(int i = 0; i< a.length(); i++) {
            letters[a.charAt(i) - 'a']++;
            letters[b.charAt(i) - 'a']--;
        }

        for(int i = 0; i< letters.length; i++) {
            if(letters[i] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        List<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> item = new HashSet<>();
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        item.add(a);

        result.addAll(item.stream().collect(Collectors.toList()));

        System.out.println(result);

        /*GroupAnagram ga = new GroupAnagram();
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};

        long t = System.currentTimeMillis();
        ga.groupAnagram(str);
        System.out.println("time:" + (System.currentTimeMillis() - t));
        */
    }
}
