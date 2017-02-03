import java.util.*;

import static java.lang.Math.ceil;

/**
 * Created by akhi on 2/21/17.
 */
public class MapDemo {

    void mapShow() {
        Map map = new HashMap();
        Set set;
        map.put("fName","Akhilesh");
        map.put("lName","Maloo");
        map.put("Country","USA");
        // map.put("lName","Maloo");

        System.out.println("Elements in map are: ");
        System.out.print(map);
//        System.out.println("Contains : " + map.containsKey("Country"));
        System.out.println("Contains : " + map.get("Country"));

        set = map.entrySet();
        System.out.println("Set is: "+set);
    }

    public void hashtableShow() {
        Hashtable account = new Hashtable();
        Enumeration holder;
        String textname;
        account.put("Akhilesh",new Double(4000.00));
        account.put("Priya",new Double(6000.00));
        account.put("Maloo",new Double(7000.00));

        holder = account.keys();

        while(holder.hasMoreElements()){
            textname = (String) holder.nextElement();
            System.out.println("Balances are :"+ account.get(textname));
        }
double bal;
        bal = ((Double) account.get("Priya")).doubleValue();
        account.put("Priya",new Double (bal-1000));

        System.out.println("Debited 1k form Priya: "+account);

    }



    public static void main(String[] args) {

        MapDemo m =new MapDemo();
        m.mapShow();
        m.hashtableShow();

    }
}
