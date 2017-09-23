/**
 * Created by akhi on 2/19/17.
 */
public class subClass extends SuperClass {
    int c;
    public void display() {
        int c= 10;
        System.out.println("Hello Child Class" + c);

        //calling super class method
        super.display();

        //assignment of super class variable
        super.k = 30;
        super.display();
    }

    public static void main(String[] args) {
        SuperClass c = new subClass();
        c.display();
    }
}
