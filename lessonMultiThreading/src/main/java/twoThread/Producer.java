package twoThread;

public class Producer implements Runnable {
    Motion m;

    public Producer(Motion m) {
        this.m = m;
    }

    @Override
    public void run() {
        try {
            m.produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
