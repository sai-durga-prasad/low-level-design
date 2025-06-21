package multithreading.basics;

public class ThreadClass implements Runnable {
    @Override
    public void run() {
        System.out.println("Hey!!!! Printed from thread:"+ Thread.currentThread().getName());
    }
}
