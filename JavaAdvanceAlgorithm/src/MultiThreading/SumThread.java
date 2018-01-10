package MultiThreading;

import java.io.IOException;
import java.io.InterruptedIOException;

/**
 * @author: Akhilesh Maloo
 * @date: 11/13/17.
 */
public class SumThread extends Thread {
    public int sum = 0;

    public void run(){
        synchronized (this) {
            for(int i=0; i<10; i++){
                System.out.println("print from 1st class " + i);
            }
            notify();
        }
    }
}

class DiffThread implements Runnable {
    public int sum = 0;

    public void run(){
        synchronized (this) {
            for(int i = 0; i<10; i++){
                System.out.println("print from 2nd class " + i);
            }
            notify();
        }
    }
}

class PrintThread {
    public static void main(String[] args) {

        SumThread thread1 = new SumThread();

        DiffThread dh = new DiffThread();
        Thread thread = new Thread(dh);

        thread1.start();

        synchronized (thread1) {
            try{
                thread1.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        thread.start();



    }

}
