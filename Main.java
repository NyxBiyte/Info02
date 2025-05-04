import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main {
    public static void main(String[] args) {
        try {
            // Dateiauswahlfenster öffnen
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Bitte eine Textdatei auswählen");

            // Optional: Nur .txt-Dateien anzeigen
            fileChooser.setFileFilter(new FileNameExtensionFilter("Textdateien (*.txt)", "txt"));

            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("Ausgewählte Datei: " + selectedFile.getAbsolutePath());

                // Datei einlesen
                BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                LetterCounter counter = new LetterCounter();
                counter.count(reader);
                reader.close();

                // Histogramm anzeigen
                counter.printHistogram();

                // Frequenzen in Datei schreiben
                counter.writeFrequencies("frequency.txt");
                System.out.println("\nDie Frequenzen wurden in 'frequency.txt' gespeichert.");
            } else {
                System.out.println("Keine Datei ausgewählt. Programm wird beendet.");
            }
        } catch (IOException e) {
            System.err.println("Ein Fehler ist aufgetreten: " + e.getMessage());
        }
    }
}
