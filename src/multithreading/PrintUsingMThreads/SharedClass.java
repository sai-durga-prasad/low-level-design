package multithreading.PrintUsingMThreads;

public class SharedClass {

    private int counter = 1;
    private int MAX_VALUE = 10;

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public SharedClass(int MAX_VALUE) {
        this.MAX_VALUE = MAX_VALUE;
    }

    public void setMAX_VALUE(int MAX_VALUE) {
        this.MAX_VALUE = MAX_VALUE;
    }

    public int getCounter() {
        return counter;
    }

    public int getMAX_VALUE() {
        return MAX_VALUE;
    }

    public void print(){
        System.out.println("Value of count:"+ counter + " printed from Thread:"+ Thread.currentThread().getName());
        counter++;
    }
}
