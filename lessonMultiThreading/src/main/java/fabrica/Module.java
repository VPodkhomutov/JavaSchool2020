package fabrica;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

public class Module implements Runnable{
    private final CountDownLatch countDownLatch;
    private final ArrayBlockingQueue<VintDetail> queVintDet;

    public Module(CountDownLatch countDownLatch, ArrayBlockingQueue<VintDetail> queVintDet) {
        this.countDownLatch = countDownLatch;
        this.queVintDet = queVintDet;
    }

    @Override
    public void run() {
        System.out.println("Модуль готовится...");
        try {
            countDownLatch.await();
            queVintDet.put(VintDetail.module);
            System.out.println("Модуль готов, на складе "+queVintDet.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
