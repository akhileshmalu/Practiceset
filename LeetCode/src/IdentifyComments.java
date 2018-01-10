import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Akhilesh Maloo
 * @date: 11/15/17.
 */
public class IdentifyComments {
    public static void main(String[] args) throws IOException {
        String regex = "((//[^\n\r]*)|(/\\*(.+?)\\*/))";
        Pattern p = Pattern.compile(regex, Pattern.DOTALL);

        String regexStart = "((/\\*)(.*))";
        Pattern p1 = Pattern.compile(regexStart, Pattern.DOTALL);

        String regexEnd = "((.+?)\\*/)";
        Pattern p2 = Pattern.compile(regexEnd, Pattern.DOTALL);

        boolean start = false;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {

            Matcher m = p.matcher(line);
            if (m.find()) {
                System.out.println(m.group(1).replaceAll("^(\\s*)", ""));
            } else {

                Matcher m1 = p1.matcher(line);
                Matcher m2 = p2.matcher(line);

                if (m1.find()) {
                    System.out.println(m1.group(1).replaceAll("^(\\s*)", ""));
                    start = true;
                    continue;
                }
                if (m2.find() && start) {
                    System.out.println(m2.group(1).replaceAll("^(\\s*)", ""));
                    start = false;
                }

                if (start)
                    System.out.println(line.replaceAll("^(\\s*)", ""));
            }


        }
    }
}
