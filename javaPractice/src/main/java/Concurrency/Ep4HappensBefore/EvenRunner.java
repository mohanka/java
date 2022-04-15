package Concurrency.Ep4HappensBefore;

import static java.lang.Thread.sleep;

public class EvenRunner implements Runnable {
     Counter counterObj;
    EvenRunner(Counter counterObj){
        this.counterObj = counterObj;
    }

    @Override
    public void run(){
        while(counterObj.currentCount<10){
            while(counterObj.currentCount %2 == 1){
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " Count : "+ counterObj.currentCount);
            counterObj.currentCount++;
        }
    }
}

