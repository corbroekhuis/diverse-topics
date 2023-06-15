package com.concurrency.filesearch;

import com.concurrency.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FileSearcher {

    public static void main(String[] args) {

        List<Callable<File>> callables = new ArrayList<>();

        callables.add(() -> (findInFolder("name1","folder")));
        callables.add(() -> (findInFolder("name2","folder")));
        callables.add(() -> (findInFolder("name3","folder")));
        callables.add(() -> (findInFolder("name4","folder")));
        callables.add(() -> (findInFolder("name5","folder")));
        callables.add(() -> (findInFolder("name6","folder")));
        callables.add(() -> (findInFolder("name7","folder")));

        ExecutorService service = Executors.newFixedThreadPool(3);

        List<Future<File>> futures = null;
        try {
            futures = service.invokeAll(callables);
            System.out.println( "Fist 'found' wins");
            File file = service.invokeAny(callables);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();
    }

    private static File findInFolder(String filename, String folder){

        int searchTime = ThreadLocalRandom.current().nextInt(1500, 3500);
        Util.wait(searchTime);

        System.out.println( "File: "  + filename + " found");

        return new File(filename);

    }
}

class File{

    private String name;

    public File(String filename) {
    }

    public String getName() {
        return name;
    }

}
