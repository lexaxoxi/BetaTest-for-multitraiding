package task;

import java.util.List;
import java.util.Random;

public class Producer extends Thread {
    private final List<Integer> randoms;

    int i;
    int numbers = 100;

    public Producer(List<Integer> randoms) {
        this.randoms = randoms;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (randoms) {
                for (i = 0; i < new Random().nextInt(numbers); i++) {
                    int newValue = new Random().nextInt(numbers);
                    randoms.add(newValue);
                    /*Для проверки метода Producer
                    System.out.println("add  " + newValue);

                     */
                }
                System.out.println("wrote");
                try {

                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        }
    }
}
