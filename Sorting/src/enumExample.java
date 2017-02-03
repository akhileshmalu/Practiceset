import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by akhi on 2/20/17.
 */
public class enumExample {

    public static void main(String[] args) {
        Enumeration days;
        Vector names = new Vector();
        names.addElement("Monday");
        names.addElement("Tuesday");
        names.addElement("Wednesday");
        names.addElement("Thursday");
        names.addElement("Friday");
        names.addElement("Saturday");
        names.addElement("Sunday");
        days = names.elements();


        while(days.hasMoreElements()) {
            System.out.println(days.nextElement());
        }

    }



}
