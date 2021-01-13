package twoThread;

import java.util.Random;

public class Motion {
    private final Object WAREHOUSE = new Object();
    private final int MAXDETAIL = 10;
    private int tempDetail = 0;

    public void produce() throws InterruptedException {
        while(true){
            synchronized (WAREHOUSE){
                if (tempDetail==MAXDETAIL){
                    WAREHOUSE.wait();
                }
                tempDetail++;
                System.out.println("Producer принес деталь. Количество деталей на складе: "+tempDetail);
                WAREHOUSE.notify();
            }
            Thread.sleep(300);
        }
    }

    public  void consume() throws InterruptedException {
        Random random = new Random();
        while(true){
            synchronized (WAREHOUSE){
                if (tempDetail==0){
                WAREHOUSE.wait();
                }
                tempDetail--;
                System.out.println("Consumer забрал деталь. Количество деталей на складе: "+tempDetail);
                if (random.nextInt(9)<=3) {
                    WAREHOUSE.notify();
                }
            }
            Thread.sleep(500);
        }
    }
}
