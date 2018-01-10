package DesignPatterns;

/**
 * @author: Akhilesh Maloo
 * @date: 11/17/17.
 */

interface Animal extends Cloneable {
     Animal makeCopy();
}

class Sheep implements Animal {

    Sheep() {
        System.out.println("Sheep is made");
    }

    public Animal makeCopy() {

        System.out.println("Sheep is Being made");

        Sheep sheepObj = null;

        try {
            sheepObj = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return sheepObj;
    }

    public String toString() {
        return "I am a Sheep in your backyard.";
    }
}

class PrototypeFactory {

    public Animal getClone(Animal sample) {

        return sample.makeCopy();
    }

}

class TestPrototype {

    public static void main(String[] args) {
        PrototypeFactory animalMaker = new PrototypeFactory();

        Sheep sally = new Sheep();
        Sheep clonedSally = (Sheep) animalMaker.getClone(sally);

        System.out.println(sally);
        System.out.println(clonedSally);

        System.out.println(System.identityHashCode(System.identityHashCode(sally)));
        System.out.println(System.identityHashCode(System.identityHashCode(clonedSally)));
    }

}