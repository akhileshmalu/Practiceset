import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by akhi on 3/9/17.
 */
public class Keyboard_Row {

    public static void main(String[] args) {

        ArrayList<String> result = new ArrayList<String>();
        String[] words = {"Hello", "Alaska", "DAD", "Peace"};
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        HashSet<Character> set3 = new HashSet<>();
        char[] list1 = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
                list2 = {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
                list3 = {'z', 'x', 'c', 'v', 'b', 'n', 'm'};

        for (char list : list1) {
            set1.add(list);
        }
        for (char list : list2) {
            set2.add(list);
        }
        for (char list : list3) {
            set3.add(list);
        }

        for (String word : words) {

            if (set1.contains(word.toLowerCase().charAt(0))) {
                int i = 1;
                while (i < word.length()) {
                    if (!set1.contains( word.toLowerCase().charAt(i)  )   ) {
                        break;
                    }
                    i++;
                }
                if (i == word.length()) {
                    result.add(word);
                }
            } else {
                if (set2.contains(word.toLowerCase().charAt(0))) {
                    int i = 1;
                    while (i < word.length()) {
                        if (!set2.contains(word.toLowerCase().charAt(i))) {
                            break;
                        }
                        i++;
                    }
                    if (i == word.length()) {
                        result.add(word);
                    }
                } else {
                    if (set3.contains(word.toLowerCase().charAt(0))) {
                        int i = 1;
                        while (i < word.length()) {
                            if (!set3.contains(word.charAt(i))) {
                                break;
                            }
                            i++;
                        }
                        if (i == word.length()) {
                            result.add(word);
                        }
                    }
                }
            }


        }

        System.out.println(result);
    }
}
