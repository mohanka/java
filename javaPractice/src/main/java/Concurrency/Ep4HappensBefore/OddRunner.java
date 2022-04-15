package Concurrency.Ep4HappensBefore;

import static java.lang.Thread.sleep;

public class OddRunner implements Runnable {
     Counter counterObj;
    OddRunner(Counter counterObj){
        this.counterObj = counterObj;
    }

    @Override
    public void run(){
        while(counterObj.getCurrentCount() <10){
            while(counterObj.getCurrentCount() %2 == 0){
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " Count : "+ counterObj.getCurrentCount());
            counterObj.incrementCount();
        }
    }
}

