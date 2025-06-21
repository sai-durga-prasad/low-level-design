package multithreading.basics;

public class Main {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("Hi..Called from Lambda. Thread:"+ Thread.currentThread().getName());
        });

        ThreadClass threadClass = new ThreadClass();
        Thread thread2 = new Thread(threadClass);
        thread2.start();
        thread1.start();
        thread1.run(); //this will not execute on separate thread, instead it will execute on same main thread.

        Hello thread3 = new Hello();
        thread3.start(); //does nothing as we don't have run() method in Hello class
    }
}
