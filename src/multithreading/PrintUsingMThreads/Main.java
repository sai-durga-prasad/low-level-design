package multithreading.PrintUsingMThreads;


public class Main {
    public static void main(String[] args) {
        SharedClass counter = new SharedClass(20);
        int m = 3;

        for(int i=0; i<m; i++){
            Thread thread = new Thread(new NumberPrinter(counter, i, m), "threadId:"+i);
            thread.start();
        }
    }
}
