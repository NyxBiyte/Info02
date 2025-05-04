import java.io.*;

public class LetterCounterTest {
    public static void main(String[] args) throws IOException {
        testCount();
        testMostFrequent();
    }

    public static void testCount() throws IOException {
        String testString = "AaBbCc\ncCc";
        LetterCounter counter = new LetterCounter();
        counter.count(new StringReader(testString));

        counter.printHistogram();
        counter.writeFrequencies("frequency.txt");
    }

    public static void testMostFrequent() throws IOException {
        String testString = "AAaaBBccC";
        LetterCounter counter = new LetterCounter();
        counter.count(new StringReader(testString));

        System.out.println("Most frequent character: " + counter.mostFrequentCharacter());
    }
}
