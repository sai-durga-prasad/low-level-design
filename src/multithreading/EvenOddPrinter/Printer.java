package multithreading.EvenOddPrinter;

public class Printer implements Runnable{
    private final Counter counter;
    private final int threadId;

    public Printer(Counter counter, int threadId){
        this.counter = counter;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        while (true){
            synchronized (counter){
                //double the use case of acquiring lock on Counter.class or object of counter.
                //both are different
                if (counter.getCount() % 2 != threadId && counter.getCount() <= counter.getMaxNum()){
                    //either if or while condition will work here as we're handling with only two threads and only one thread will be on waiting state at once
                    try {
                        counter.wait();
                        //this.wait() method gives IllegalMonitorStateException current thread is not the owner here
                        //it happens when an object tries wait or notify without holding a lock.
                        // here, this refers to object of Printer class, but lock acquired by reference of counter class.
                        //so we need to use counter.wait() and counter.notify()/notifyAll() in order to wait/notify all other threads which are waiting acquire lock on counter object.
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(counter.getCount() > counter.getMaxNum()){
                    //notify will work here as we're handling with only two threads and only one thread will be on waiting state at once
                    counter.notify();
                    break;
                }
                counter.print();
                //notify will work here as we're handling with only two threads and only one thread will be on waiting state at once
                counter.notify();
            }
        }
    }
}
