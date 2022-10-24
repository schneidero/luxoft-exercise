import java.util.Objects;
import java.util.Set;

public class WordResult {

    private Set<Character> vowels;
    private int wordLength;

    private double vowelCount;

    public WordResult(Set<Character> vowels, int wordLength) {
        this.vowels = vowels;
        this.wordLength = wordLength;
        this.vowelCount = vowels.size();
    }

    public Set<Character> getVowels() {
        return vowels;
    }

    public void setVowels(Set<Character> vowels) {
        this.vowels = vowels;
    }

    public int getWordLength() {
        return wordLength;
    }

    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }

    public double getVowelCount() {
        return vowelCount;
    }

    public void setVowelCount(double vowelCount) {
        this.vowelCount = vowelCount;
    }




    @Override
    public int hashCode() {
        return Objects.hash(vowels, wordLength, vowelCount);
    }
}
