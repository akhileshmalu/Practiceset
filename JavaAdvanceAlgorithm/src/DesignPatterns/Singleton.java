package DesignPatterns;

/**
 * @purpose: thread-safe Singleton class
 *
 * @author: Akhilesh Maloo
 * @date: 9/19/17.
 */
public class Singleton {

    // volatile keyword for protecting communication of thread in loss state
    private static volatile Singleton instance;

    // blocking constructor for public use
    private Singleton() {

    }

    public static Singleton getInstance() {
        if(instance == null) {  // first check
            synchronized (Singleton.class) {
                if(instance == null) {  // double check
                    instance = new Singleton();
                }
             }
        }

        return instance;
    }


}
