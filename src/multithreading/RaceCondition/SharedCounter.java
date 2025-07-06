package multithreading.RaceCondition;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedCounter {
    AtomicInteger count = new AtomicInteger(0);

    public AtomicInteger getCount() {
        return count;
    }

    public void setCount(AtomicInteger count) {
        this.count = count;
    }
}
