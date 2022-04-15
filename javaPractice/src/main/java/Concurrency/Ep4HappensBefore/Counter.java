package Concurrency.Ep4HappensBefore;


public class Counter {
    public volatile int currentCount;
    Counter(){
        currentCount = 1;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Printing count");

        Counter counterObj = new Counter();
        Thread oddThread = new Thread(new OddRunner(counterObj), "oddThread");
        Thread evenThread = new Thread(new EvenRunner(counterObj), "evenThread");

        oddThread.start();
        evenThread.start();

        oddThread.join();
        evenThread.join();
        System.out.println("Completed count");
    }
}
