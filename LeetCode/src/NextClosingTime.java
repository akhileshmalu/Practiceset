import java.util.HashSet;

/**
 * @author: Akhilesh Maloo
 * @date: 10/20/17.
 */
public class NextClosingTime {

    public static String nextTime(String S) {
        String hours = S.substring(0, 2);
        String mins = S.substring(3);

        HashSet<Integer> t = new HashSet<>();

        int totalhours = Integer.parseInt(hours) * 60;
        int totalMins = Integer.parseInt(mins);
        int currTime = totalhours + totalMins;

        char[] timeArray = S.toCharArray();

        for (int i = 0; i < timeArray.length; i++) {
            if (timeArray[i] != ':')
                t.add(timeArray[i] - '0');
        }

        while (true) {
            currTime = (currTime + 1) % (24 * 60);

            //convert that into digits
            int[] digits = new int[]{currTime / 60 / 10, currTime / 60 % 10, currTime % 60 / 10, currTime % 60 % 10};

            check:
            {
                for (int digit : digits) {
                    if (!t.contains(digit))
                        break check;
                }
                return String.format("%02d:%02d", currTime / 60, currTime % 60);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(nextTime("11:59"));
    }

}
