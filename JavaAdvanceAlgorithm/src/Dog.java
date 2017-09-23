/**
 * Created by akhi on 2/19/17.
 */
public class Dog extends Animal {
    public void sound() {
        System.out.println("barking");
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



        a.sound();

    }
}

