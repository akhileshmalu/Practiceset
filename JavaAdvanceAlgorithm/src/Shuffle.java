import java.util.Arrays;

/**
 * @author: Akhilesh Maloo
 * @date: 10/22/17.
 */
public class Shuffle {

    public static void shuffleDeck(int[] a) {

        for(int i = 0; i< a.length; i++) {
            // it is idea to use unseen cards for making random numbers
            int ran = (int) (Math.random() * i);
            int swap = a[i];
            a[i] = a[ran];
            a[ran] = swap;
        }

    }

    public static void main(String[] args) {
        int deck[] = {4 , 1, 5, 8, 6};
        shuffleDeck(deck);
        Arrays.stream(deck).forEach(a -> System.out.print(a + " "));
//        for (int card: deck ) System.out.print(card + " ");
    }
}
