package multithreading.EvenOddPrinter;

public class Counter {
    private int maxNum = 10;
    private int count = 1;

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void print(){
        System.out.println("Value of count:"+ count + " printed from Thread:"+ Thread.currentThread().getName());
        count++;
    }

    public Counter(int maxNum){
        this.maxNum = maxNum;
    }
    public Counter(){
    }
}
