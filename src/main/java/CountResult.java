import java.util.Objects;

public class CountResult {

    private WordResult result;

    private double vowelAverage;

    public CountResult(WordResult result, double vowelAverage) {
        this.result = result;
        this.vowelAverage = vowelAverage;
    }

    public WordResult getResult() {
        return result;
    }

    public void setResult(WordResult result) {
        this.result = result;
    }

    public double getVowelAverage() {
        return vowelAverage;
    }

    public void setVowelAverage(double vowelAverage) {
        this.vowelAverage = vowelAverage;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountResult that = (CountResult) o;
        return Double.compare(that.vowelAverage, vowelAverage) == 0 && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, vowelAverage);
    }

    @Override
    public String toString() {
        return "CountResult{" +
                "result=" + result +
                ", vowelAverage=" + vowelAverage +
                '}';
    }
}
