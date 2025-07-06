package multithreading.PrintUsingMThreads;

public class NumberPrinter implements Runnable{

    private final SharedClass sharedClass;
    private final int threadId;
    private int m; //total number of threads

    public NumberPrinter(SharedClass sharedClass, int threadId, int m) {
        this.sharedClass = sharedClass;
        this.threadId = threadId;
        this.m = m;
    }

    @Override
    public void run() {
        while (true){
            synchronized (sharedClass){
                while ((sharedClass.getCounter()-1) % m != threadId && sharedClass.getCounter() <= sharedClass.getMAX_VALUE()){
                    //using if condition will result in uneven result as if block will check condition only once and continues the flow when thread is notified.
                    //use while loop to check condition every time when thread is notified to awake.
                    //in simple terms, sharedClass.wait() will wait until (sharedClass.getCounter()-1) % m != threadId evaluates to true even after thread is notified
                    try {
                        sharedClass.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(sharedClass.getCounter() > sharedClass.getMAX_VALUE()){
                    //use notify to awake/notify one waiting thread to acquire lock on sharedClass and cannot guarantee which waiting thread will wake up
                    //use notifyAll to awake/notify all threads which are waiting to acquire lock on sharedClass
                    sharedClass.notifyAll();
                    break;
                }
                sharedClass.print();
                sharedClass.notifyAll();
            }
        }

    }
}
