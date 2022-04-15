package Concurrency.Ep4HappensBefore;

import static java.lang.Thread.sleep;

public class EvenRunner implements Runnable {
     Counter counterObj;
    EvenRunner(Counter counterObj){
        this.counterObj = counterObj;
    }

    @Override
    public void run(){
        while(counterObj.getCurrentCount()<10){
            while(counterObj.getCurrentCount() %2 == 1){
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

