package fabrica;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Vintik implements Runnable {
    private final ArrayBlockingQueue<VintDetail> queVintDet;
    private final ArrayBlockingQueue<VintDetail> queC;
    private final VintDetail vintDetail;
    private final CyclicBarrier cyclicBarrier;

    public Vintik(ArrayBlockingQueue<VintDetail> queVintDet, ArrayBlockingQueue<VintDetail> queC, VintDetail vintDetail, CyclicBarrier cyclicBarrier) {
        this.queVintDet = queVintDet;
        this.queC = queC;
        this.vintDetail = vintDetail;
        this.cyclicBarrier = cyclicBarrier;
    }



    @Override
    public void run() {
        try {
            if (vintDetail==VintDetail.detailC) {
                queC.put(vintDetail);
                System.out.println("Готова деталь С. на складе "+queC.size());
                Thread.sleep(3000);
            }
            if (vintDetail==VintDetail.module) {
                System.out.println("Взяли модуль. на складе  "+ queVintDet.size());
                queVintDet.take();
                cyclicBarrier.await();
               // System.out.println("Идем за C ");
               // queC.take();
               //System.out.println("Винт готов");
            }
            if (vintDetail==VintDetail.sborka) {
                System.out.println("Взяли C ");
                queC.take();
                cyclicBarrier.await();
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
