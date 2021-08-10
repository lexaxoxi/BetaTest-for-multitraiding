package task;

import java.util.ArrayList;
import java.util.List;


public class ThreadSageWithSynch {
    public static void main(String[] args) {
        List<Integer> randoms = new ArrayList<>();

        Producer producer = new Producer(randoms);
        Consumer consumer = new Consumer(randoms);

        producer.start();
        consumer.start();
    }
}
