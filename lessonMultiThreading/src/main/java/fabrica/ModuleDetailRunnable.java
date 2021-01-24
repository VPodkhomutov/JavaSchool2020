package fabrica;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

public class ModuleDetailRunnable implements Runnable {
    private  final CountDownLatch countDownLatch;
    private  final ModuleDetail moduleDetail;
    private  final ArrayBlockingQueue<ModuleDetail> queA;
    private  final ArrayBlockingQueue<ModuleDetail> queB;


    public ModuleDetailRunnable(ModuleDetail moduleDetail, CountDownLatch countDownLatch,  ArrayBlockingQueue<ModuleDetail> queA, ArrayBlockingQueue<ModuleDetail> queB) {
        this.moduleDetail = moduleDetail;
        this.countDownLatch = countDownLatch;
        this.queA = queA;
        this.queB = queB;
    }

    @Override
    public void run() {
        try {
            if (moduleDetail==ModuleDetail.DETAIL1) {
                System.out.println("Идем за деталью " + moduleDetail+" деталей на складе ="+ queA.size());
                queA.take();
            } else {
                System.out.println("Идем за деталью " + moduleDetail+" деталей на складе ="+ queB.size());
                queB.take();
            }
            //Thread.sleep(1500);
            System.out.println("Деталь взяли со склада " + moduleDetail);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
