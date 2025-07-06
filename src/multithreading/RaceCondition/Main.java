package multithreading.RaceCondition;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        SharedCounter counter = new SharedCounter();

        Thread thread1 = new Thread(new Printer(counter));
        Thread thread2 = new Thread(new Printer(counter));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter.getCount());
    }

}
