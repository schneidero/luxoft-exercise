import Constants.AppConstants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import com.google.common.base.Joiner;
import com.google.common.collect.Sets;


public class OutputWriter {

    private static final DecimalFormatSymbols DECIMAL_SYMBOLS = DecimalFormatSymbols.getInstance();

    public void writeOutput(List<CountResult> result){

        result.forEach(line -> {
            File outputFile = new File(AppConstants.outputFileName);
            FileOutputStream oFile = null;
            try {
                oFile = new FileOutputStream(outputFile, true);
                String formatted = formatResults(line);
                oFile.write(formatted.getBytes());
                oFile.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void createOutputFile(){
        File outputFile = new File(AppConstants.outputFileName);
        try {
            outputFile.createNewFile(); // if file already exists will do nothing
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String formatResults(CountResult result){
        return String.format(Locale.US, "({%s}, %d) -> %s",
                Joiner.on(", ").join(Sets.newTreeSet(result.getResult().getVowels())),
                result.getResult().getWordLength(),
                new DecimalFormat("#.##", DECIMAL_SYMBOLS).format(result.getVowelAverage()));
    }
}
