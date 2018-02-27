import java.util.ArrayList;
import java.util.List;

/**
 * @author: Akhilesh Maloo
 * @date: 2/6/18.
 */
public class PrintParenthesisCombination {

    public static List<String> getCombinations(int n) {
        List<String> result = new ArrayList<String>();
        getCombinations(n, 0, "", result);
        return result;
    }

    public static void getCombinations(int available, int currentlyOpen, String prefix, List<String> acc) {
        // First possibility: add opening parenthesis (only if parentheses are still available)
        if (available > 0) {
            getCombinations(available-1, currentlyOpen+1, prefix + "(", acc);
        }
        // Second possibility: add closing parenthesis (only if at least one is open)
        if (currentlyOpen > 0) {
            getCombinations(available, currentlyOpen-1, prefix + ")", acc);
        }
        // If no parentheses are left and all of them are closed, we're done
        if (available == 0 && currentlyOpen == 0) {
            acc.add(prefix);
        }
    }

    public static void main(String[] args) {
        System.out.println(getCombinations(3));

    }
}
