import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Akhilesh Maloo on 8/28/17.
 * Use ID number and match the random Pairs with ID
 */
public class RandomPair {


    public static void main(String[] args) {

        Set<Integer> existingId = new HashSet<>();
        // Max length of Id
        int maxLength = 25;

        Random random = new Random();

        for (int i = 1; i <= maxLength/2; i++) {

            int firstId = random.nextInt(maxLength) + 1;
            while (existingId.contains(firstId)) {
                firstId = random.nextInt(maxLength) + 1;
            }
            existingId.add(firstId);

            int secondId = random.nextInt(25) + 1;
            while (existingId.contains(secondId)) {
                secondId = random.nextInt(25) + 1;
            }
            existingId.add(secondId);

            System.out.println(firstId + " " + secondId);
        }
    }

}
