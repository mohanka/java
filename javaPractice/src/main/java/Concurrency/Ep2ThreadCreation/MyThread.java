package Concurrency.Ep2ThreadCreation;

// Way 1: create a new class thread and define override run method. Don't need to override as method already
// default virtual in thread class
public class MyThread extends Thread {
    @Override
    public void run(){
        System.out.println("New Thread started");
        System.out.println("New Thread terminated");
        for(int i=0; i<5; i++){
            System.out.println("timer : "+ i);
        }
    }

}
