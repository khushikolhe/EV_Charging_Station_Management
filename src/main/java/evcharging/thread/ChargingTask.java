package evcharging.thread;

public class ChargingTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Charging started using Runnable...");

        for (int i = 10; i <= 100; i += 10) {
            System.out.println("Charging: " + i + "%");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Charging interrupted.");
            }
        }

        System.out.println("Charging completed!");
    }
}