package twoThread;

public class Consumer implements Runnable {
    Motion m;

    public Consumer(Motion m) {
        this.m = m;
    }
    @Override
    public void run() {
        try {
            m.consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
