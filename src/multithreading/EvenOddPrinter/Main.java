package multithreading.EvenOddPrinter;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter(20);

        Thread oddPrinter = new Thread(new Printer(counter, 1), "OddPrinter");
        Thread evenPrinter = new Thread(new Printer(counter, 0), "EvenPrinter");
        oddPrinter.start();
        evenPrinter.start();
    }
}
