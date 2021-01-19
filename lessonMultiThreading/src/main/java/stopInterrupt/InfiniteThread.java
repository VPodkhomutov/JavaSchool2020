package stopInterrupt;

import java.math.BigInteger;

public class InfiniteThread implements Runnable {
    private boolean flag = true;
    private int i=0;


    @Override
    public void run() {
        while (flag) {
            i=i+1;
            //System.out.println("Текущее время:" + System.currentTimeMillis());
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Поток iThread остановлен c помощью interrupt");
                System.out.println(i);
                break;
            }
        }
    }
}
