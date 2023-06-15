package solution.com.workshop.concurrency.callback;

public class Application implements Callback{

    public static void main(String[] args) {

        new Application().run();

    }

    private void run() {

    	Runnable runnable = () -> System.out.println("Doing work");
        Handler handler = new Handler(this);
        handler.postRunnable( runnable);
        handler.execute();

    }

    @Override
    public void whenDone( String message) {
        System.out.println(message);
    }

}
