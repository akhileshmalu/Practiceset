package DesignPatterns;

/**
 * @author: Akhilesh Maloo
 * @date: 1/8/23.
 */
public class FactoryMethodPattern {

    public Burger getBurger(String req) {
        if(req.equalsIgnoreCase("VEGGIE")) {
            return new VeggieBurger();
        } else {
            return new ChickenBurger();
        }
    }

    interface Burger {
        void prepareBurger();
    }

    class VeggieBurger implements Burger{

        @Override
        public void prepareBurger() {
            System.out.println("Veg Burger is being prepared");
            return;
        }
    }

    class ChickenBurger implements Burger{

        @Override
        public void prepareBurger() {
            System.out.println("Chicken Burger is being prepared");
            return;
        }
    }


    public static void main(String[] args) {
        FactoryMethodPattern p = new FactoryMethodPattern();
        Burger veggie = p.getBurger("VEGGIE");
        veggie.prepareBurger();
    }
}
