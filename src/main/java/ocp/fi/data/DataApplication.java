package ocp.fi.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class DataApplication {

    public static void main(String[] args) throws IOException {

        DataApplication dataApplication = new DataApplication();

        // Put all files in data.zip in folder C:\Temp\data
        Stream<Path> pathStream = Files.list( Paths.get("C:/Temp/data"));

        long start = System.currentTimeMillis();

        // Note:
        // We start with a stream of Paths (files).
        // the map function maps one item of the stream to a single other item.
        // I.e:    "2","3","4","5","6"  is mapped to 2,3,4,5
        // In our case the result of method dataApplication.getAllLines is a stream of Strings for every Path item
        // So, every Path is mapped to a stream which is not a single item. We must use the flatMap to
        // 'flatten' the returned streams.
        // Stream(Path1,Path2,Path2) --> getAllLines( Path1,Path2,Path2) --> Stream1<String>,Stream2<String>,Stream3<String>
        // flatMap( Stream1<String>,Stream2<String>,Stream3<String>) --> Stream<String> = String1,String2,String3,...
        // compare to putting the elements of multiple Lists into one single list

        Optional<String> s = pathStream
         //       .parallel()        // May be faster because the work is assigned to multiple cpus
                .filter(f -> !f.toFile().isDirectory())
                .filter( f -> !f.getFileName().getFileName().endsWith(".txt"))
         //       .peek( f -> System.out.println( f))
                .flatMap( f -> dataApplication.getAllLines( f))
                .filter( l -> l.contains("34567899999999876543"))
                .findFirst();

        System.out.println( "Execution time: " + (System.currentTimeMillis() - start));

        System.out.println( s);

    }

    private Stream<String> getAllLines(Path path){

        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines.stream();
    }

}
