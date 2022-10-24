import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Application {

    public static void main(String... args){
        // Read Input file
        FileReader reader = new FileReader();
        Stream<String> contents = reader.readInputFile();
        Counter counter = new Counter();
        List<CountResult> resultList = counter.countVowels(contents);
        List<CountResult> groupedList = counter.groupedAverages(resultList);
        OutputWriter outputWriter = new OutputWriter();
        outputWriter.createOutputFile();
        outputWriter.writeOutput(groupedList);
    }

}
