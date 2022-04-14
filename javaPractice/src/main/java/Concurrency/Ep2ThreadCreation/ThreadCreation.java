package Concurrency.Ep2ThreadCreation;

public class ThreadCreation {
    public static void main(String[] args) {
        System.out.println("hello world from main thread");
        System.out.println("Main thread name : "+ Thread.currentThread().getName());

        MyThread myThreadObj = new MyThread();
        myThreadObj.setDaemon(true);
        myThreadObj.start();

        // METHOD 2: instantiate runnable by providing defn to abstract method
        Thread thread2 = new Thread(new RunnableConcreate(), "thread2");
        thread2.start();

        Runnable runnableObj = new Runnable() {
            @Override
            public void run() {
                System.out.println("New Thread started with name : "+ Thread.currentThread().getName());
                System.out.println("New Thread terminated");
                for(int i=0; i<5; i++){
                    System.out.println("timer : "+ i);
                }
            }
        };

        // METHOD 3: Anonymous inner class
        Thread thread3 = new Thread(runnableObj, "thread3");
        thread3.start();

        // METHOD 4: user java lambda for same above result
        Thread thread4 = new Thread(() -> {
            System.out.println("New Thread started with name : "+ Thread.currentThread().getName());
            System.out.println("New Thread terminated");
            for(int i=0; i<5; i++){
                System.out.println("timer : "+ i);
            }
        }, "thread4");
        thread4.start();

        System.out.println("main thread terminating");
    }

}
