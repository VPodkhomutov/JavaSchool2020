package stopInterrupt;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread iThread = new Thread(new InfiniteThread());
        iThread.start();
        System.out.println("iThread запущен");
        Thread.sleep(2000);
        iThread.interrupt();
        iThread.join();
        System.out.println("Завершение программы");
    }
}
