package multithreading.RaceCondition;


public class Printer implements Runnable{
    private SharedCounter counter;

    public Printer(SharedCounter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000000; i++) {
            //We can resolve Race Condition by 2 approaches.
            //1. using synchronized keyword.
            // 2. volatile keyword (count++ operation is not atomic even though volatile keyword work perfectly fine)
            // 3.Using Atomic Classes

            //two properties of synchronized block
            //1. At the time of entering the synchronized block, all the variables which are visible to the thread, their latest values are fetched from the main memory.
            //2. As soon as a thread leaves the synchronized block, values of the variables which are visible the thread, will be flushed to main memory.
//            synchronized (counter){
//                counter.count++;
//            }

            counter.getCount().incrementAndGet(); //AtomicInteger is designed to maintain atomicity of operation
        }
    }
}
