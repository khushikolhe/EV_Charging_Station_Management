package evcharging.thread;

public class ThreadTest {
    public static void main(String[] args) {
        ChargingTask task = new ChargingTask();
        Thread chargingThread = new Thread(task);
        System.out.println("Before start: " + chargingThread.isAlive());
        chargingThread.start();
        System.out.println("After start: " + chargingThread.isAlive());
        try {
            chargingThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("After completion: " + chargingThread.isAlive());
        System.out.println("Main program completed.");
    }
}