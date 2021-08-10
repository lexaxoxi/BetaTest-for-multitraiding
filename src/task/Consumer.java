package task;

import java.util.List;

public class Consumer extends Thread {

    private final List<Integer> randoms;

    public Consumer(List<Integer> randoms) {
        this.randoms = randoms;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (randoms) {
                for (int i = 0; i < randoms.size(); i++) {

                    System.out.println(randoms.remove(i));
                }
                if (randoms.isEmpty()) {
                    System.out.println("read  \n" + "Empty ArrayList...Waiting");
                    try {
                        randoms.wait(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("read");

            }
        }
    }
}


