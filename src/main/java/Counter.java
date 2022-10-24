import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;

public class Counter {
    private final static ArrayList<Character> VOWELS = new ArrayList<>(Arrays.asList('a','e','i','o','u'));

    public List<CountResult> countVowels(Stream<String> allWords){
        List<CountResult> results = allWords.map(word -> {
            List<Character> vowels = word.chars()
                    .map(Character::toLowerCase)
                    .mapToObj(c -> (char) c)
                    .filter(VOWELS::contains)
                    .collect(Collectors.toList());
            return new CountResult(new WordResult( new HashSet<>(vowels), word.length()), vowels.size());
        }).collect(Collectors.toList());
        return results;
    }

    public List<CountResult> groupedAverages(List<CountResult> ungroupedResults){
        return  ungroupedResults.stream().collect(groupingBy(CountResult::getResult, averagingDouble(CountResult::getVowelAverage))).entrySet()
                .stream().map(entry -> new CountResult(entry.getKey(), entry.getValue())).collect(Collectors.toList());
    }
}
