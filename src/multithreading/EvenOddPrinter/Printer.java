package multithreading.EvenOddPrinter;

public class Printer implements Runnable{
    private Counter counter;
    private int val;

    public Printer(Counter counter, int val){
        this.counter = counter;
        this.val = val;
    }

    @Override
    public void run() {
        while (true){
            synchronized (Counter.class){
                if(counter.getCount() % 2 != val && counter.getCount() <= counter.getMaxNum()){
                    try {
                        counter.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(counter.getCount() > counter.getMaxNum()){
                    counter.notifyAll();
                    break;
                }
                counter.print();
                counter.notifyAll();
            }
        }
    }
}
