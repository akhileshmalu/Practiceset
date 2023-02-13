import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Akhilesh Maloo on 2/20/17.
 */
public class enumExample {

    enum RainBowColor {
        Voilet("Voilet"),
        Indigo("Indigo"),
        Blue("Blue"),
        Green("Green"),
        Yello("Yello"),
        Orange("Orange"),
        Red("Red");

        public String getName() {
            return this.name;
        }


        public void setName(String name) {
            this.name = name;
        }

        public String name;

        RainBowColor() {
            System.out.println("Color of Rainbow : " + this.toString());
        }
        RainBowColor(String color) {
            this.name = color;
        }
    }

    public static void main(String[] args) {

        RainBowColor rb = RainBowColor.Blue;

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
