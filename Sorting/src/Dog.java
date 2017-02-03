/**
 * Created by akhi on 2/19/17.
 */
public class Dog extends Animal {
    public void sound(char m) {
        System.out.println("barking"+m);
    }
    public void move() {
        System.out.println("Jumping");
    }
    public void characterstics() {
        System.out.println("Faithful");
    }

    public static void main(String[] args) {
        Animal a = new Dog();
        Animal b = new Animal();
        Dog c = new Dog();

    // Example 1 Error handling Refernce & Object combination
        a.sound(1);
        a.move();
        //a.characterstics();  // bad function due to re

        // method overriding
        c.sound(2);
        c.sound('e');

        c.characterstics();
    }
}

