package DesignPatterns;

import java.io.Serializable;

/**
 * @purpose: thread-safe Singleton class
 *
 *  - lazy instantiation
 *  - avoid overkill of synchronization
 *
 * @author: Akhilesh Maloo
 * @date: 9/19/17.
 */
public final class Singleton implements Serializable {

    // volatile keyword for protecting communication of thread in loss state
//    private static volatile Singleton instance;
//
//    // blocking constructor for public use
//    private Singleton() {
//
//    }
//
//    public static Singleton getInstance() {
//        if(instance == null) {  // first check
//            synchronized (Singleton.class) {
//                if(instance == null) {  // double check
//                    instance = new Singleton();
//                }
//             }
//        }
//
//        return instance;
//    }
//
//    /**
//     * Restrict Deserialization
//     * @return
//     */
//    protected Object readResolve() {
//        return instance;
//    }
    // lazy load - does not create instance till inner static class in not accessed.
    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }

    private Singleton() {

    }

    public static Singleton getInstance2() {
        return SingletonHolder.instance;
    }

    private Object readResolve() {
        return getInstance2();
    }
}
