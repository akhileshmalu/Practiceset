import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by akhi on 5/18/17.
 */
public class excelTitle {

    public String convertToTitle(int n) {

        StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }
        return result.toString();

    }

    /**
     * Passes a prompt to the user and returns the user specified
     * string. Taken from Source Code of MEAT Application {CSCE 747}
     * @param message
     * @return String
     */
    private static String inputOutput(String message) {
        System.out.println(message);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String returnString = "";
        try {
            returnString = br.readLine();
        }
        catch (IOException e){
            System.out.println("Error reading in value");
        }
        return returnString;
    }


    public static void main(String[] args) {
        excelTitle ex =new excelTitle();
        // put random input
        System.out.println(ex.convertToTitle(Integer.parseInt(inputOutput("Enter index number to check Excel Titles"))));
    }
}
