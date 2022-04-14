package Concurrency.Ep2ThreadCreation;

//Method 2: implement runnable and use Thread constructor
public class RunnableConcreate implements Runnable{
    @Override
    public void run(){
        System.out.println("New Thread started");
        System.out.println("New Thread terminated");
        for(int i=0; i<5; i++){
            System.out.println("timer : "+ i);
        }
    }
}
