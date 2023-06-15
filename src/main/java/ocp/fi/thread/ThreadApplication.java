package ocp.fi.thread;

public class ThreadApplication {

    public static void main(String[] args) {

        ThreadApplication threadApplication = new ThreadApplication();

        // Record starting time
        long start = System.currentTimeMillis();

        System.out.println(Thread.currentThread());

        // Stop the current thread to pause for 10 seconds
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display total execurion time in millisecs
        System.out.println( "Execution time: " + (System.currentTimeMillis() - start));

        // (Anonymous) inner class 'the old way, before lambda's'
        Runnable runnable = new Runnable(){

            @Override
            public void run() {
                System.out.println("Inside run...");
                System.out.println(Thread.currentThread());
            }

        };

        // Start runnable in new Thread
        // Note: This is an asynchronous process (parrallel to main thread)
        Thread thread = new Thread(runnable);
        thread.start();

        Runnable runnable2 = () -> System.out.println("Hallo");

        Thread thread2 = new Thread(runnable2);
        thread2.start();

        // Start MyRunnable (implements Runnable in new thread
        // MyRunnable can do a callback to this class
        // This can be very useful
        MyRunnable myRunnable = new MyRunnable("Kevin", threadApplication);
        Thread thread3 = new Thread(myRunnable);
        thread3.start();

    }

    // Callback method that is called from MyRunnable
    public void callBack(String message){

        System.out.println(message);
    }

}
