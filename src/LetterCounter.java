import java.io.*;

public class LetterCounter {
    private final int[] count = new int[26]; // Zählt A-Z

    public void count(Reader reader) throws IOException {
        int c;
        while ((c = nextCharacter(reader)) != -1) {
            char ch = Character.toUpperCase((char) c);
            if (ch >= 'A' && ch <= 'Z') count[ch - 'A']++;
        }
    }

    private int nextCharacter(Reader reader) throws IOException {
        int c;
        while ((c = reader.read()) == '\r'); // \r überspringen
        return c;
    }

    public void writeFrequencies(String filename) throws IOException {
        try (FileWriter fw = new FileWriter(filename)) {
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0) {
                    fw.write((char) ('A' + i) + ": " + count[i] + "\n");
                }
            }
        }
    }

    public void printHistogram() {
        System.out.println("Histogramm der Buchstabenhäufigkeit:");
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                System.out.printf("%c: %s (%d)%n", (char) ('A' + i), "*".repeat(count[i]), count[i]);
            }
        }
    }

    public char mostFrequentCharacter() {
        int maxIndex = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] > count[maxIndex]) maxIndex = i;
        }
        return (char) ('A' + maxIndex);
    }
}
