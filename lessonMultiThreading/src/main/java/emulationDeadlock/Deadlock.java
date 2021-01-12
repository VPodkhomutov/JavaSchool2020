package emulationDeadlock;

public class Deadlock {
    private static final Object Table = new Object();
    private static final Object Fridge = new Object();

    public static void main(String args[]) {
        Thread tableFridge = new Thread(new ThreadTableFridge());
        Thread fridgeTable = new Thread(new ThreadFridgeTable());
        tableFridge.start();
        fridgeTable.start();
    }

    private static class ThreadTableFridge implements Runnable {
        public void run() {
            synchronized (Table) {
                System.out.println("Берем еду со стола");
                //если не тупить, то можно пробежать
                //а если чуток подумать, то точно кто-нибудь путь займет ))
                try { Thread.sleep(10); }
                catch (InterruptedException e) {e.printStackTrace();}
                System.out.println("Пытаемся пройти от стола до холодильника");
                synchronized (Fridge) {
                    System.out.println("Путь до холодильника свободен. Еда положена");
                }
            }
        }
    }
    private static class ThreadFridgeTable implements Runnable {
        public void run() {
            synchronized (Fridge) {
                System.out.println("Берем еду из холодильника");
                try { Thread.sleep(10); }
                catch (InterruptedException e) {e.printStackTrace();}
                System.out.println("Пытаемся выгнать всех из-за стола");
                synchronized (Table) {
                    System.out.println("Стол свободен. Еду можно ставить");
                }
            }
        }
    }
}