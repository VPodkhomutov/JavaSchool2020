package twoThread;

public class Main {
    public static void main(String[] args) {
        Motion m = new Motion();
        Thread producer = new Thread(new Producer(m));
        Thread consumer = new Thread(new Consumer(m));

        producer.start();
        consumer.start();

       // producer.join();
       // consumer.join();
    }
}
