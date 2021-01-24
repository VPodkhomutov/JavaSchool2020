package fabrica;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Integer cicle= 5;
        ArrayBlockingQueue<VintDetail> skladDetailVint = new ArrayBlockingQueue<>(10);
        ArrayBlockingQueue<ModuleDetail> skladDetailA = new ArrayBlockingQueue<>(10);
        ArrayBlockingQueue<ModuleDetail> skladDetailB = new ArrayBlockingQueue<>(10);
        ArrayBlockingQueue<VintDetail> skladDetailC = new ArrayBlockingQueue<>(10);

        ExecutorService es = Executors.newFixedThreadPool(3);
        for (int i = 0; i < cicle; i++) {
            for (ModuleDetail md : ModuleDetail.values()) {
                es.submit(() -> {
                    if (md == ModuleDetail.DETAIL1) {
                        try {
                            System.out.println("Готовим деталь 1");
                            skladDetailA.put(md);
                            Thread.sleep(1000);
                            //System.out.println("Деталей A на складе= "+skladDetailA.size());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            System.out.println("Готовим деталь 2");
                            skladDetailB.put(md);
                            Thread.sleep(2000);
                            //System.out.println("Деталей B на складе= "+skladDetailB.size());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }

        ExecutorService esModule = Executors.newFixedThreadPool(3);
        for (int z = 0; z < cicle; z++) {
            CountDownLatch countDownLatch = new CountDownLatch(ModuleDetail.values().length);
            esModule.submit(new Module(countDownLatch, skladDetailVint));
            for (ModuleDetail mde : ModuleDetail.values()) {
                esModule.submit(new ModuleDetailRunnable(mde, countDownLatch, skladDetailA, skladDetailB));
            }
        }

        ExecutorService esVint = Executors.newFixedThreadPool(6);
        CyclicBarrier cb = new CyclicBarrier(2, ()->{
            System.out.println("Винт готов");
            System.out.println("Проверка правильного расходования деталей");
            System.out.println(skladDetailA.size());
            System.out.println(skladDetailB.size());
            System.out.println(skladDetailC.size());
            System.out.println(skladDetailVint.size());
        });
        for (int z = 0; z < cicle; z++) {
            for (VintDetail vd : VintDetail.values()) {
                esVint.submit(new Vintik(skladDetailVint, skladDetailC, vd, cb));
            }
        }
        es.shutdown();
        esModule.shutdown();
        esVint.shutdown();

        Thread.sleep(20000);
        System.out.println("Проверка правильного расходования деталей");
        System.out.println(skladDetailA.size());
        System.out.println(skladDetailB.size());
        System.out.println(skladDetailC.size());
        System.out.println(skladDetailVint.size());
    }

}

