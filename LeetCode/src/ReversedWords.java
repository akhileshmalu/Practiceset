/**
 * @author: Akhilesh Maloo
 * @date: 10/24/17.
 */
public class ReversedWords {

    public static String reverseWords(String s) {


        if (s.equals(" ")) return "";

        if (s.length() > 0) {
            String[] words = (s.trim()).split("\\s");
            s = "";
            for (int i = words.length - 1; i >= 0; i--) {
                if (i != words.length - 1) {
                    s += " ";
                }
                s += words[i];
            }
        }
        return s;
    }

    /**
     * without using std functions.
     * @param s
     * @return
     */
    public static String revWords(String s) {
        //s = s.trim();
        char[] letters = s.toCharArray();

        String reversedWord = "";

        for (int i = 0; i < letters.length; i++) {

            while (i < letters.length && letters[i] == ' ') {
                i++;
            }

            if (i < letters.length) {
                String word = "";
                while (i < letters.length && letters[i] != ' ') {
                    word += letters[i];
                    i++;
                }
                reversedWord = " " + word + reversedWord;
            }

        }

        return reversedWord.trim();
    }


}
