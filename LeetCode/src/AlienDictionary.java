import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @author: Akhilesh Maloo
 * @date: 10/23/20.
 */
public class AlienDictionary {
    static class Node {
        char ch;
        Node parent;
        Set<Character> parentChars = new HashSet<>();

        Node(char ch) {
            this.ch = ch;
            parent = this;
        }

        public String toString() {
            return " parent:" + parentChars.toString();
        }
    }

    public String alienOrder(String[] words) {

        HashMap<Character, Node> map = new LinkedHashMap<>();

        for(int i = 0; i< words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];

            for(int j = 0; j < word1.length() && j < word2.length(); j++) {
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);

                Node node1 = map.get(ch1);
                if(node1 == null) {
                    node1 = new Node(ch1);
                    map.put(ch1, node1);
                }
                Node node2 = map.get(ch2);
                if(node2 == null) {
                    node2 = new Node(ch2);
                }
                if(ch1 != ch2) {
                    //invalid order
                    // System.out.println(map);

                    if(node1.parentChars.contains(ch2)) {
                        System.out.println(ch1 + " exist in :"+ node2.parentChars );
                        return "";
                    }


                    node2.parent = node1;
                    node2.parentChars.add(ch1);

                }
                map.put(ch2, node2);
            }
        }
        System.out.println(map);

        Set<Character> visitedChar = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        for(Node node: map.values()) {
            if(node.parent != node && !visitedChar.contains(node.ch)) {
                System.out.println(visitedChar);
                builder.insert(0, node.ch);
                visitedChar.add(node.ch);
                while(node.parent != node) {
                    builder.insert(0, node.parent.ch);
                    visitedChar.add(node.parent.ch);
                    node = node.parent;
                }
            }
        }
        // System.out.println(map);
        return builder.toString();
    }
}
