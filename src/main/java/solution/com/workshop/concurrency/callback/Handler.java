package solution.com.workshop.concurrency.callback;

public class Handler {

    Callback callback;
    Runnable runnable;

    public Handler(Callback callback) {
        this.callback = callback;
    }

    public void postRunnable( Runnable runnable){
        this.runnable = runnable;
    }

    public void execute(){

        performTask();
        callback.whenDone( "I'm done");

    }

    public void performTask(){

        runnable.run();

    }

}
