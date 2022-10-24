//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
//    private static final Logger logger = LoggerFactory.getLogger(FileReader.class);
    public Stream<String> readInputFile() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("input.txt").getFile());
            String data = FileUtils.readFileToString(file, "UTF-8");
            List<String> content = data.lines().flatMap(Pattern.compile("\\W+")::splitAsStream).collect(Collectors.toList());
//            logger.info(content);
            return content.stream();
        } catch (IOException e) {
//            logger.error("Error reading input file");
            return null;
        }
    }
}
