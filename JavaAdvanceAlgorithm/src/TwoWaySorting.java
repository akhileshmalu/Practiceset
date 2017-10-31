/**
 * @author: Akhilesh Maloo
 * @date: 10/11/17.
 */
public class TwoWaySorting {

    /**
     *  There are two possibilities of sorting in given String list ; Lexographically or length wise
     *  Assess and return type of sorting exist;
     * @param stringList
     * @return
     */
    public static String sortingMethod(String[] stringList) {
        boolean lexoWise = true;
        boolean lenWise = true;

        int prevStrLength = 0;
        String prevStr = "";

        for(String word : stringList) {
            // length wise sorting
            lenWise = lenWise && word.length() >= prevStr.length();

            // lexicographically
            for(int i = 0, j = 0; i < word.length() && j <prevStr.length(); i++,j++) {
                lexoWise = lexoWise && (word.charAt(i) - prevStr.charAt(j)) >= 0;
            }
            prevStr = word;
        }

        lenWise = lenWise && prevStrLength == stringList[stringList.length-1].length();
        lexoWise = lexoWise && prevStr.equals(stringList[stringList.length-1]);

        return (lenWise && lexoWise)? "both" : (lenWise)?  "Lengths" : (lexoWise)?  "lexicographically" : "none";
    }

    public static void main(String[] args) {
       String[] str = {"abcdef", "bcdef", "cdef", "def", "ef", "f", "topcoder"};
        System.out.println(sortingMethod(str));
    }

}
